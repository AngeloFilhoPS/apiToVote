package com.angelo.voteapicloud.voteApi.infra.database.entity;

import com.angelo.voteapicloud.voteApi.commons.exceptions.mappers.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class VoteSessionEntity implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean sessionOpen;

    @NotNull(message = "id for ScheduleVote cannot be null")
    private Long idScheduleVote;

    private Integer minDurationSession;

    private int votesYes;

    private int votesNo;

    private Date dtOpenSession;
}

