package com.nhnacademy.week.task.domain.project;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
public class ProjectSaveRequestDto {
    @NotBlank(message = "프로젝트 이름을 입력하세요")
    private String projectName;
}
