#include <SPI.h>
#include <Phpoc.h>
char server_name[] = "192.168.0.35";
unsigned long lastConnectionTime = 0;               // last time you connected to the server, in milliseconds
const unsigned long postingInterval = 10L * 1000L;  // delay milliseconds
PhpocClient client;

// led
const int ledRedPin = 12;
const int ledGreenPin = 10;
const int ledYellowPin = 8;
int brightness = 0;
int fadeAmount = 10;

// piezo
const int piezoPin = 6;
float sinVal;
int toneVal;


void setup() {
  Serial.begin(9600);
  Serial.println("Sending GET request to web server");    
  Phpoc.begin(PF_LOG_SPI | PF_LOG_NET);

  pinMode(ledRedPin, OUTPUT);
  pinMode(ledGreenPin, OUTPUT);
  pinMode(ledYellowPin, OUTPUT);

  pinMode(piezoPin, OUTPUT);
}


// temp
const int tempPin = A0;
const float tempLow = 140;                                // 동작 테스트시에만 사용
const float tempHigh = 200;
float temperatureC = 0;


// url
String url = "";

boolean flag = true;          //send check boolean
boolean flag1 = true;         //send check boolean
int reading = 0;

void tempSensing(){
  reading = analogRead(tempPin);
    float voltage = reading * 5.0;
    voltage /= 1024.0;
    //섭씨 온도 출력
    int temperatureC = (voltage - 0.5) * 100 ;
    Serial.print("변환되기 전 온도 값: ");
    Serial.println(reading);
    Serial.print("변환된 온도 값: ");
    Serial.print(temperatureC);
    Serial.println(" degrees C");
}

void alert(){
  for(int i=0 ;i < 180; i++){
    sinVal = sin(i*PI/180);
    toneVal=(int)(100+1000*sinVal);
    tone(piezoPin, toneVal);
    delay(10);
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
    tempSensing();
  }

  // 동작 테스트 시 사용(수정해야)
  if ( ((millis() - lastConnectionTime > postingInterval) ||  (reading <= tempLow) || ( reading >= tempHigh))  && flag ){
    url = "POST /SafeForYou/tempIn.do?loc=pos1&type=";
    if(reading <= tempLow){
      url += "L";
    }else if( reading >= tempHigh ){
       alert();
       digitalWrite(ledRedPin, HIGH);
       digitalWrite(ledGreenPin, LOW);
//       digitalWrite(ledYellowPin, LOW);
       url += "H";
    }else{
      url += "T";
      noTone(6);
      digitalWrite(ledRedPin, LOW);
      digitalWrite(ledGreenPin, HIGH);
//      digitalWrite(ledYellowPin, LOW);
    }

    url += "&temp=" + String(reading, DEC);
    url += " HTTP/1.0";
    Serial.print("url: ");
    Serial.println(url);
    httpRequest();
  }
   delay(1000);
}
void httpRequest() {
  // close any connection before send a new request.
  // This will free the socket on the WiFi shield
  client.stop();

  // if there's a successful connection:
  if (client.connect(server_name, 8088)) {
    Serial.println("connecting...");      
    client.println(url); // send the HTTP PUT request:
    //client.println("GET / HTTP/1.0");
    client.println("id: aaaa");
    client.println();
    // note the time that the connection was made:
    lastConnectionTime = millis();
     flag = false;
  } else {
    // if you couldn't make a connection:
    Serial.println("connection failed");
  }
}
