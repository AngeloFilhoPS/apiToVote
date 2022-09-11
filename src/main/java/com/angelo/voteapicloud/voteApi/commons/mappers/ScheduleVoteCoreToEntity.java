package com.angelo.voteapicloud.voteApi.commons.mappers;

import com.angelo.voteapicloud.voteApi.core.domain.dto.rest.ScheduleVoteEntity;

public class ScheduleVoteCoreToEntity implements GenericMapper<com.angelo.voteapicloud.voteApi.infra.database.entity.ScheduleVoteEntity, ScheduleVoteEntity>{

    @Override
    public com.angelo.voteapicloud.voteApi.infra.database.entity.ScheduleVoteEntity convertToEntity(ScheduleVoteEntity dto) {
        return com.angelo.voteapicloud.voteApi.infra.database.entity.ScheduleVoteEntity.builder()
                .scheduleName(dto.getScheduleName())
                .scheduleDescription(dto.getScheduleDescription())
                .build();
    }
}

