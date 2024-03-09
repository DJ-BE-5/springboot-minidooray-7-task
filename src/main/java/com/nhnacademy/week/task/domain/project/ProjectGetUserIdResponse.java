package com.nhnacademy.week.task.domain.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectGetUserIdResponse {
    private Long projectId;
    private Integer isAdmin;
}
