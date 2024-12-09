package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleCreateRequest;
import com.example.schedule.dto.ScheduleResponse;
import com.example.schedule.dto.ScheduleUpdateRequest;
import com.example.schedule.service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ScheduleController는 REST API 엔드포인트를 제공하여
 * 일정 생성, 조회, 수정 및 삭제 기능을 처리합니다.
 */
@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    /**
     * 일정 생성 API
     * @param request 생성할 일정의 데이터
     * @return 성공 메시지
     */
    @PostMapping
    public ResponseEntity<String> createSchedule(@Valid @RequestBody ScheduleCreateRequest request) {
        scheduleService.createSchedule(request);
        return ResponseEntity.ok("Schedule created successfully.");
    }

    /**
     * 전체 일정 조회 API
     * @return 등록된 모든 일정의 목록
     */
    @GetMapping
    public ResponseEntity<List<ScheduleResponse>> getAllSchedules() {
        return ResponseEntity.ok(scheduleService.getAllSchedules());
    }

    /**
     * 특정 일정 조회 API
     * @param id 조회할 일정의 ID
     * @return 일정의 상세 정보
     */
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponse> getScheduleById(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.getScheduleById(id));
    }

    /**
     * 일정 수정 API
     * @param id 수정할 일정의 ID
     * @param request 수정할 데이터와 비밀번호
     * @return 성공 메시지
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateSchedule(
            @PathVariable Long id,
            @Valid @RequestBody ScheduleUpdateRequest request) {
        scheduleService.updateSchedule(id, request);
        return ResponseEntity.ok("Schedule updated successfully.");
    }

    /**
     * 일정 삭제 API
     * @param id 삭제할 일정의 ID
     * @param password 일정 삭제를 위한 비밀번호
     * @return 성공 메시지
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id, @RequestParam String password) {
        scheduleService.deleteSchedule(id, password);
        return ResponseEntity.ok("Schedule deleted successfully.");
    }
}
