package com.nhnacademy.week.task.service.task.impl;

import com.nhnacademy.week.task.domain.task.TaskPostRequestDto;
import com.nhnacademy.week.task.domain.task.TaskResponseDto;
import com.nhnacademy.week.task.entity.task.Task;
import com.nhnacademy.week.task.exception.ProjectNotExistException;
import com.nhnacademy.week.task.exception.TaskNotDeletedException;
import com.nhnacademy.week.task.exception.TaskNotExistException;
import com.nhnacademy.week.task.repository.ProjectRepository;
import com.nhnacademy.week.task.repository.TaskRepository;
import com.nhnacademy.week.task.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public TaskResponseDto createTasks(Long projectId, String userId, TaskPostRequestDto dto) {
        if(!projectRepository.existsById(projectId)){
            throw new ProjectNotExistException();
        }
        Task saveTask = new Task();
        saveTask.setTaskComment(dto.getComment());
        saveTask.setUserId(userId);
        saveTask.setProject(projectRepository.findById(projectId).get());

        Task savedTask = taskRepository.save(saveTask);

        TaskResponseDto responseDto = TaskResponseDto.builder()
                .taskId(savedTask.getTaskId())
                .taskComment(savedTask.getTaskComment())
                .projectId(savedTask.getProject().getProjectId())
                .userId(savedTask.getUserId())
                .build();

        return responseDto;
    }

    @Override
    public TaskResponseDto modifyTasks(Long projectId, Long taskId, String comment) {
        if(!projectRepository.existsById(projectId)){
            throw new ProjectNotExistException();
        }if(!taskRepository.existsById(taskId)){
            throw new TaskNotExistException();
        }

        Task task = taskRepository.findById(taskId).get();
        task.setTaskComment(comment);

        Task newTask = taskRepository.save(task);

        TaskResponseDto responseDto = TaskResponseDto.builder()
                .taskId(newTask.getTaskId())
                .taskComment(newTask.getTaskComment())
                .projectId(newTask.getTaskId())
                .userId(newTask.getUserId())
                .build();

        return responseDto;
    }

    @Override
    public String deleteTasks(Long projectId, Long taskId) {
        if(!projectRepository.existsById(projectId)){
            throw new ProjectNotExistException();
        }if(!taskRepository.existsById(taskId)){
            throw new TaskNotExistException();
        }

        taskRepository.deleteById(taskId);

        if(taskRepository.existsById(taskId)){
            throw new TaskNotDeletedException();
        }

        return "delete succeed";
    }

    @Override
    public List<TaskResponseDto> getAllTasks(Long projectId, String userId) {
        if(!projectRepository.existsById(projectId)) {
            throw new ProjectNotExistException();
        }
        List<Task> taskList = taskRepository.findByProject_ProjectIdAndUserId(projectId,userId);
        List<TaskResponseDto> responseDtoList = new ArrayList<>();
        for (Task task : taskList) {
            TaskResponseDto taskResponseDto = TaskResponseDto.builder()
                    .taskId(task.getTaskId())
                    .taskComment(task.getTaskComment())
                    .projectId(task.getTaskId())
                    .userId(task.getUserId())
                    .build();

            responseDtoList.add(taskResponseDto);
        }

        return responseDtoList;
    }

    @Override
    public TaskResponseDto getTask(Long projectId, Long taskId) {
        if(!projectRepository.existsById(projectId)){
            throw new ProjectNotExistException();
        }if(!taskRepository.existsById(taskId)){
            throw new TaskNotExistException();
        }
        Task task = taskRepository.findByTaskIdAndProject_ProjectId(taskId,projectId);

        TaskResponseDto dto = TaskResponseDto.builder()
                .taskId(task.getTaskId())
                .taskComment(task.getTaskComment())
                .projectId(task.getProject().getProjectId())
                .userId(task.getUserId())
                .build();

        return dto;
    }
}
