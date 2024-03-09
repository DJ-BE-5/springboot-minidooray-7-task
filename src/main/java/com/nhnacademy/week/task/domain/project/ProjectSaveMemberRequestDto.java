package com.nhnacademy.week.task.domain.project;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class ProjectSaveMemberRequestDto {
    @NotBlank(message = "전부 입력하세요")
    private String userId;
}
