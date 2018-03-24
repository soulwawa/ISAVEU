#include <Adafruit_MLX90614.h>
#include <Wire.h>

Adafruit_MLX90614 mlx = Adafruit_MLX90614();

// laser
const int laserPin = 7;

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
const float tempHigh = 40.0;

// smoke
const int smokeSensorPin = A15;
int smokeVal;
const int smokeHigh = 700;

// fire
const int fireSensorPin = A13;
int fireVal;
const int fireLow = 500;

// gyro
const int gyroSensorPin = A11;
int gyroVal;
const int gyroLow = 100;

// issue
int issue = 0;

void alert(){
  for(int i=0 ;i < 180; i++){
    digitalWrite(laserPin, HIGH);
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
        digitalWrite(laserPin, LOW);
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

// laser
  pinMode(laserPin, OUTPUT);
  
// temp
  mlx.begin();
  
// led
  pinMode(ledRedPin, OUTPUT);
  pinMode(ledGreenPin, OUTPUT);
  pinMode(ledYellowPin, OUTPUT);
  pinMode(ledPin, OUTPUT);
  
// piezo
  pinMode(piezoPin, OUTPUT);

}

void loop() {
    sensing();
    issue = 0;
    delay(2000);
  }
