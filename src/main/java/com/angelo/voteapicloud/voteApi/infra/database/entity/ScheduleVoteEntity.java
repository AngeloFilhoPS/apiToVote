package com.angelo.voteapicloud.voteApi.infra.database.entity;

import com.angelo.voteapicloud.voteApi.commons.mappers.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleVoteEntity implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "scheduleName cannot be null")
    private String scheduleName;

    @NotBlank(message = "scheduleDescription cannot be null")
    private String scheduleDescription;

    @Override
    public Object getId() {
        return null;
    }

    @Override
    public void setId(Object o) {

    }
}
