package com.angelo.voteapicloud.voteApi.core.adapter;

import com.angelo.voteapicloud.voteApi.commons.mappers.ScheduleVoteCoreToEntity;
import com.angelo.voteapicloud.voteApi.commons.mappers.ScheduleVoteDTOtoEntity;
import com.angelo.voteapicloud.voteApi.core.port.ScheduleVoteControllerPort;
import com.angelo.voteapicloud.voteApi.entrypoint.rest.controller.ScheduleVoteController;
import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.ScheduleVoteDTO;
import com.angelo.voteapicloud.voteApi.infra.database.adapter.ScheduleVoteAdapter;
import com.angelo.voteapicloud.voteApi.infra.database.entity.ScheduleVoteEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleVoteControllerAdapter implements ScheduleVoteControllerPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleVoteControllerAdapter.class);

    @Autowired
    ScheduleVoteAdapter scheduleVoteAdapter;

    private final ScheduleVoteDTOtoEntity scheduleVoteDTOtoEntity = new ScheduleVoteDTOtoEntity();

    @Override
    public void registerSchedule(ScheduleVoteDTO scheduleVoteDTO) throws Exception {
        LOGGER.info("ScheduleVoteControllerAdapter - registerSchedule - send to repository");
        scheduleVoteAdapter.registerScheduleVoteEntity(scheduleVoteDTOtoEntity.convertToEntity(scheduleVoteDTO));
    }

    @Override
    public List<ScheduleVoteEntity> findAllScheduleVotes() throws Exception {
        LOGGER.info("ScheduleVoteControllerAdapter - findAllSchedule - find in repository");
        return scheduleVoteAdapter.findAllScheduleVote();
    }
}
