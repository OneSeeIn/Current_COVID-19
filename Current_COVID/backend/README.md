# OneSeeIn


[mariaDB]
시작
systemctl start mariadb

 

종료
systemctl stop mariadb

 

재시작
systemctl restart mariadb


[jar 백그라운드 실행]
1. 리눅스 환경에서 java (jar)를 데몬처럼 실행

$ java –jar abcdefg.jar &
(사용자가 로그아웃시 프로그램 종료 됨)

 

2. 사용자가 로그아웃해도 백그라운드로 실행되게 하는 명령어

$ nohup java -jar abcdefg.jar &

 

3. 프로세스 종료

찾기 : ps –ef | grep 'abcdefg'
종료 : kill -9 (pid)
