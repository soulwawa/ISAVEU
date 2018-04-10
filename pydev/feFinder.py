from flask import Flask
import time, pexpect, threading, requests
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
led = 14
siren = 13
GPIO.setup(led, GPIO.OUT)
GPIO.setup(siren, GPIO.OUT)
p = GPIO.PWM(siren, 440)
GPIO.setwarnings(False)

name = "FE-01"
mac = "18:93:D7:46:14:D6"

def siren():
    p.start(50)
    while True:
        for hz in range(440, 1000, 25):
            p.ChangeFrequency(hz)
            time.sleep(0.005)

class Bluetoothctl:

    def __init__(self):
        self.child = pexpect.spawn("bluetoothctl", echo = False)

    def getOutput(self, command):
        self.child.send(command + "\n")
        self.child.expect(["bluetooth", pexpect.EOF])

        return self.child.before

    def startScan(self):
        try:
            self.getOutput("scan on")
        except Exception as e:
            print("startScan() error : " + str(e))
            return None

def feScan():
    while True:
        name = "FE-01"
        mac = "18:93:D7:46:14:D6"
        bl = Bluetoothctl()
        bl.startScan()
        print("Scanning for 10 seconds...")
        for i in range(0, 10):
            print(i)
            time.sleep(1)

        list = bl.getOutput("devices").decode("utf-8").split('\r\n')

        flag = False
        for fe in list:
            if fe.find(mac) > 7:
                flag = True

        if flag:
            print(str(name) + " in service")
            print()
        else:
            payload = {'missing': name}
            print(str(name) + " missing")
            print()
            r = requests.get("http://192.168.0.35:9999/module/fe.do", params=payload)
            if(r.status_code == requests.codes.ok) :
                print(r.status_code)
                print(r.text)
            # print(r.url)
            break

app = Flask(__name__)

@app.route("/feRestart/")
def feRestart():
    t = threading.Thread(target=feScan)
    t.start()
    return "{'restart' : 'ok'}"

@app.route("/siren/<state>/")
def sirenTest(state):
    t =threading.Thread(target=siren)
    if state == "0":
        p.stop()
        GPIO.output(led, False)
    else:
        t.start()
        GPIO.output(led, True)

    return name + " : Siren Control Response"


if __name__ == "__main__":
    t = threading.Thread(target=feScan)
    t.start()
    app.run(host="0.0.0.0", port=5002, debug=False)