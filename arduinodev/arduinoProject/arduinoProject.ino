#include <SPI.h>
#include <Phpoc.h>
#include <Adafruit_MLX90614.h>
#include <Wire.h>

PhpocClient client;
const int moduleId = 0;
Adafruit_MLX90614 mlx = Adafruit_MLX90614();          // tempSensor
int issue = 0;                                        // event 구분을 위한 issue 값
boolean flag = true;                                  // 논리계산을 위한 flag

// serverConnection
char server_name[] = "192.168.0.35";
unsigned long lastConnectionTime = 0;
const unsigned long postingInterval = 10L * 1000L;    // 주기작업 10초
String url = "";

// pin
const int laserPin = 7;
const int ledRedPin = 13;
const int ledGreenPin = 12;
const int ledYellowPin = 11;
const int ledPin = 10;
const int smokeSensorPin = A15;
const int fireSensorPin = A13;
const int gyroSensorPin = A11;

// value
float tempVal = 0;
const float tempHigh = 60.0;                        // 화재발생 시 온도값(high)
int smokeVal;
const int smokeLow = 500;                           // 화재발생 시 가스농도 값(low)
int fireVal;
const int fireLow = 500;                            // 화재발생 시 불꽃센서 값(low)
int gyroVal;
const int gyroLow = 100;                            // 지진발생 시 진동 값(low)

void event(){
  if((tempVal >= tempHigh) || (smokeVal <= smokeLow) || (fireVal <= fireLow)){
    if(gyroVal <= gyroLow){
      issue = 3;                                    // 화재, 지진발생 시 issue값
      Serial.println("STATE : FIRE/EARTHQUAKE");
      Serial.println();
    }else{
      issue = 1;                                    // 화재발생 시 issue값
      Serial.println("STATE : FIRE");
      Serial.println();
    }
  }else{
    if(gyroVal <= gyroLow){                         // 지진발생 시 issue값
      issue = 2;
      Serial.println("STATE : EARTHQUAKE");
      Serial.println();
    }else{
    issue = 0;                                      // 평상 시 normal issue값
    Serial.println("STATE : NORMAL");
    Serial.println();
    }  
  }
}

void monitoring(){
  Serial.print("TEMP : "); Serial.print(tempVal); Serial.println("*C");
  Serial.print("SMOKE : ");Serial.println(smokeVal);
  Serial.print("FIRE : ");Serial.println(fireVal);
  Serial.print("GYRO : ");Serial.println(gyroVal);
}

// event발생 시 led, laser작동제어
void operate(){
  switch(issue){
    case 0:
      digitalWrite(laserPin, LOW);
      digitalWrite(ledRedPin, LOW);
      digitalWrite(ledGreenPin, HIGH);
      digitalWrite(ledYellowPin, LOW);
      break;
    case 1:
      digitalWrite(laserPin, HIGH);
      digitalWrite(ledRedPin, HIGH);
      digitalWrite(ledGreenPin, LOW);
      digitalWrite(ledYellowPin, LOW);
      break;
    case 2:
      digitalWrite(laserPin, LOW);
      digitalWrite(ledRedPin, LOW);
      digitalWrite(ledGreenPin, LOW);
      digitalWrite(ledYellowPin, HIGH);
      break;
    case 3:
      digitalWrite(laserPin, HIGH);
      digitalWrite(ledRedPin, HIGH);
      digitalWrite(ledGreenPin, LOW);
      digitalWrite(ledYellowPin, HIGH);
      break;
  }
}

void sensing(){
  tempVal = mlx.readObjectTempC();                         // 온도값
  smokeVal = analogRead(smokeSensorPin);
  fireVal = analogRead(fireSensorPin);
  gyroVal = analogRead(gyroSensorPin);
  event();
  operate();
}

void setup() {
  Serial.begin(9600);
  
  // module
  pinMode(laserPin, OUTPUT);
  mlx.begin();                                            // tempSensor
  pinMode(ledRedPin, OUTPUT);
  pinMode(ledGreenPin, OUTPUT);
  pinMode(ledYellowPin, OUTPUT);
  pinMode(ledPin, OUTPUT);

  // connection
  Phpoc.begin(PF_LOG_SPI | PF_LOG_NET);
}

void httpRequest() {
  // close any connection before send a new request.
  client.stop();                                          // WiFI shield socket을 자유롭게 하기 위함
  digitalWrite(ledPin, HIGH);
  lastConnectionTime = millis();                          // 주기작업을 위해 현재시간을 변수에 저장
  
  // if there's a successful connection:
  if (client.connect(server_name, 9999)) {
      Serial.println("connecting...");      
      client.println(url);                                // send the HTTP PUT request:
      client.println();
      flag = false;
  } else {
    // if you couldn't make a connection:
      Serial.println("connection failed");
      flag = false;                                      // 연결이 끊겨도 센싱을 재시작하기 위한 로직
  }
}

void loop() {
  digitalWrite(ledPin, LOW);
  if( !flag ){
    while ( client.available() ) {
      Serial.println(client.available());
      char c = client.read();
//      Serial.write(c);                                // 서버로부터 응답받은 값
    }
    flag = true;
  }
  if(flag){
    sensing();
    monitoring();
  }

  // 10초 주기작업 or event발생 시 서버로 데이터 보냄
  if ( ( (millis() - lastConnectionTime > postingInterval) || issue == 1 || issue == 2 || issue == 3 ) && flag ){
    url = "GET /module/eventIn.do?module_id=";
    url += moduleId;                                    // 모듈의 고유 id값
    // 현재 센싱중인 센서 값들
    url += "&temp=" + String(tempVal);
    url += "&smoke=" + String(smokeVal);
    url += "&gyro=" + String(gyroVal);
    url += "&fire=" + String(fireVal);
    url += "&issue=" + String(issue);
    url += " HTTP/1.0";
    Serial.print("url: ");
    Serial.println(url); 
    httpRequest();                                      // 서버로 데이터 보내기
  }
   delay(500);
}
