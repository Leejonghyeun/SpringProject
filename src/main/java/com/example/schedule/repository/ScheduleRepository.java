package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;


//ScheduleRepository는 데이터베이스와의 상호작용을 처리

@Repository
public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


     //일정 엔티티를 데이터베이스에서 조회할 때 사용하는 RowMapper

    private final RowMapper<Schedule> scheduleRowMapper = new RowMapper<>() {
        @Override
        public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Schedule.builder()
                    .id(rs.getLong("id"))
                    .task(rs.getString("task"))
                    .author(rs.getString("author"))
                    .password(rs.getString("password"))
                    .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                    .updatedAt(rs.getTimestamp("updated_at").toLocalDateTime())
                    .build();
        }
    };

    /**
     * 일정 저장
     * @param schedule 저장할 일정 엔티티
     * @return 저장된 행 수
     */
    public int save(Schedule schedule) {
        String sql = "INSERT INTO schedules (task, author, password, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, schedule.getTask(), schedule.getAuthor(), schedule.getPassword(),
                LocalDateTime.now(), LocalDateTime.now());
    }

    /**
     * 모든 일정 조회
     * @return 일정 목록
     */
    public List<Schedule> findAll() {
        String sql = "SELECT * FROM schedules ORDER BY updated_at DESC";
        return jdbcTemplate.query(sql, scheduleRowMapper);
    }

}
