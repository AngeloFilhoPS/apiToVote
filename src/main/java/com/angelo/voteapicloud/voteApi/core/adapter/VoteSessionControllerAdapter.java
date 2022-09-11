package com.angelo.voteapicloud.voteApi.core.adapter;

import com.angelo.voteapicloud.voteApi.core.port.VoteSessionControllerPort;
import com.angelo.voteapicloud.voteApi.infra.database.adapter.VoteAdapter;
import com.angelo.voteapicloud.voteApi.infra.database.adapter.VoteSessionAdapter;
import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteEntity;
import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteSessionEntity;
import com.angelo.voteapicloud.voteApi.infra.database.repository.VoteSessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VoteSessionControllerAdapter implements VoteSessionControllerPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(VoteSessionControllerAdapter.class);

    @Autowired
    VoteSessionRepository voteSessionRepository;

    @Autowired
    VoteSessionAdapter voteSessionAdapter;

    @Autowired
    VoteAdapter voteAdapter;

    @Override
    public VoteSessionEntity registerVoteSession(VoteSessionEntity voteSessionEntity) throws Exception {
        LOGGER.info("CORE - register vote session - send to infra");
        return voteSessionAdapter.registerVoteSession(voteSessionEntity);
    }

    @Override
    public VoteSessionEntity finishSessionVotes(Long id) throws Exception {
        LOGGER.info("CORE - finishSessionVotes - vote session end start");
        voteSessionAdapter.validScheduleVote(id);
        LOGGER.info("CORE - finishSessionVotes - validScheduleVote completed");
        VoteSessionEntity voteSessionEntity = countVotes(voteSessionRepository.getById(id));
        LOGGER.info("CORE - finishSessionVotes - count votes completed");
        voteSessionEntity.setSessionOpen(false);
        LOGGER.info("CORE - finishSessionVotes - session vote closed saving and returning");
        return voteSessionRepository.save(voteSessionEntity);

    }

    private VoteSessionEntity countVotes(VoteSessionEntity voteSessionEntity) throws Exception {
        int yesvotes = 0;
        int novotes = 0;

        List<VoteEntity> countVotes = voteAdapter.findAllVoteEntityByIdVoteSession(voteSessionEntity.getId());

        for (VoteEntity voteEntity:countVotes){
            if(Objects.equals(voteEntity.getVote(), "SIM"))
                yesvotes++;
            if(Objects.equals(voteEntity.getVote(), "NAO"))
                novotes++;
        }
        voteSessionEntity.setVotesYes(yesvotes);
        voteSessionEntity.setVotesNo(novotes);
        return voteSessionEntity;
    }

}

