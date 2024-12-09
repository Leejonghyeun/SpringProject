package com.example.schedule.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

/**
 * 일정 수정 요청 데이터를 처리하는 DTO 클래스.
 * 클라이언트에서 보내는 JSON 데이터를 매핑합니다.
 */
@Data
public class ScheduleUpdateRequest {

    /**
     * 수정할 일정의 새로운 할 일 내용.
     * 필수 값입니다.
     */
    @NotBlank(message = "Task is required.")
    private String task;

    /**
     * 수정할 일정의 새로운 작성자 이름.
     * 필수 값입니다.
     */
    @NotBlank(message = "Author is required.")
    private String author;

    /**
     * 일정 수정 시 인증에 사용되는 비밀번호.
     * 필수 값입니다.
     */
    @NotBlank(message = "Password is required.")
    private String password;
}
