package com.nhnacademy.week.task.entity.task;

import com.nhnacademy.week.task.entity.project.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity@Table(name = "week_task")
public class Task {
    @Id
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "task_comment")
    private String taskComment;

    @JoinColumn(name = "project_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Project project;

    @JoinColumn(name = "user_id")
    private String userId;
}
