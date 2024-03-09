package com.nhnacademy.week.task.domain.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDto {
    private Long taskId;
    private String taskComment;
    private Long projectId;
    private String userId;
}
