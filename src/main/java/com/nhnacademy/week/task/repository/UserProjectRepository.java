package com.nhnacademy.week.task.repository;

import com.nhnacademy.week.task.entity.userproject.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProjectRepository extends JpaRepository<UserProject, UserProject.UserProjectPk> {
    List<UserProject> findByUserProjectPk_UserId(String userId);

    boolean existsByUserProjectPk_UserId(String userId);
}
