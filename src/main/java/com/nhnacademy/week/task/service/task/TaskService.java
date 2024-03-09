package com.nhnacademy.week.task.service.task;

import com.nhnacademy.week.task.domain.task.TaskPostRequestDto;
import com.nhnacademy.week.task.domain.task.TaskResponseDto;

import java.util.List;

public interface TaskService {
    TaskResponseDto createTasks(Long projectId, String userId, TaskPostRequestDto dto);
    TaskResponseDto modifyTasks(Long projectId, Long taskId, String comment);
    String deleteTasks(Long projectId, Long taskId);
    List<TaskResponseDto> getAllTasks(Long projectId, String userId);
    TaskResponseDto getTask(Long projectId, Long taskId);
}
