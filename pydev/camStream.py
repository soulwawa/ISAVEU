from flask import Flask, Response
import time, threading, os
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
moduleId = "0"
siren = 13
GPIO.setup(siren, GPIO.OUT)
p = GPIO.PWM(siren, 440)                # siren 변수의 주파수 440인 pwm 인스턴스를 생성
GPIO.setwarnings(False)

app = Flask(__name__)

def siren():
    p.start(50)                         # Duty cycle을 50%로 시작 설정
    while True:
        for hz in range(440, 1000, 25): # 440hz부터 1000hz까지 25씩 증가하면서 변경되는 루프
            p.ChangeFrequency(hz)
            time.sleep(0.005)           # delay 5ms

# 스트리밍 서버를 불러오기 위한 함수
def streaming():
    cmd = "camstream"                   # 스트리밍 서버를 켜기 위한 리눅스 커맨드
    os.system(cmd)                      # 시스템 명렁어 호출

@app.route("/cam/<issue>/")
def cam(issue):
    try:
        # 사진 찍는 부분
        camcmd = 'raspistill -t 500 -o cam/event.png -e png -w 800 -h 480'
        os.system(camcmd)

        # 사진을 서버로 보내는 부분
        f = open('cam/event.png', 'rb')
        pic = f.read()
        f.close()
        print('picture transfer...')
        time.sleep(0.5)

    except Exception as e:
        print("camError : " + str(e))

    return Response(pic, mimetype="image/png")


@app.route("/stream/<state>/")
def stream(state):
    if state == "0":
        # 스트리밍 서버 닫기
        streamcmd = 'fuser -k -n tcp 5000'
        os.system(streamcmd)
        print('off streaming...')
        time.sleep(0.5)
    else:
        # 서브프로세스로 스트리밍 서버 실행
        pid1 = os.fork()
        while 1 :
            if pid1 :
                print("streaming...")
            else:
                streaming()
            break

        time.sleep(0.01)
    return "streaming control"

@app.route("/siren/<state>/")
def sirenTest(state):
    t =threading.Thread(target=siren)
    if state == "0":
        p.stop()                                        # PWM 정지
    else:
        t.start()                                       # thread로 사이렌 동작
    return "module_id : "+ str(moduleId) + " - Siren Control Response"


# 포트 변경, 디버그 자동설정x 주의!!
if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5001, debug=False)