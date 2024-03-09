package com.nhnacademy.week.task.domain.task;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class TaskPostRequestDto {
    @NotBlank
    @Size(max = 1000)
    private String comment;
}
