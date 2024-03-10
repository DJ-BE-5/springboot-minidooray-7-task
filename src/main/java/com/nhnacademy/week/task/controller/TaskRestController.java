package com.nhnacademy.week.task.controller;

import com.nhnacademy.week.task.domain.task.TaskPostRequestDto;
import com.nhnacademy.week.task.domain.task.TaskResponseDto;
import com.nhnacademy.week.task.service.task.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
public class TaskRestController {
    private TaskService taskService;

    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/projects/{projectId}/tasks")
    public ResponseEntity<TaskResponseDto> createTask(@PathVariable("projectId") Long projectId,
                                                      @Valid @RequestBody TaskPostRequestDto requestDto,
                                                      HttpServletRequest request){
        String userId = request.getSession().getAttribute("user").toString();
        TaskResponseDto respDto = taskService.createTasks(projectId, userId, requestDto);
//        TaskResponseDto respDto = taskService.createTasks(projectId, "userName", requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(respDto);
    }

    @PutMapping("/projects/{projectId}/tasks/{tasksId}")
    public ResponseEntity<TaskResponseDto> modifyTask(@PathVariable("projectId") Long projectId,
                                                      @PathVariable("tasksId") Long taskId,
                                                      @Valid @RequestBody TaskPostRequestDto dto){
        TaskResponseDto respDto = taskService.modifyTasks(projectId, taskId, dto.getComment());

        return ResponseEntity.ok().body(respDto);
    }

    @DeleteMapping("/projects/{projectId}/tasks/{tasksId}")
    public ResponseEntity<String> deleteTask(@PathVariable("projectId") Long projectId,
                                                      @PathVariable("tasksId") Long taskId){
        String str = taskService.deleteTasks(projectId, taskId);

        return ResponseEntity.ok().body(str);
    }

    @GetMapping("/projects/{projectId}/tasks")
    public ResponseEntity<List<TaskResponseDto>> getAllTasks(@PathVariable("projectId") Long projectId,
                                                             HttpServletRequest req){
        String userId = req.getSession().getAttribute("userId").toString();
        List<TaskResponseDto> responseDtoList = taskService.getAllTasks(projectId, userId);
//        List<TaskResponseDto> responseDtoList = taskService.getAllTasks(projectId, "userName");

        return ResponseEntity.ok().body(responseDtoList);
    }

    @GetMapping("/projects/{projectId}/tasks/{tasksId}")
    public ResponseEntity<TaskResponseDto> getTasks(@PathVariable("projectId") Long projectId,
                                                         @PathVariable("tasksId") Long taskId){
        TaskResponseDto dto= taskService.getTask(projectId,taskId);
        return ResponseEntity.ok().body(dto);
    }
}
