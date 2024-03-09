package com.nhnacademy.week.task.service.project;

import com.nhnacademy.week.task.domain.project.*;

import java.util.List;

public interface ProjectService {
    ProjectSaveResponseDto createProject(ProjectSaveRequestDto requestDto,String userId);
    ProjectSaveMemberResponseDto addMemberToProject(Long projectId, ProjectSaveMemberRequestDto requestDto);
    List<ProjectGetUserIdResponse> getProjectByUserId(String userId);
    ProjectGetResponse getProject(Long projectId);
}