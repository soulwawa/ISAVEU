# ISAVEU
## 한국생산성본부 센서, 네트워크 기반의 IoT 융합서비스 개발자 양성과정 프로젝트

### 1. 프로젝트명 : 비상구와 소화기를 활용한 빌딩 재난관리 IoT 서비스 (우수상 수상)

### 2. 프로젝트 기간 : 2018.03.01 ~ 2018.04.10

### 3. 프로젝트 멤버 : 강인수, 고석만, 김준기, 정긍휼

### 4. 기획 의도
##### 현재 많은 사람이 가지고 있는 안전불감증은 소화전의 울림 또는 사이렌 소리와 같은 재난의 발생 신호를 자칫 단순한 해프닝으로 여기게 한다는 점에서 빌딩 내 상주 인원에게 정확한 재난 상황의 발생을 알릴 필요성이 중요해지고 있다. 우리는 IoT를 활용하여 이 문제를 해결하기로 하였다. 어떤 건물이든 가지고 있는 2가지를 활용하고자 한다. 첫 번째는 비상구이다. 보통 때에는 큰 역할이 없으며, 화재로 인한 연기 발생 시에는 그 역할의 존재감이 미미해지는 비상구를 활용하고자 한다. 평상시에도 온도, 연기, 흔들림, 불꽃 값을 감지하여, 만일의 상황에 대비하게 할 것이다. 또 화재 발생 시 LED와 소리를 활용하여 연기로 비상구가 보이지 않을 때도 비상구의 위치를 정확하기 찾을 수 있게 비상구가 제 역할을 할 수 있게 하고자 할 것이다. 여기에 더해 카메라 기능을 추가하여 재난 발생 시 현장 상황을 감시할 수 있게 할 것이다. 이 기능들은 비상 상황 발생 시 사내 WEB과 APP에 추가해 더욱 시너지 효과를 발휘할 것이다. 두 번째로는 소화기이다. 소화기의 경우 유효기간이나 위치 등을 정확하게 관리하는 경우가 많지 않다. 이런 문제를 해결하고자 비콘과 블루투스를 활용해 빌딩 내의 소화기들과 감지를 하려 한다. 이 두 가지 모듈들은 웹서버를 통해 데이터베이스에 저장이 되고, WEB과 APP을 통하여 직관적이고 편하게 소화기를 관리 할 수 있게 될 것이다. 좀 더 안전하게 그리고 좀 더 빠르게 대응할 수 있도록 하여, IoT가 우리 삶의 안전을 지켜줄 수 있게 하는 것이 이번 프로젝트의 궁극적인 목표다.

### 5. 개발 기술
##### 5.1. Hardware : Arduino MEGA Board(C), Icore_peri0(PYTHON) 모듈
##### 5.2. Server : JAVA(SPRING BOOT, Mybatis) PYTHON(FLASK)
##### 5.3. WEB : HTTP, CSS, JAVASCRIPT(JQuery, AJAX)
##### 5.4. Mobile : Android 
##### 5.5. DB : MySQL
##### 5.6. Sensor module : smoke, fire, gyro, temp, laser, beacon, Bluetooth, wifi
##### 5.6. Version Control : GITHUB(GIT), Sourcetree

### 6. Intro
<p><img src="image/index.gif"></p>

### 7. 시연동영상
<a href="http://www.youtube.com/watch?v=tMLnRnyyZHg"><img src="http://img.youtube.com/vi/tMLnRnyyZHg/0.jpg" width="888" ></a>


### 8. 프로젝트 개념도
<p><img src="image/project.PNG"></p>

### 9. 하드웨어 설계
<p><img src="image/hardware.png"></p>
