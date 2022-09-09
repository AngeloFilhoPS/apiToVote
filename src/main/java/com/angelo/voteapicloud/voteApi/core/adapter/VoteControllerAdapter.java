package com.angelo.voteapicloud.voteApi.core.adapter;

import com.angelo.voteapicloud.voteApi.core.port.VoteControllerPort;
import com.angelo.voteapicloud.voteApi.infra.database.adapter.VoteAdapter;
import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteControllerAdapter implements VoteControllerPort {

    @Autowired
    VoteAdapter voteAdapter;

    @Override
    public VoteEntity sendVote(VoteEntity voteEntity) throws Exception {
        return  voteAdapter.sendVote(voteEntity);
    }
}

