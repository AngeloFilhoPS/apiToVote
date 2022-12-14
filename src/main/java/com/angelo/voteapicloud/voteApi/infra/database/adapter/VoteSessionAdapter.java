package com.angelo.voteapicloud.voteApi.infra.database.adapter;

import com.angelo.voteapicloud.voteApi.commons.mappers.VoteSessionDTOtoEntity;
import com.angelo.voteapicloud.voteApi.core.port.VoteSessionControllerPort;
import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.VoteSessionDTO;
import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteSessionEntity;
import com.angelo.voteapicloud.voteApi.infra.database.repository.ScheduleVoteRepository;
import com.angelo.voteapicloud.voteApi.infra.database.repository.VoteSessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteSessionAdapter implements VoteSessionControllerPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(VoteSessionAdapter.class);


    @Autowired
    private VoteSessionRepository voteSessionRepository;

    @Autowired
    private ScheduleVoteRepository scheduleVoteRepository;
    private final VoteSessionDTOtoEntity voteSessionDTOtoEntity = new VoteSessionDTOtoEntity();


    @Override
    public VoteSessionEntity registerVoteSession(VoteSessionDTO voteSessionDTO) throws Exception {
        LOGGER.info("INFRA - registerVoteSession - validScheduleVote");
        validScheduleVote(voteSessionDTO.getIdScheduleVote());
        return voteSessionRepository.save(voteSessionDTOtoEntity.convertToEntity(voteSessionDTO));
    }

    @Override
    public VoteSessionEntity finishSessionVotes(Long id) throws Exception {
        return null;
    }


    public boolean validScheduleVote(Long idScheduleVote) throws Exception{
        LOGGER.info("INFRA - validScheduleVote - isValid");
        if(scheduleVoteRepository.findById(idScheduleVote).isPresent()){
            LOGGER.info("INFRA - validScheduleVote - isValid");
            return true;
        } else {
            LOGGER.info("INFRA - validScheduleVote - no Valid");
            throw new Exception("Não foram encontradas pautas com o referente Id");
        }

    }
}
