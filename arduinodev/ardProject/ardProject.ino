// piezo
const int piezoPin = 6;
float sinVal;
int toneVal;

// temp
const int tempPin = A0;

// led
const int ledRedPin = 12;
const int ledGreenPin = 10;
const int ledYellowPin = 8;
int brightness = 0;
int fadeAmount = 10;

// tilt
const int tiltSwitchPin = 4;
int tiltSwitchVal;


void setup()
{
  Serial.begin(9600);
  
  pinMode(ledRedPin, OUTPUT);
  pinMode(ledGreenPin, OUTPUT);
  pinMode(ledYellowPin, OUTPUT);
  
  pinMode(piezoPin, OUTPUT);

  pinMode(tiltSwitchPin, INPUT);
}

void alert(){
  for(int i=0; i<180; i++)
   {
      sinVal=sin(i*PI/180);                 //각도를 라디언으로 바꿔 정현파 값 계산
      toneVal=(int)(100+1000*sinVal);       //경보음 주파수(Hz)로 변환
      tone(piezoPin,toneVal);               //피에조 스피커에서 주파수 발생
      delay(10);                            //경보음 주파수 변화 속도 조정
   }
}
void tilt(){
  tiltSwitchVal = digitalRead(tiltSwitchPin);
  if(tiltSwitchVal == LOW){
    digitalWrite(ledRedPin, HIGH);
    analogWrite(ledYellowPin, brightness);
    brightness += fadeAmount;
    if(brightness <= 0 || brightness >= 255){
      fadeAmount = -fadeAmount;
    }
    delay(40);
  }else{
    digitalWrite(ledRedPin, LOW);
    digitalWrite(ledYellowPin, LOW);
  }
}

void tempSensing(){
  int reading = analogRead(tempPin);

  float voltage = reading * 5.0;
  voltage /= 1024.0;
  //Serial.print(voltage);
  //Serial.println(" volts");

  //섭씨온도 출력
  float temperatureC = (voltage - 0.5) * 100;
  Serial.print("now temp: ");
  Serial.print(temperatureC);
  Serial.println(" degrees C");
  
  if(temperatureC > 40.0){
//    alert();                                     // if문이 끝났는데도 왜 안꺼질까?
    digitalWrite(ledGreenPin, LOW);
    digitalWrite(ledRedPin, HIGH);
  }else{
    noTone(6);                                    // 꺼지게 만들기!!
    digitalWrite(ledRedPin, LOW);
    digitalWrite(ledGreenPin, HIGH);              // 항전필요
    digitalWrite(ledYellowPin, LOW);
  }
  delay(1000);
}

void loop()
{ 
   tilt();
}
