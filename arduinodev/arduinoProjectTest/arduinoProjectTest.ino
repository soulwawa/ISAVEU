#include <Adafruit_MLX90614.h>
#include <Wire.h>

const int moduleId = 0;

int issue = 0;
Adafruit_MLX90614 mlx = Adafruit_MLX90614();          // tempSensor

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
      Serial.print("TEMP : "); Serial.print(tempVal); Serial.println("*C");
      Serial.print("SMOKE : ");
      Serial.println(smokeVal);
      Serial.print("FIRE : ");
      Serial.println(fireVal);
      
      Serial.print("GYRO : ");
      Serial.println(gyroVal);
    }else{
      issue = 1;
      Serial.print("TEMP : "); Serial.print(tempVal); Serial.println("*C");
      Serial.print("SMOKE : ");
      Serial.println(smokeVal);
      Serial.print("FIRE : ");
      Serial.println(fireVal);
    }
  }else{
    if(gyroVal <= gyroLow){
      issue = 2;
      Serial.print("GYRO : ");
      Serial.println(gyroVal);
    }else{
    issue = 0;
    }  
}
}

void monitoring(){
  Serial.print("TEMP : "); Serial.print(tempVal); Serial.println("*C");
  Serial.print("SMOKE : ");Serial.println(smokeVal);
  Serial.print("FIRE : ");Serial.println(fireVal);
  
  Serial.print("GYRO : ");Serial.println(gyroVal);
}

void state(){
  switch(issue){
    case 0:
      digitalWrite(laserPin, LOW);
      digitalWrite(ledRedPin, LOW);
      digitalWrite(ledGreenPin, HIGH);
      digitalWrite(ledYellowPin, LOW);
      Serial.println("STATE : NORMAL");
      Serial.println();
      break;
    case 1:
      digitalWrite(laserPin, HIGH);
      digitalWrite(ledRedPin, HIGH);
      digitalWrite(ledGreenPin, LOW);
      digitalWrite(ledYellowPin, LOW);
      Serial.println("STATE : FIRE");
      Serial.println();
      break;
    case 2:
      digitalWrite(laserPin, LOW);
      digitalWrite(ledRedPin, LOW);
      digitalWrite(ledGreenPin, LOW);
      digitalWrite(ledYellowPin, HIGH);
      Serial.println("STATE : EARTHQUAKE");
      Serial.println();
      break;
    case 3:
      digitalWrite(laserPin, HIGH);
      digitalWrite(ledRedPin, HIGH);
      digitalWrite(ledGreenPin, LOW);
      digitalWrite(ledYellowPin, HIGH);
      Serial.println("STATE : FIRE/EARTHQUAKE");
      Serial.println();
      break;
  }
}

void sensing(){
  tempVal = mlx.readObjectTempC();           // objTemp
  smokeVal = analogRead(smokeSensorPin);
  fireVal = analogRead(fireSensorPin);
  gyroVal = analogRead(gyroSensorPin);
  event();
  state();
}

void setup() {
  Serial.begin(9600);
  
  // module
  pinMode(laserPin, OUTPUT);
  mlx.begin();                                          // temp
  pinMode(ledRedPin, OUTPUT);
  pinMode(ledGreenPin, OUTPUT);
  pinMode(ledYellowPin, OUTPUT);
  pinMode(ledPin, OUTPUT);
}

void loop() {
  sensing();
  monitoring();
  delay(1000);
}
