# API 명세서

1. 일정 생성
   
URL: /schedules

Method: POST

Description: 새로운 일정을 생성합니다.

Request Headers:

Content-Type: application/json

Request Body:

json

{
    "task": "Learn Spring Boot",
    "author": "John Doe",
    "password": "1234"
}

Response:

Status: 200 OK

Body:

json
{
    "message": "Schedule created successfully."
}
