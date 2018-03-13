int TempSensorPin = A0;
const int ledPin = 12;

//const int buttonPin = 2;
//int currentButtonState;

//const int ledRed = 9;
//const int ledGreen = 8;
//const int ledYellow = 7;
//int val = 0;

//const int potentiometerPin = A0;
//int potentiometerValue;
//int brightness;

void setup() {
  Serial.begin(9600);    
  pinMode(ledPin, OUTPUT);

//  pinMode(buttonPin, INPUT);
  
//  pinMode(ledRed, OUTPUT);
//  pinMode(ledGreen, OUTPUT);
//  pinMode(ledYellow, OUTPUT);
}

void loop() {
  // 온도센서 활용
  int reading = analogRead(TempSensorPin);

  float voltage = reading * 5.0;
  voltage /= 1024.0;
  Serial.print(voltage);
  Serial.println(" volts");

  // 섭씨온도 출력(float출력)
  double temperatureC = (voltage - 0.5) * 100;
  Serial.print(temperatureC);
  Serial.println(" degrees C");
  // 화씨온도 출력
  double temperatureF = (temperatureC * 9.0 / 5.0) + 32.0;
  Serial.print(temperatureF);
  Serial.println(" degrees F");

  if(temperatureC >= 30.0){
    digitalWrite(ledPin, HIGH);
  }else{
    digitalWrite(ledPin, LOW);
  }

      
  // 버튼으로 제어
//  currentButtonState = digitalRead(buttonPin);
//  digitalWrite(ledPin, currentButtonState);

  // 가변저항
//  potentiometerValue = analogRead(potentiometerPin);
//  Serial.print("potentiometerValue: ");
//  Serial.println(potentiometerValue);
//  brightness = map(potentiometerValue, 0, 1023, 0, 254);
//  Serial.print("LED Brightness : ");
//  Serial.println(brightness);
//  analogWrite(ledPin, brightness);

  // 가변저항으로 밝기제어
//  if(potentiometerValue < 255){
//    digitalWrite(ledRed, LOW);
//    digitalWrite(ledGreen, LOW);
//    digitalWrite(ledYellow, LOW);
//  }else if(potentiometerValue >= 256 & potentiometerValue < 512){
//    digitalWrite(ledRed, HIGH);
//    digitalWrite(ledGreen, LOW);
//    digitalWrite(ledYellow, LOW);
//  }else if(potentiometerValue >= 512 & potentiometerValue < 767){
//    digitalWrite(ledRed, HIGH);
//    digitalWrite(ledGreen, LOW);
//    digitalWrite(ledYellow, HIGH);
//  }else if(potentiometerValue >= 767){
//    digitalWrite(ledRed, HIGH);
//    digitalWrite(ledGreen, HIGH);
//    digitalWrite(ledYellow, HIGH);
//  }

  // 시리얼로 LED 켜고 끄기
//  if(Serial.available() > 0){
//    val = Serial.read();
//    if(val == 48){
//      digitalWrite(ledRed, HIGH);
//      digitalWrite(ledGreen, LOW);
//    }
//    if(val == 49){
//      digitalWrite(ledRed, HIGH);
//      digitalWrite(ledYellow, HIGH);
//      digitalWrite(ledGreen, LOW);
//    }
//    if(val == 50){
//      digitalWrite(ledGreen, HIGH);
//      digitalWrite(ledRed, LOW);
//      digitalWrite(ledYellow, LOW);
//    }
//  }
  
  
  // 동작 정지 버튼
  delay(500);
//  if(currentButtonState){
//    while(1){}
//  }

}
