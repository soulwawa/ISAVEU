#include <SPI.h>
#include <Phpoc.h>
#include <Adafruit_MLX90614.h>
#include <Wire.h>

PhpocClient client;
Adafruit_MLX90614 mlx = Adafruit_MLX90614();          // tempSensor

// serverConnection
char server_name[] = "192.168.0.35";
unsigned long lastConnectionTime = 0;
const unsigned long postingInterval = 10L * 1000L;    // delay milliseconds
String url = "";

// module
const int laserPin = 7;
const int ledRedPin = 13;
const int ledGreenPin = 12;
const int ledYellowPin = 11;
const int ledPin = 10;
float tempAmbient = 0;
float tempObject = 0;
const float tempHigh = 60.0;                        // fire event
const int smokeSensorPin = A15;
int smokeVal;
const int smokeHigh = 1000;                         // fire event
const int fireSensorPin = A13;
int fireVal;
const int fireLow = 100;                             // fire event
const int gyroSensorPin = A11;
int gyroVal;
const int gyroLow = 100;                            // earthquake event

int issue = 0;

boolean flag = true;
boolean flag1 = true;

void fireMonitoring(){
  Serial.print("TEMP : "); Serial.print(tempObject); Serial.println("*C");
//  Serial.print("*C\tOBJTEMP : "); Serial.print(tempAmbient);
  Serial.print("SMOKE : ");
  Serial.println(smokeVal);
  Serial.print("GYRO : ");
  Serial.println(gyroVal);
  Serial.print("FIRE : ");
  Serial.println(fireVal);

  Serial.println("STATE : FIRE");
  Serial.println();
}
void earthquakeMonitoring(){
  Serial.print("GYRO : ");
  Serial.println(gyroVal);
  Serial.println("STATE : EARTHQUAKE");
  Serial.println();
}

void sensing(){
//  tempAmbient = mlx.readAmbientTempC();       // ambTemp
  tempObject = mlx.readObjectTempC();         // objTemp
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
        
        fireMonitoring();
        earthquakeMonitoring();
      }else{
        issue = 1;
        digitalWrite(laserPin, HIGH);
        digitalWrite(ledRedPin, HIGH);
        digitalWrite(ledGreenPin, LOW);
        digitalWrite(ledYellowPin, LOW);

        fireMonitoring();
      }
    }else{
      if(gyroVal <= gyroLow){
        issue = 2;
        digitalWrite(laserPin, LOW);
        digitalWrite(ledRedPin, LOW);
        digitalWrite(ledGreenPin, LOW);
        digitalWrite(ledYellowPin, HIGH);

        earthquakeMonitoring();
      }else{
        issue = 0;
        digitalWrite(laserPin, LOW);
        digitalWrite(ledRedPin, LOW);
        digitalWrite(ledGreenPin, HIGH);
        digitalWrite(ledYellowPin, LOW);
      }
    }
  }
}

void setup() {
  Serial.begin(9600);
  while(!Serial);

// module
  pinMode(laserPin, OUTPUT);
  mlx.begin();                                          // temp
  pinMode(ledRedPin, OUTPUT);
  pinMode(ledGreenPin, OUTPUT);
  pinMode(ledYellowPin, OUTPUT);
  pinMode(ledPin, OUTPUT);

  // connection
  Serial.println("Sending GET request to web server");    
  Phpoc.begin(PF_LOG_SPI | PF_LOG_NET);
}

void httpRequest() {
  // close any connection before send a new request.
  // This will free the socket on the WiFi shield
  client.stop();
  lastConnectionTime = millis();
  
  // if there's a successful connection:
  if (client.connect(server_name, 9999)) {
    Serial.println("connecting...");      
    client.println(url);                                  // send the HTTP PUT request:
    client.println();
    // note the time that the connection was made:
     flag = false;
     Serial.println("check!");
     digitalWrite(ledPin, HIGH);
  } else {
    // if you couldn't make a connection:
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
    event();
  }

const int moduleId = 0;

// 서버접속
  if ( ((millis() - lastConnectionTime > postingInterval) && flag ||( (issue == 1) || (issue == 2) || (issue == 3) ) ) ){
    url = "GET /module/eventIn.do?module_id=";
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
   delay(1000);
}
