# API 명세서

1. 일정 생성
   
+ URL: /schedules

+ Method: POST

+ Description: 새로운 일정을 생성합니다.

+ Request Headers:

+ Content-Type: application/json

+ Request Body:

json
```js
{
    "task": "Learn Spring Boot",
    "author": "John Doe",
    "password": "1234"
}
```
+ Response:

+ Status: 200 OK

+ Body:

json
```js
{
    "message": "Schedule created successfully."
}
```
2. 전체 일정 조회
+ URL: /schedules
  
+ Method: GET
  
+ Description: 등록된 모든 일정을 조회합니다.
  
+ Response:
  
+ Status: 200 OK
  
+ Body:
  
json
```js
[
    {
        "id": 1,
        "task": "Learn Spring Boot",
        "author": "John Doe",
        "createdAt": "2023-12-01T10:00:00",
        "updatedAt": "2023-12-01T10:00:00"
    }
]
```
