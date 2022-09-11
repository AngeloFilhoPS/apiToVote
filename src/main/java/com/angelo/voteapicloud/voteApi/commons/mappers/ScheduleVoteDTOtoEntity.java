package com.angelo.voteapicloud.voteApi.commons.mappers;

import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.ScheduleVoteDTO;
import com.angelo.voteapicloud.voteApi.infra.database.entity.ScheduleVoteEntity;

public class ScheduleVoteDTOtoEntity implements GenericMapper<ScheduleVoteEntity, ScheduleVoteDTO>{


    @Override
    public ScheduleVoteEntity convertToEntity(ScheduleVoteDTO dto) {

            return ScheduleVoteEntity.builder()
                    .scheduleName(dto.getScheduleName())
                    .scheduleDescription(dto.getScheduleDescription())
                    .build();

    }
}

