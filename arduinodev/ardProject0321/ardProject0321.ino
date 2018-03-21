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

// led
const int ledRedPin = 13;
const int ledGreenPin = 12;
const int ledYellowPin = 11;
const int ledPin = 10;

// piezo
const int piezoPin = 8;
float sinVal;
int toneVal;

// temp
float tempAmbient = 0;
float tempObject = 0;
const float tempHigh = 40.0;            // 수정해야함

// smoke
const int smokeSensorPin = A15;
int smokeVal;
const int smokeHigh = 700;

// gyro
const int gyroSensorPin = A13;
int gyroVal;
const int gyroLow = 500;

// fire
const int fireSensorPin = A11;
int fireVal;
const int fireLow = 500;

// issue
int issue = 0;

void alert(){
  for(int i=0 ;i < 180; i++){
    digitalWrite(ledRedPin, HIGH);
    digitalWrite(ledGreenPin, LOW);
    
    sinVal = sin(i*PI/180);
    toneVal=(int)(100+1000*sinVal);
    tone(piezoPin, toneVal);
    delay(15);
  }
}
void monitoring(){
  Serial.print("주변 온도 : "); Serial.print(tempAmbient);
  Serial.print("*C\t온도 : "); Serial.print(tempObject);
  Serial.println("*C");
  Serial.print("연기센서 값 : ");
  Serial.println(smokeVal);
  Serial.print("진동센서 값 : ");
  Serial.println(gyroVal);
  Serial.print("불꽃센서 값 : ");
  Serial.println(fireVal);
}

void tempSensing(){
  tempAmbient = mlx.readAmbientTempC();
  tempObject = mlx.readObjectTempC();
}

void smokeSensing(){
  smokeVal = analogRead(smokeSensorPin);
}

void gyroSensing(){
  gyroVal = analogRead(gyroSensorPin);
}

void fireSensing(){
  fireVal = analogRead(fireSensorPin);
}

void event(){
  if(issue == 0){
    if((tempObject >= tempHigh) || (smokeVal >= smokeHigh) || (fireVal <= fireLow)){
      if(gyroVal <= gyroLow){
        issue = 3;
        alert();
        digitalWrite(ledYellowPin, HIGH);
        Serial.println("현재 상태 : 화재&지진");
        Serial.println();
      }else{
        issue = 1;
        alert();
        Serial.println("현재 상태 : 화재");
        Serial.println();
      }
    }else{
      if(gyroVal <= gyroLow){
        issue = 2;
        alert();
        digitalWrite(ledYellowPin, HIGH);
        Serial.println("현재 상태 : 지진");
        Serial.println();
      }else{
        issue = 0;
        noTone(8);
        digitalWrite(ledRedPin, LOW);
        digitalWrite(ledGreenPin, HIGH);
        digitalWrite(ledYellowPin, LOW);
        
        Serial.println("현재 상태 : 양호");
        Serial.println();
      }
    }
  }
}

void sensing(){
    tempSensing();
    smokeSensing();
    gyroSensing();
    fireSensing();
    monitoring();
  
    event();
    delay(10);
}

void setup() {
  Serial.begin(9600);
  
// temp
  mlx.begin();
  
// led
  pinMode(ledRedPin, OUTPUT);
  pinMode(ledGreenPin, OUTPUT);
  pinMode(ledYellowPin, OUTPUT);
  pinMode(ledPin, OUTPUT);
  
// piezo
  pinMode(piezoPin, OUTPUT);

// 서버접속
  Serial.println("Sending GET request to web server");    
  Phpoc.begin(PF_LOG_SPI | PF_LOG_NET);
  String url = "";
}

boolean flag = true;          //send check boolean
boolean flag1 = true;         //send check boolean

// 서버 접속
void httpRequest() {
  // close any connection before send a new request.
  // This will free the socket on the WiFi shield
  client.stop();

  // if there's a successful connection:
  if (client.connect(server_name, 8088)) {
    Serial.println("connecting...");      
    client.println(url); // send the HTTP PUT request:
    client.println("GET / HTTP/1.0");
    client.println("id: aaaa");
    client.println();
    // note the time that the connection was made:
    lastConnectionTime = millis();
     flag = false;
     digitalWrite(ledPin, HIGH);
  } else {
     if you couldn't make a connection:
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
  }

// 서버접속
  if ( ((millis() - lastConnectionTime > postingInterval) && flag ||( (issue == 1) || (issue == 2) )) ){
    url = "GET /SafeForYou/eventIn.do?module_id=1";
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
