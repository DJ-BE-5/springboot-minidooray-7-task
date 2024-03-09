package com.nhnacademy.week.task.domain.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectSaveResponseDto {
    private Long projectId;
    private String projectName;
    private String projectStatus;
    private String userId;
    private Integer isAdmin;
}
