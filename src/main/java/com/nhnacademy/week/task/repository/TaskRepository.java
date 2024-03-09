package com.nhnacademy.week.task.repository;

import com.nhnacademy.week.task.entity.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProject_ProjectIdAndUserId(Long projectId, String userId);

    Task findByTaskIdAndProject_ProjectId(Long taskId, Long projectId);
}
