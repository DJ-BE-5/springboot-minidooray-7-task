package com.nhnacademy.week.task.service.task.impl;

import com.nhnacademy.week.task.repository.TaskRepository;
import com.nhnacademy.week.task.service.task.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
