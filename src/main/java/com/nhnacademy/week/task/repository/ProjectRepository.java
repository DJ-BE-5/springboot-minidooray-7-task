package com.nhnacademy.week.task.repository;

import com.nhnacademy.week.task.entity.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
