## 데이터 수신 및 웹 소캣 전송
- 웹 소캣 토픽 "ws-aircraft"
- 데이터 json 파싱 후 전송
- 사용하는 데이터 필드
```
departureAirport - 출발 공항
destinationAirport - 도착 공항
aircraftType - 항공기 타입
callSign - 항공기 호출부호
airport - 공항
altitude - 고도
status - 상태
velocityY - Y축 속도
longitude - 경도
velocityX - X축 속도
trackNum - 트랙 번호
```
- 전체 필드
```
🔧 최상위 구조

enhanced: 확장 정보
messageType: 메시지 유형
flightPlan: 비행 계획
record: 기록 정보
source: 출처
track: 추적 정보
timestamp: 타임스탬프

✈️ enhanced (확장 정보)

departureAirport: 출발 공항
destinationAirport: 도착 공항

📋 flightPlan (비행 계획)

aircraftType: 항공기 기종
assignedAltitude: 할당된 고도
entryFix: 진입 지점
requestedAltitude: 요청 고도
flightRules: 비행 규칙
callSign: 호출 부호
airport: 공항 코드
exitFix: 출구 지점

📝 record (기록 정보)

seqNum: 순서 번호
source: 소스 구분
type: 타입 코드

📡 track (추적 정보)

altitude: 고도
beaconCode: 비콘 코드 (트랜스폰더)
trackNum: 추적 번호
verticalVelocity: 수직 속도
latitude: 위도
velocityX: X축 속도 (동서)
time: 시간
velocityY: Y축 속도 (남북)
status: 상태
longitude: 경도

🌐 기타

source: 데이터 출처
timestamp: 유닉스 타임스탬프
```
#   S w i f t C o n s u m e r  
 #   S w i f t C o n s u m e r  
 