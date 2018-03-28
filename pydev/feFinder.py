from flask import Flask
import time, pexpect, threading, requests, os

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

def feCam():
    cmd = "camstream"
    os.system(cmd)

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
            state = 1
        else:
            state = 0
            payload = {'missing': name}
            r = requests.get("http://192.168.0.35:9999/fe.do", params=payload)
            print(r.url)

        print("state : " + str(state))

app = Flask(__name__)

@app.route("/fe/<state>/")
def feState(state):
    if state == "0":
        streamcmd = 'fuser -k -n tcp 5000'
        os.system(streamcmd)
        print('off streaming...')
        time.sleep(0.5)
    else:
        pid1 = os.fork()
        while 1 :
            if pid1 :
                print("streaming...")
            else:
                feCam()
            break

        time.sleep(0.01)
    return "streaming control"


if __name__ == "__main__":
    t = threading.Thread(target=feScan)
    t.start()
    app.run(host="0.0.0.0", port=5002, debug=False)