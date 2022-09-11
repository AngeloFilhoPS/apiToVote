package com.angelo.voteapicloud.voteApi.core.adapter;

import com.angelo.voteapicloud.voteApi.commons.mappers.VoteDTOtoEntity;
import com.angelo.voteapicloud.voteApi.core.port.VoteControllerPort;
import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.VoteDTO;
import com.angelo.voteapicloud.voteApi.infra.database.adapter.VoteAdapter;
import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteControllerAdapter implements VoteControllerPort {

    @Autowired
    VoteAdapter voteAdapter;

    private final VoteDTOtoEntity voteDTOtoEntity = new VoteDTOtoEntity();


    @Override
    public VoteEntity sendVote(VoteDTO voteDTO) throws Exception {
        return  voteAdapter.sendVote(voteDTOtoEntity.convertToEntity(voteDTO));
    }
}

