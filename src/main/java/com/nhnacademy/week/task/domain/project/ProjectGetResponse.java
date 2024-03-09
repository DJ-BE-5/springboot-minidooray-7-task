package com.nhnacademy.week.task.domain.project;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectGetResponse {
    private Long projectId;
    private String projectName;
    private String projectStatus;
}
