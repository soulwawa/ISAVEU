#include <Adafruit_MLX90614.h>
#include <Wire.h>
#include <SPI.h>
#include <Phpoc.h>

Adafruit_MLX90614 mlx = Adafruit_MLX90614();

// 서버접속
char server_name[] = "192.168.0.35";
unsigned long lastConnectionTime = 0;               // last time you connected to the server, in milliseconds
const unsigned long postingInterval = 10L * 1000L;  // delay milliseconds
PhpocClient client;
String url = "";

// laser
const int laserPin = 7;
// led
const int ledRedPin = 13;
const int ledGreenPin = 12;
const int ledYellowPin = 11;
const int ledPin = 10;
// temp
float tempAmbient = 0;
float tempObject = 0;
const float tempHigh = 40.0;                        // 화재 발생 시 온도
// smoke
const int smokeSensorPin = A15;
int smokeVal;
const int smokeHigh = 1000;                         // 화재 발생 시 가스농도
// fire
const int fireSensorPin = A13;
int fireVal;
const int fireLow = 500;                            // 화재 발생 시 불꽃감지 값
// gyro
const int gyroSensorPin = A11;
int gyroVal;
const int gyroLow = 0;                           // 지진 발생 시 진동 값
// issue
int issue = 0;

void monitoring(){
  Serial.print("AMBTEMP : "); Serial.print(tempAmbient);
  Serial.print("*C\tOBJTEMP : "); Serial.print(tempObject);
  Serial.println("*C");
  Serial.print("SMOKE : ");
  Serial.println(smokeVal);
  Serial.print("GYRO : ");
  Serial.println(gyroVal);
  Serial.print("FIRE : ");
  Serial.println(fireVal);
}
void sensing(){
  tempAmbient = mlx.readAmbientTempC();       // 주변온도 감지
  tempObject = mlx.readObjectTempC();         // 대상온도 감지
  smokeVal = analogRead(smokeSensorPin);
  gyroVal = analogRead(gyroSensorPin);
  fireVal = analogRead(fireSensorPin);
}

void event(){
  if(issue == 0){
    if((tempObject >= tempHigh) || (smokeVal >= smokeHigh) || (fireVal <= fireLow)){
      if(gyroVal <= gyroLow){
        issue = 3;
        digitalWrite(laserPin, HIGH);
        digitalWrite(ledRedPin, HIGH);
        digitalWrite(ledGreenPin, LOW);
        digitalWrite(ledYellowPin, HIGH);
    
        Serial.println("StATE : F/E");
        Serial.println();
      }else{
        issue = 1;
        digitalWrite(laserPin, HIGH);
        digitalWrite(ledRedPin, HIGH);
        digitalWrite(ledGreenPin, LOW);
        digitalWrite(ledYellowPin, LOW);
    
        Serial.println("STATE : F");
        Serial.println();
      }
    }else{
      if(gyroVal <= gyroLow){
        issue = 2;
        digitalWrite(laserPin, LOW);
        digitalWrite(ledRedPin, LOW);
        digitalWrite(ledGreenPin, LOW);
        digitalWrite(ledYellowPin, HIGH);
    
        Serial.println("STATE : E");
        Serial.println();
      }else{
        issue = 0;
        digitalWrite(laserPin, LOW);
        digitalWrite(ledRedPin, LOW);
        digitalWrite(ledGreenPin, HIGH);
        digitalWrite(ledYellowPin, LOW);
        
        Serial.println("STATE : N");
        Serial.println();
      }
    }
  }
}

void setup() {
  Serial.begin(9600);

// laser
  pinMode(laserPin, OUTPUT);
// temp
  mlx.begin();
// led
  pinMode(ledRedPin, OUTPUT);
  pinMode(ledGreenPin, OUTPUT);
  pinMode(ledYellowPin, OUTPUT);
  pinMode(ledPin, OUTPUT);
// wifi
  Serial.println("Sending GET request to web server");    
  Phpoc.begin(PF_LOG_SPI | PF_LOG_NET);
}

boolean flag = true;          //send check boolean
boolean flag1 = true;         //send check boolean

// 서버 접속
void httpRequest() {
  // close any connection before send a new request.
  // This will free the socket on the WiFi shield
  client.stop();
  lastConnectionTime = millis();
  
  // if there's a successful connection:
  if (client.connect(server_name, 9999)) {
    Serial.println("connecting...");      
    client.println(url); // send the HTTP PUT request:
    client.println();
    // note the time that the connection was made:  
     flag = false;
     digitalWrite(ledPin, HIGH);
  } else {
//     if you couldn't make a connection:
    Serial.println("connection failed");
  }
}

void loop() {
  if( !flag ){
    flag1 = false;
    while ( client.available() ) {
      flag1 = true;
      char c = client.read();
      Serial.write(c);
    }
    if(flag1){
      flag = true;
      }
  }
  if(flag){
    sensing();
    monitoring();
    event();
  }

const int moduleId = 1;

// 서버접속
  if ( ((millis() - lastConnectionTime > postingInterval) && flag ||( (issue == 1) || (issue == 2) || (issue == 3) ) ) ){
    url = "GET /eventIn.do?module_id=";
    url += moduleId;
    url += "&temp=" + String(tempObject);
    url += "&smoke=" + String(smokeVal);
    url += "&gyro=" + String(gyroVal);
    url += "&fire=" + String(fireVal);
    url += "&issue=" + String(issue);
    url += " HTTP/1.0";
    Serial.print("url: ");
    Serial.println(url);
    
    httpRequest();
  }
   digitalWrite(ledPin, LOW);
   issue = 0;
   delay(500);
}
