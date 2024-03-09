package com.nhnacademy.week.task.repository;

import com.nhnacademy.week.task.entity.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
