package com.example.schedule.service;

import com.example.schedule.dto.ScheduleCreateRequest;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ScheduleService는 일정 관리 비즈니스 로직을 처리하는 클래스입니다.
 */
@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    /**
     * 일정 생성 로직
     * @param request 생성할 일정의 데이터
     */
    public void createSchedule(ScheduleCreateRequest request) {
        Schedule schedule = Schedule.builder()
                .task(request.getTask())
                .author(request.getAuthor())
                .password(request.getPassword())
                .build();
        scheduleRepository.save(schedule);
    }

    /**
     * 전체 일정 조회 로직
     * @return 모든 일정의 목록을 ScheduleResponse로 반환
     */
    public List<ScheduleResponse> getAllSchedules() {
        return scheduleRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /**
     * 특정 일정 조회 로직
     * @param id 조회할 일정의 ID
     * @return 조회된 일정 정보를 ScheduleResponse로 반환
     */
    public ScheduleResponse getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id);
        return mapToResponse(schedule);
    }

    /**
     * 일정 수정 로직
     * @param id 수정할 일정의 ID
     * @param request 수정할 데이터와 비밀번호
     */
    public void updateSchedule(Long id, ScheduleUpdateRequest request) {
        Schedule schedule = scheduleRepository.findById(id);

        if (!schedule.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Invalid password.");
        }

        schedule.setTask(request.getTask());
        schedule.setAuthor(request.getAuthor());
        scheduleRepository.update(id, schedule.getTask(), schedule.getAuthor());
    }

    /**
     * 일정 삭제 로직
     * @param id 삭제할 일정의 ID
     * @param password 삭제를 위한 비밀번호
     */
    public void deleteSchedule(Long id, String password) {
        Schedule schedule = scheduleRepository.findById(id);

        if (!schedule.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid password.");
        }

        scheduleRepository.deleteById(id);
    }

    /**
     * Schedule 엔티티를 ScheduleResponse로 변환
     * @param schedule 변환할 엔티티
     * @return 변환된 응답 데이터
     */
    private ScheduleResponse mapToResponse(Schedule schedule) {
        return ScheduleResponse.builder()
                .id(schedule.getId())
                .task(schedule.getTask())
                .author(schedule.getAuthor())
                .createdAt(schedule.getCreatedAt())
                .updatedAt(schedule.getUpdatedAt())
                .build();
    }
}
