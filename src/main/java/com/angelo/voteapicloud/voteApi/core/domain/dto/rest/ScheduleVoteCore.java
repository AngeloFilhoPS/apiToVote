package com.angelo.voteapicloud.voteApi.core.domain.dto.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleVoteCore {
    @NotBlank(message = "empty/null scheduleName")
    private String scheduleName;

    @NotBlank(message = "empty/null scheduleDescription")
    private String scheduleDescription;
}
