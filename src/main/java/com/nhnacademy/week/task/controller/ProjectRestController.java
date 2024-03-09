package com.nhnacademy.week.task.controller;

import com.nhnacademy.week.task.domain.project.*;
import com.nhnacademy.week.task.service.project.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ProjectRestController {
    private ProjectService projectService;

    public ProjectRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/projects")
    public ResponseEntity<ProjectSaveResponseDto> createProject(@Valid @RequestBody ProjectSaveRequestDto requestDto,
                                                                HttpServletRequest request){
//        String userId = request.getSession().getAttribute("userId").toString();
//        ProjectSaveResponseDto responseDto = projectService.createProject(requestDto,userId);
        ProjectSaveResponseDto responseDto = projectService.createProject(requestDto,"userName");

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PostMapping("/projects/{projectId}/member")
    public ResponseEntity<ProjectSaveMemberResponseDto> addUserToProject(@PathVariable("projectId") Long projectId,
                                                                         @Valid @RequestBody ProjectSaveMemberRequestDto requestDto){
        ProjectSaveMemberResponseDto responseDto = projectService.addMemberToProject(projectId, requestDto);

        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/projects/{userId}")
    public ResponseEntity<List<ProjectGetUserIdResponse>> getProjectsFromUserId(@PathVariable("userId") String userId){
        List<ProjectGetUserIdResponse> respList = projectService.getProjectByUserId(userId);

        return ResponseEntity.ok().body(respList);
    }

    @GetMapping("/projects/project/{projectId}")
    public ResponseEntity<ProjectGetResponse> getProject(@PathVariable("projectId") Long projectId){
        ProjectGetResponse responseDto = projectService.getProject(projectId);

        return ResponseEntity.ok().body(responseDto);
    }


}
