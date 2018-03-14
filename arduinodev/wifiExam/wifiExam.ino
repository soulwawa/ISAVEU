#include <SPI.h>
#include <Phpoc.h>
char server_name[] = "192.168.0.13";
unsigned long lastConnectionTime = 0;               // last time you connected to the server, in milliseconds
const unsigned long postingInterval = 10L * 1000L;  // delay milliseconds
PhpocClient client;

void setup() {
  Serial.begin(9600);
  Serial.println("Sending GET request to web server");    
  Phpoc.begin(PF_LOG_SPI | PF_LOG_NET);
}
int tempPin = A0;
const float tempLow = 140;    //20c = 140
const float tempHigh = 160;   //30c = 160
float temperatureC = 0;
String url = "";

boolean flag = true;          //send check boolean
boolean flag1 = true;         //send check boolean
int reading = 0;

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
    reading = analogRead(tempPin);
    float voltage = reading * 5.0;
    voltage /= 1024.0; 
    Serial.print(voltage); Serial.println(" volts");
    //섭씨 온도 출력
    int temperatureC = (voltage - 0.5) * 100 ; 
    Serial.print(temperatureC); Serial.println(" degrees C");    
  }

  
  if ( ((millis() - lastConnectionTime > postingInterval) ||  (reading <= tempLow) || ( reading >= tempHigh))  && flag ){
    url = "GET /SafeForYou/tempIn?loc=pos1&type=";
    if(reading <= tempLow){
      url += "L";
    }else if( reading >= tempHigh ){
       url += "H";
    }else{
      url += "T";
    }
    url += "&temp=" + String(reading, DEC);
    url += " HTTP/1.0";
    Serial.print("url: ");
    Serial.println(url);
    httpRequest();
  }
   delay(500);
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
