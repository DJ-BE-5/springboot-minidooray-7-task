package com.nhnacademy.week.task.service.project.impl;

import com.nhnacademy.week.task.entity.project.Project;
import com.nhnacademy.week.task.entity.project.ProjectStatusCode;
import com.nhnacademy.week.task.entity.userproject.UserProject;
import com.nhnacademy.week.task.repository.ProjectRepository;
import com.nhnacademy.week.task.repository.UserProjectRepository;
import com.nhnacademy.week.task.service.project.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class ProjectServiceImplTest {
    @Mock
    private ProjectRepository projectRepository;
    @Mock
    private UserProjectRepository userProjectRepository;

    @InjectMocks
    private ProjectService projectService;

    @BeforeEach
    void setUp() {
        Project testProject = new Project();
        testProject.setProjectId(1l);
        testProject.setProjectName("name");
        testProject.setProjectStatus(ProjectStatusCode.ACTIVE);

        String userId = "testIdSample";

        UserProject userProject = new UserProject();
        userProject.setUserProjectPk(new UserProject.UserProjectPk(userId, testProject.getProjectId()));
        userProject.setIsAdmin(1);
    }

    @Test
    void createProject() {
    }

    @Test
    void addMemberToProject() {
    }

    @Test
    void getProjectByUserId() {
    }

    @Test
    void getProject() {
    }
}