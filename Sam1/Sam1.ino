const int ledPin = 12;
const int buttonPin = 2;

const int potentiometerPin = A0;

int currentButtonState;

int potentiometerValue;
int brightness;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  
  pinMode(ledPin, OUTPUT);
  pinMode(buttonPin, INPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  currentButtonState = digitalRead(buttonPin);
  digitalWrite(ledPin, currentButtonState);

  potentiometerValue = analogRead(potentiometerPin);
  Serial.print("potentiometerValue: ");
  Serial.println("potentiometer")

}
