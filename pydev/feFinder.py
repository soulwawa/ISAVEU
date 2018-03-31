from flask import Flask
import time, pexpect, threading, requests, os
import RPi.GPIO as GPIO

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
            r = requests.get("http://192.168.0.35:9999/fe.do", params=payload)
            # print(r.url)
            break

app = Flask(__name__)

GPIO.setmode(GPIO.BCM)
led = 14
siren = 13
GPIO.setup(led, GPIO.OUT)
GPIO.setup(siren, GPIO.OUT)

@app.route("/feRestart/")
def feRestart():
    feScan()
    return "Scanning restart necessary..."


@app.route("/siren/<state>/")
def siren(state):
    try:
        if state == "0":
            GPIO.output(led, False)
        else:
            GPIO.output(led, True)
    except Exception as e:
        print("siren error : " + str(e))

    return "Siren Control"


if __name__ == "__main__":
    t = threading.Thread(target=feScan)
    t.start()
    app.run(host="0.0.0.0", port=5002, debug=False)