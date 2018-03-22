from flask import Flask, Response
import subprocess, time
from werkzeug import secure_filename

app = Flask(__name__)


@app.route("/event/<issue>/")
def camcon(issue):
    try:
        if issue != "0":
            strcmd = 'raspistill -t 500 -o cam/event.jpg -w 800 -h 480' # -t(millsec)
            subprocess.call(strcmd, shell=True)
            time.sleep(0.1)

            f = open("cam/event.jpg",'rb')

            # f = open("aa.png",'rb')
            pic = f.read()
            f.close()

    except Exception as e:
        print("error" + str(e))

    return Response(pic, mimetype="image/jpeg")
    # return Response(pic, mimetype="image/png")






if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5001, debug=True)