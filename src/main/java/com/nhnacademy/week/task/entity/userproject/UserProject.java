package com.nhnacademy.week.task.entity.userproject;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity@Table(name = "week_user_project")
public class UserProject {
    @EmbeddedId
    private UserProjectPk userProjectPk;

    @Column(name = "isAdmin")
    private Integer isAdmin;

    @Embeddable
    @Getter@Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString@EqualsAndHashCode
    public static class UserProjectPk implements Serializable {
        @Column(name = "user_id")
        private String userId;
        @Column(name = "project_id")
        private Long projectId;
    }
}
