from flask import Flask, Request
import time, pexpect, subprocess, sys

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

app = Flask(__name__)

@app.route("/fe/<mac>/<state>/")
def feBeaconFinder(id, state):
    mac = "18:93:D7:46:14:D6"
    flag = True
    bl = Bluetoothctl()
    try:
        while flag:
            bl.startScan()
            print("Scanning for 10 seconds...")
            for i in range(0, 10):
                print(i)
            time.sleep(1)

            list = bl.getOutput("devices").decode("utf-8").split('\r\n')


            for fe in list:
                if fe.find(mac) > 7:
                    result = fe
                    print("FE : " + str(result))
                else:
                    flag = False
                    state = 0
                    print("FE not found...")

            time.sleep(60)

    except Exception as e:
        print("feError : " + str(e))

    return '' % (mac, state)




if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5002, debug=True)