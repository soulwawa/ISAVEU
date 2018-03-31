#include <Adafruit_MLX90614.h>
#include <Wire.h>
#include <SPI.h>
#include <Phpoc.h>

Adafruit_MLX90614 mlx = Adafruit_MLX90614();

// SERVER
char server_name[] = "192.168.0.35";
unsigned long lastConnectionTime = 0;
const unsigned long postingInterval = 10L * 1000L;
PhpocClient client;
String url = "";
boolean flag = true;         
boolean flag1 = true;

// LASER
const int laserPin = 7;
// LED
const int ledRedPin = 13;
const int ledGreenPin = 12;
const int ledYellowPin = 11;
const int ledPin = 10;

// TEMP
float tempAmbient = 0;
float tempObject = 0;
const float tempHigh = 40.0;                            // 화재 발생 시 온도
// SMOKE
const int smokeSensorPin = A15;
int smokeVal;
const int smokeHigh = 1000;                            // 화재 발생 시 가스농도
// FIRE
const int fireSensorPin = A13;
int fireVal;
const int fireLow = 500;                                // 화재 발생 시 불꽃감지 값
// GYRO
const int gyroSensorPin = A11;
int gyroVal;
const int gyroLow = 500;                                // 지진 발생 시 진동 값

// ISSUE
int issue = 0;

void monitoring(){
  Serial.print("TEMP : "); Serial.print(tempObject);
//  Serial.print("*C\tOBJTEMP : "); Serial.print(tempAmbient);
  Serial.println("*C");
  Serial.print("SMOKE : ");
  Serial.println(smokeVal);
  Serial.print("GYRO : ");
  Serial.println(gyroVal);
  Serial.print("FIRE : ");
  Serial.println(fireVal);
}

void sensing(){
  tempAmbient = mlx.readAmbientTempC();                           // 주변온도 감지
  tempObject = mlx.readObjectTempC();                             // 대상온도 감지
  smokeVal = analogRead(smokeSensorPin);
  gyroVal = analogRead(gyroSensorPin);
  fireVal = analogRead(fireSensorPin);
}

void event(){
  if(issue == 0){
    if((tempObject >= tempHigh) || (smokeVal >= smokeHigh) || (fireVal <= fireLow)){
      if(gyroVal <= gyroLow){
        sending();
        issue = 3;
        digitalWrite(laserPin, HIGH);
        digitalWrite(ledRedPin, HIGH);
        digitalWrite(ledGreenPin, LOW);
        digitalWrite(ledYellowPin, HIGH);
    
        Serial.println("STATE : F/E");
        Serial.println();
      }else{
        sending();
        issue = 1;
        digitalWrite(laserPin, HIGH);
        digitalWrite(ledRedPin, HIGH);
        digitalWrite(ledGreenPin, LOW);
        digitalWrite(ledYellowPin, LOW);
    
        Serial.println("STATE : FIRE");
        Serial.println();
      }
    }else{
      if(gyroVal <= gyroLow){
        sending();
        issue = 2;
        digitalWrite(laserPin, LOW);
        digitalWrite(ledRedPin, LOW);
        digitalWrite(ledGreenPin, LOW);
        digitalWrite(ledYellowPin, HIGH);
    
        Serial.println("STATE : EARTHQUAKE");
        Serial.println();
      }else{
        issue = 0;
        noTone(8);
        digitalWrite(laserPin, LOW);
        digitalWrite(ledRedPin, LOW);
        digitalWrite(ledGreenPin, HIGH);
        digitalWrite(ledYellowPin, LOW);
        
        Serial.println("STATE : NORMAL");
        Serial.println();
      }
    }
  }
}

void setup() {
  Serial.begin(9600);

// LASER
  pinMode(laserPin, OUTPUT);
// TEMP
  mlx.begin();
// LED
  pinMode(ledRedPin, OUTPUT);
  pinMode(ledGreenPin, OUTPUT);
  pinMode(ledYellowPin, OUTPUT);
  pinMode(ledPin, OUTPUT);  

// PHPOC
  Serial.println("Sending GET request to web server");    
  Phpoc.begin(PF_LOG_SPI | PF_LOG_NET);
}

// CONNECT
void httpRequest() {
  client.stop();
  digitalWrite(ledPin, LOW);
  lastConnectionTime = millis();
  
  if (client.connect(server_name, 9999)) {
    Serial.println("connecting...");
    client.println(url);
    client.println();
    
    flag = false;
    digitalWrite(ledPin, HIGH);
  } else {
    Serial.println("connection failed");
  }
}

// SEND DATA1
void cycling(){
  if ( ( (millis() - lastConnectionTime > postingInterval) && flag ) ){
    url = "GET /eventIn.do?module_id=1";
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
}

// SEND DATA2
void sending(){
    url = "GET /eventIn.do?module_id=1";
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

void loop() {
  if (client.available()) {
//    char c = client.read();
//    Serial.print(c);
  }

  // if the server's disconnected, stop the client:
  if (!client.connected()) {
    Serial.println();
    Serial.println("disconnecting.");
    client.stop();

    // do nothing forevermore:
    for(;;)
      ;
  }



  
  if( !flag ){
    flag1 = false;
    while ( client.available() ) {
      flag1 = true;
//      char c = client.read();         // 서버로부터 받은 값
//      Serial.write(c);
    }
    if(flag1){
      flag = true;
      }
  }
  
  if(flag){
    sensing();
    monitoring();
    
    event();
    cycling();
    
    issue = 0;
  } 
   
   delay(500);
}
