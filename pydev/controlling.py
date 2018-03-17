from flask import Flask, render_template
import RPi.GPIO as GPIO

app = Flask(__name__)

GPIO.setmode(GPIO.BCM)
GPIO.setup(14, GPIO.OUT)
GPIO.setup(15, GPIO.OUT)

@app.route("/ledcon/<pin>/<value>/")
def ledcon(pin, value):
    state = "ON"
    try:
        if pin == "1":
            if value =="1":
                GPIO.output(14,True)
            else:
                GPIO.output(14,False)
                state = "OFF"
        else:
            if value == "1":
                GPIO.output(15,True)
            else:
                GPIO.output(15,False)
                state="OFF"
        response = "led control success led "+ pin + " state 값은 "+ state+ "입니다."
    except:
        response = "led control error"

    templateData={
        'title': 'LED컨트롤' + pin,
        'response' : response
    }
    return render_template('led.html', **templateData)







if __name__ == "__main__":
    app.run(host="0.0.0.0", port=80)