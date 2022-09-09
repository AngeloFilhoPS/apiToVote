package com.angelo.voteapicloud.voteApi.commons.mappers;

import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.VoteDTO;
import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteEntity;

import java.util.Date;

public class VoteDTOtoEntity implements GenericMapper<VoteEntity, VoteDTO>{


    @Override
    public VoteEntity convertToEntity(VoteDTO dto) {
        return VoteEntity.builder()
                .dtVote(new Date())
                .idScheduleVote(dto.getIdScheduleVote())
                .idVoteSession(dto.getIdVoteSession())
                .cpf(dto.getCpf())
                .build();
    }
}
