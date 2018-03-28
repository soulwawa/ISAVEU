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

if __name__ == "__main__":

    bl = Bluetoothctl()
    bl.startScan()
    print("Scanning for 10 seconds...")
    for i in range(0, 10):
        print(i)
        time.sleep(1)

    list = bl.getOutput("devices").decode("utf-8").split('\r\n')

    print(list)

    flag = False
    for fe in list :
        if fe.find("18:93:D7:46:14:D6") > 7 :
            flag = True
            result = fe

    if flag :
        print("FE : " + str(result))
    else:
        print("FE not found...")