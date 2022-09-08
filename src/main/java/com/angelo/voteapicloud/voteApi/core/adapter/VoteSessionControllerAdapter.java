package com.angelo.voteapicloud.voteApi.core.adapter;

import com.angelo.voteapicloud.voteApi.core.port.VoteSessionControllerPort;
import com.angelo.voteapicloud.voteApi.entrypoint.rest.controller.VoteSessionController;
import com.angelo.voteapicloud.voteApi.infra.database.adapter.VoteSessionAdapter;
import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteSessionEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteSessionControllerAdapter implements VoteSessionControllerPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(VoteSessionControllerAdapter.class);


    @Autowired
    VoteSessionAdapter voteSessionAdapter;

    @Override
    public VoteSessionEntity registerVoteSession(VoteSessionEntity voteSessionEntity) throws Exception {
        LOGGER.info("CORE - register vote session - send to infra");
        return voteSessionAdapter.registerVoteSession(voteSessionEntity);
    }
}

