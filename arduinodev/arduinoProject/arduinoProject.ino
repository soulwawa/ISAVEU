#include <SPI.h>
#include <Phpoc.h>
#include <Adafruit_MLX90614.h>
#include <Wire.h>

PhpocClient client;
const int moduleId = 0;
Adafruit_MLX90614 mlx = Adafruit_MLX90614();          // tempSensor
int issue = 0;
boolean flag = true;

// serverConnection
char server_name[] = "192.168.0.35";
unsigned long lastConnectionTime = 0;
const unsigned long postingInterval = 10L * 1000L;    // delay milliseconds
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
const float tempHigh = 60.0;                        // when fire event
int smokeVal;
const int smokeHigh = 1000;                         // when fire event
int fireVal;
const int fireLow = 500;                            // when fire event
int gyroVal;
const int gyroLow = 100;                            // when earthquake event

void event(){
  if((tempVal >= tempHigh) || (smokeVal >= smokeHigh) || (fireVal <= fireLow)){
    if(gyroVal <= gyroLow){
      issue = 3;
      Serial.println("STATE : FIRE/EARTHQUAKE");
      Serial.println();
    }else{
      issue = 1;
      Serial.println("STATE : FIRE");
      Serial.println();
    }
  }else{
    if(gyroVal <= gyroLow){
      issue = 2;
      Serial.println("STATE : EARTHQUAKE");
      Serial.println();
    }else{
    issue = 0;
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
  tempVal = mlx.readObjectTempC();                         // objTemp
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
  mlx.begin();                                            // temp
  pinMode(ledRedPin, OUTPUT);
  pinMode(ledGreenPin, OUTPUT);
  pinMode(ledYellowPin, OUTPUT);
  pinMode(ledPin, OUTPUT);

  // connection
  Phpoc.begin(PF_LOG_SPI | PF_LOG_NET);
}

void httpRequest() {
  // close any connection before send a new request.
  // This will free the socket on the WiFi shield
  client.stop();
  digitalWrite(ledPin, HIGH);
  lastConnectionTime = millis();
  
  // if there's a successful connection:
  if (client.connect(server_name, 9999)) {
    
    Serial.println("connecting...");      
    client.println(url);                                  // send the HTTP PUT request:
    client.println();
    // note the time that the connection was made:
     flag = false;
  } else {
    // if you couldn't make a connection:
    Serial.println("connection failed");
    flag = false;
  }
}

void loop() {
  digitalWrite(ledPin, LOW);
  if( !flag ){
    while ( client.available() ) {
      Serial.println(client.available());
      char c = client.read();
//      Serial.write(c);
    }
    flag = true;
  }
  if(flag){
    sensing();
    monitoring();
  }

  // 서버접속
  if ( ( (millis() - lastConnectionTime > postingInterval) || issue == 1 || issue == 2 || issue == 3 ) && flag ){
    url = "GET /module/eventIn.do?module_id=";
    url += moduleId;
    url += "&temp=" + String(tempVal);
    url += "&smoke=" + String(smokeVal);
    url += "&gyro=" + String(gyroVal);
    url += "&fire=" + String(fireVal);
    url += "&issue=" + String(issue);
    url += " HTTP/1.0";
    Serial.print("url: ");
    Serial.println(url); 
    httpRequest();
  }
   delay(500);
}
