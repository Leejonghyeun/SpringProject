# API 명세서

### 1. 일정 생성
   
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

### 2. 전체 일정 조회
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

### 3. 특정 일정 조회
+ URL: /schedules/{id}
  
+ Method: GET
  
+ Description: 특정 일정을 조회합니다.
  
+ Path Parameter:
  
+ id (필수): 조회할 일정의 고유 ID.
  
+ Response:
  
+ Status: 200 OK
  
+ Body:
  
json
```js
{
    "id": 1,
    "task": "Learn Spring Boot",
    "author": "John Doe",
    "createdAt": "2023-12-01T10:00:00",
    "updatedAt": "2023-12-01T10:00:00"
}
```

### 4. 일정 수정
+ URL: /schedules/{id}
  
+ Method: PUT
  
+ Description: 특정 일정의 내용을 수정합니다.
  
+ Path Parameter:
  
+ id (필수): 수정할 일정의 고유 ID.
  
+ Request Headers:
  
+ Content-Type: application/json
  
+ Request Body:
  
json
```js
{
    "task": "Learn JDBC",
    "author": "Jane Doe",
    "password": "1234"
}
```
+ Response:
  
+ Status: 200 OK
  
+ Body:
  
json
```js
{
    "message": "Schedule updated successfully."
}
```

### 5. 일정 삭제
+URL: /schedules/{id}

+ Method: DELETE

+ Description: 특정 일정을 삭제합니다.

+ Path Parameter:

+ id (필수): 삭제할 일정의 고유 ID.

+ Query Parameter:

+ password (필수): 일정 삭제를 위한 비밀번호.

+ Response:

+ Status: 200 OK

+Body:

json
```js
{
    "message": "Schedule deleted successfully."
}
```
# ERD
![스크린샷 2024-12-09 181841](https://github.com/user-attachments/assets/6eff9a61-8f21-4368-982f-786c67a0ce06)

# API 명세서 상세설명

### 일정 생성

+ 기능: 새로운 일정을 생성합니다.

+ 사용 시점: 클라이언트가 새 할 일을 추가할 때 사용.

### 전체 일정 조회

+ 기능: 등록된 모든 일정을 조회합니다.

+ 사용 시점: 클라이언트가 전체 일정을 확인하려고 할 때 사용.

### 특정 일정 조회

+ 기능: 특정 ID를 가진 일정을 조회합니다.

+ 사용 시점: 클라이언트가 특정 일정을 자세히 확인하려고 할 때 사용.

### 일정 수정 API

+ 기능: 기존 일정의 내용을 수정합니다.

+ 사용 시점: 클라이언트가 특정 일정을 수정하려고 할 때 사용.

### 일정 삭제 API

+ 기능: 기존 일정을 삭제합니다.

+ 사용 시점: 클라이언트가 특정 일정을 삭제하려고 할 때 사용.



