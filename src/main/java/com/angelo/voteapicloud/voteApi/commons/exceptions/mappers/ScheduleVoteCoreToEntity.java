package com.angelo.voteapicloud.voteApi.commons.exceptions.mappers;

import com.angelo.voteapicloud.voteApi.core.domain.dto.rest.ScheduleVoteCore;
import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.ScheduleVoteDTO;
import com.angelo.voteapicloud.voteApi.infra.database.entity.ScheduleVoteEntity;

public class ScheduleVoteCoreToEntity implements GenericMapper<ScheduleVoteEntity, ScheduleVoteCore>{

    @Override
    public ScheduleVoteEntity convertToEntity(ScheduleVoteCore dto) {
        return ScheduleVoteEntity.builder()
                .scheduleName(dto.getScheduleName())
                .scheduleDescription(dto.getScheduleDescription())
                .build();
    }
}

