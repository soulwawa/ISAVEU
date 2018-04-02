#include <Phpoc.h>
#include <SPI.h>
#include <Adafruit_MLX90614.h>
#include <Wire.h>

PhpocClient client;
Adafruit_MLX90614 mlx = Adafruit_MLX90614();

// CONNECTION
char server[] = "192.168.0.35";
unsigned long lastConnectionTime = 0;
const unsigned long postingInterval = 10L * 1000L;
String url = "";

const int laserPin = 7;
const int ledRedPin = 13;
const int ledGreenPin = 12;
const int ledYellowPin = 11;
const int ledPin = 10;

float tempAmbient = 0;
float tempObject = 0;
const float tempHigh = 40.0;                            // 화재 발생 시 온도

const int smokeSensorPin = A15;
int smokeVal;
const int smokeHigh = 1000;                            // 화재 발생 시 가스농도

const int fireSensorPin = A13;
int fireVal;
const int fireLow = 500;                                // 화재 발생 시 불꽃감지 값

const int gyroSensorPin = A11;
int gyroVal;
const int gyroLow = 500;                                // 지진 발생 시 진동 값

int issue = 0;

boolean flag = true;         
boolean flag1 = true;

void sensing(){
  tempAmbient = mlx.readAmbientTempC();
  tempObject = mlx.readObjectTempC();
  Serial.print("TEMP : "); Serial.print(tempObject);
  Serial.println("*C");
//  Serial.print("*C\tOBJTEMP : "); Serial.print(tempAmbient);
  smokeVal = analogRead(smokeSensorPin);
  Serial.print("SMOKE : ");
  Serial.println(smokeVal);
  fireVal = analogRead(fireSensorPin);
  Serial.print("FIRE : ");
  Serial.println(fireVal);
  
  gyroVal = analogRead(gyroSensorPin);
  Serial.print("GYRO : ");
  Serial.println(gyroVal);
  
  if((tempObject >= tempHigh) || (smokeVal >= smokeHigh) || (fireVal <= fireLow)){
      if(gyroVal <= gyroLow){
        issue = 3;
      }else{
        issue = 1;
      }
    }else{
      if(gyroVal <= gyroLow){
        issue = 2;
      }else{
        issue = 0;
      }
    }
  }

const int moduleId = 1;

// CONNECTION
void httpRequest() {
  client.stop();
  lastConnectionTime = millis();
  digitalWrite(ledPin, LOW);
  
  if (client.connect(server, 9999)) {
    Serial.println("connecting...");
    digitalWrite(ledPin, HIGH);
    client.println(url);
    client.println();
    flag = false;
    
  } else {
    Serial.println("connection failed");
  }
}

void sending(){
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

void event(){
  switch(issue){
    case 0:
        noTone(8);
        digitalWrite(laserPin, LOW);
        digitalWrite(ledRedPin, LOW);
        digitalWrite(ledGreenPin, HIGH);
        digitalWrite(ledYellowPin, LOW);
        
        Serial.println("STATE : NORMAL");
        Serial.println();
        break;
    case 1:
        sending();
        digitalWrite(laserPin, HIGH);
        digitalWrite(ledRedPin, HIGH);
        digitalWrite(ledGreenPin, LOW);
        digitalWrite(ledYellowPin, LOW);
    
        Serial.println("STATE : FIRE");
        Serial.println();
        break;
   case 2:
        sending();
        digitalWrite(laserPin, LOW);
        digitalWrite(ledRedPin, LOW);
        digitalWrite(ledGreenPin, LOW);
        digitalWrite(ledYellowPin, HIGH);
    
        Serial.println("STATE : EARTHQUAKE");
        Serial.println();
        break;
   case 3:
        sending();
        digitalWrite(laserPin, HIGH);
        digitalWrite(ledRedPin, HIGH);
        digitalWrite(ledGreenPin, LOW);
        digitalWrite(ledYellowPin, HIGH);
    
        Serial.println("STATE : F/E");
        Serial.println();
        break;
  }
}

void setup() {
  Serial.begin(9600);
  Phpoc.begin(PF_LOG_SPI | PF_LOG_NET);
  mlx.begin();
  
  pinMode(laserPin, OUTPUT);
  pinMode(ledRedPin, OUTPUT);
  pinMode(ledGreenPin, OUTPUT);
  pinMode(ledYellowPin, OUTPUT);
  pinMode(ledPin, OUTPUT);
}

const int id = 1;

void routine(){
  if ( ( (millis() - lastConnectionTime > postingInterval) && flag ) ){
    url = "GET /eventIn.do?module_id=";
    url += id;
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

void loop() {  
    sensing();
    event();
    routine();
    delay(500);
}
