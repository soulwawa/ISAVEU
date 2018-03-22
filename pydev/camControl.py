from flask import Flask, Response
import subprocess, time

app = Flask(__name__)

@app.route("/cam/")
def cam():
    try:
        piccmd = 'raspistill -t 500 -o cam/event.png'               # -t(millsec)
        subprocess.call(piccmd, shell=True)
        time.sleep(0.1)

        f = open("cam/event.jpg",'rb')
        pic = f.read()
        f.close()

    except Exception as e:
        print("error : " + str(e))

    return Response(pic, mimetype="image/jpeg")

@app.route("/cam/<con>")
def camCon(con):
    if con == "1":
        streamOn = "camstream"
        subprocess.call(streamOn, shell=True)
        time.sleep(0.1)

    else:
        streamOff = "fuser -k -n tcp 5000"
        subprocess.call(streamOff,shell=True)
        time.sleep(0.1)

    return "controlling..."




if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)