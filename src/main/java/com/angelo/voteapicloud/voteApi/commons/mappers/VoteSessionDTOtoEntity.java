package com.angelo.voteapicloud.voteApi.commons.mappers;

import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.VoteSessionDTO;
import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteSessionEntity;

import java.util.Date;

public class VoteSessionDTOtoEntity implements GenericMapper<VoteSessionEntity, VoteSessionDTO>{


    @Override
    public VoteSessionEntity convertToEntity(VoteSessionDTO dto) {
        return VoteSessionEntity.builder()
                .dtOpenSession(new Date())
                .idScheduleVote(dto.getIdScheduleVote())
                .minDurationSession(dto.getMinDurationSession())
                .sessionOpen(true)
                .votesNo(0)
                .votesYes(0)
                .build();

    }
}
