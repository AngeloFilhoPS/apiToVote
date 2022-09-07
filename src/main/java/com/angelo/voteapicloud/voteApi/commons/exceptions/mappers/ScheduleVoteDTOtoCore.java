package com.angelo.voteapicloud.voteApi.commons.exceptions.mappers;

import com.angelo.voteapicloud.voteApi.core.domain.dto.rest.ScheduleVoteCore;
import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.ScheduleVoteDTO;

public class ScheduleVoteDTOtoCore implements GenericMapper<ScheduleVoteCore, ScheduleVoteDTO>{


    @Override
    public ScheduleVoteCore convertToEntity(ScheduleVoteDTO dto) {

            return ScheduleVoteCore.builder()
                    .scheduleName(dto.getScheduleName())
                    .scheduleDescription(dto.getScheduleDescription())
                    .build();

    }
}

