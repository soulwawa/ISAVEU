from flask import Flask, Response
import subprocess, time, threading, os

app = Flask(__name__)

# 스트리밍 서버를 불러오기 위한 함수
def streaming():
    cmd = "camstream"
    os.system(cmd)

@app.route("/cam/<issue>/")
def cam(issue):
    try:
        # 사진을 찍는 부분
        camcmd = 'raspistill -t 500 -o cam/event.png -w 800 -h 480'
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
        # 스트리밍 서버를 닫는 부분
        streamcmd = 'fuser -k -n tcp 5000'
        os.system(streamcmd)
        print('off streaming...')
        time.sleep(0.5)
    else:
        # 서브프로세스로 스트리밍 서버를 실행하는 부분
        pid1 = os.fork()
        while 1 :
            if pid1 :
                print("streaming...")
            else:
                streaming()
            break

        time.sleep(0.01)
    return "streaming control"





# 포트 변경, 디버그 자동설정x 주의!!
if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5001, debug=False)