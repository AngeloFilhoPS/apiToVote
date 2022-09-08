package com.angelo.voteapicloud.voteApi.entrypoint.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VoteSessionDTO {

    @NotNull(message = "id for ScheduleVote cannot be null")
    private Long idScheduleVote;

    private Integer minDurationSession;
}
