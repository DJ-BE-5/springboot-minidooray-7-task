package com.nhnacademy.week.task.domain.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectSaveMemberResponseDto {
    private String userId;
    private Long projectId;
    private Integer isAdmin;
}
