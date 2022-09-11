package com.angelo.voteapicloud.voteApi.core.adapter;

import com.angelo.voteapicloud.voteApi.commons.mappers.ScheduleVoteCoreToEntity;
import com.angelo.voteapicloud.voteApi.commons.mappers.ScheduleVoteDTOtoEntity;
import com.angelo.voteapicloud.voteApi.core.port.ScheduleVoteControllerPort;
import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.ScheduleVoteDTO;
import com.angelo.voteapicloud.voteApi.infra.database.adapter.ScheduleVoteAdapter;
import com.angelo.voteapicloud.voteApi.infra.database.entity.ScheduleVoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleVoteControllerAdapter implements ScheduleVoteControllerPort {


    @Autowired
    ScheduleVoteAdapter scheduleVoteAdapter;

    private final ScheduleVoteDTOtoEntity scheduleVoteDTOtoEntity = new ScheduleVoteDTOtoEntity();


    private final ScheduleVoteCoreToEntity scheduleVoteCoreToEntity = new ScheduleVoteCoreToEntity();

    @Override
    public void registerSchedule(ScheduleVoteDTO scheduleVoteDTO) throws Exception {
        scheduleVoteAdapter.registerScheduleVoteEntity(scheduleVoteDTOtoEntity.convertToEntity(scheduleVoteDTO));
    }

    @Override
    public List<ScheduleVoteEntity> findAllScheduleVotes() throws Exception {
       return scheduleVoteAdapter.findAllScheduleVote();
    }
}
