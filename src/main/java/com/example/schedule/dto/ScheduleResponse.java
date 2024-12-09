package com.example.schedule.dto;

import lombok.Data;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * 일정 조회 응답 데이터를 처리하는 DTO 클래스.
 * 서버에서 클라이언트로 반환되는 데이터를 매핑합니다.
 */
@Data
@Builder
public class ScheduleResponse {

    /**
     * 일정의 고유 식별자 (ID).
     */
    private Long id;

    /**
     * 일정의 할 일 내용.
     */
    private String task;

    /**
     * 일정의 작성자 이름.
     */
    private String author;

    /**
     * 일정이 생성된 날짜와 시간.
     */
    private LocalDateTime createdAt;

    /**
     * 일정이 마지막으로 수정된 날짜와 시간.
     */
    private LocalDateTime updatedAt;
}
