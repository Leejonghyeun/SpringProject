package com.example.schedule.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 일정 생성 요청 데이터를 처리하는 DTO 클래스.
 * 클라이언트에서 보내는 JSON 데이터를 매핑합니다.
 */
@Data
public class ScheduleCreateRequest {

    /**
     * 일정의 할 일 내용.
     * 필수 값이며, 최대 200자까지 입력 가능합니다.
     */
    @NotBlank(message = "Task is required.")
    @Size(max = 200, message = "Task must not exceed 200 characters.")
    private String task;

    /**
     * 작성자의 이름.
     * 필수 값입니다.
     */
    @NotBlank(message = "Author is required.")
    private String author;

    /**
     * 일정에 대한 비밀번호.
     * 필수 값입니다.
     */
    @NotBlank(message = "Password is required.")
    private String password;
}
