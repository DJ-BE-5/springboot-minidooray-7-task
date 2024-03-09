package com.nhnacademy.week.task.domain.project;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectSaveMemberRequestDto {
    private String userId;
    private Integer isAdmin;
}
