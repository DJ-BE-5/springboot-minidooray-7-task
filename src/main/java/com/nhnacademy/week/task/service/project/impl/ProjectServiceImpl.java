package com.nhnacademy.week.task.service.project.impl;

import com.nhnacademy.week.task.domain.project.*;
import com.nhnacademy.week.task.entity.project.Project;
import com.nhnacademy.week.task.entity.project.ProjectStatusCode;
import com.nhnacademy.week.task.entity.userproject.UserProject;
import com.nhnacademy.week.task.exception.ProjectNotExistException;
import com.nhnacademy.week.task.exception.UserProjectNotExistException;
import com.nhnacademy.week.task.repository.ProjectRepository;
import com.nhnacademy.week.task.repository.UserProjectRepository;
import com.nhnacademy.week.task.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserProjectRepository userProjectRepository;

    public ProjectSaveResponseDto createProject(ProjectSaveRequestDto requestDto, String userId){
        Project project = new Project();
        project.setProjectName(requestDto.getProjectName());
        project.setProjectStatus(ProjectStatusCode.ACTIVE);

        Project savedProject = projectRepository.save(project);

        UserProject userProject = new UserProject();
        userProject.setUserProjectPk(new UserProject.UserProjectPk(userId, savedProject.getProjectId()));
        userProject.setIsAdmin(1);

        UserProject savedUserProject = userProjectRepository.save(userProject);

        ProjectSaveResponseDto responseDto = ProjectSaveResponseDto.builder()
                .projectId(savedProject.getProjectId())
                .projectName(savedProject.getProjectName())
                .projectStatus(String.valueOf(savedProject.getProjectStatus()))
                .userId(savedUserProject.getUserProjectPk().getUserId())
                .isAdmin(savedUserProject.getIsAdmin())
                .build();

        return responseDto;
    }

    public ProjectSaveMemberResponseDto addMemberToProject(Long projectId, ProjectSaveMemberRequestDto requestDto){
        UserProject userProject = new UserProject();
        userProject.setUserProjectPk(new UserProject.UserProjectPk(requestDto.getUserId(), projectId));
        userProject.setIsAdmin(2);

        UserProject newUserProject = userProjectRepository.save(userProject);

        ProjectSaveMemberResponseDto responseDto = ProjectSaveMemberResponseDto.builder()
                .projectId(newUserProject.getUserProjectPk().getProjectId())
                .userId(newUserProject.getUserProjectPk().getUserId())
                .isAdmin(newUserProject.getIsAdmin())
                .build();

        return responseDto;
    }
    @Override
    public List<ProjectGetUserIdResponse> getProjectByUserId(String userId) {
        if(!userProjectRepository.existsByUserProjectPk_UserId(userId)){
            throw new UserProjectNotExistException();
        }
        List<UserProject> userProjects = userProjectRepository.findByUserProjectPk_UserId(userId);
        List<ProjectGetUserIdResponse> respList = new ArrayList<>();
        for (UserProject userProject : userProjects) {
            respList.add(new ProjectGetUserIdResponse(userProject.getUserProjectPk().getProjectId(), userProject.getIsAdmin()));
        }

        return respList;
    }

    @Override
    public ProjectGetResponse getProject(Long projectId) {
        if(!projectRepository.existsById(projectId)){
            throw new ProjectNotExistException();
        }
        Project project = projectRepository.findById(projectId).get();
        ProjectGetResponse resp = new ProjectGetResponse();
        resp.setProjectId(project.getProjectId());
        resp.setProjectName(project.getProjectName());
        resp.setProjectStatus(String.valueOf(project.getProjectStatus()));

        return resp;
    }
}
