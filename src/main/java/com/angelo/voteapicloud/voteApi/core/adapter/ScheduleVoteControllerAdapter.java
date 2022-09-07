package com.angelo.voteapicloud.voteApi.core.adapter;

import com.angelo.voteapicloud.voteApi.commons.exceptions.mappers.ScheduleVoteCoreToEntity;
import com.angelo.voteapicloud.voteApi.core.domain.dto.rest.ScheduleVoteCore;
import com.angelo.voteapicloud.voteApi.core.port.ScheduleVoteControllerPort;
import com.angelo.voteapicloud.voteApi.infra.database.adapter.ScheduleVoteAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleVoteControllerAdapter implements ScheduleVoteControllerPort {

    @Autowired
    ScheduleVoteAdapter scheduleVoteAdapter;

    private final ScheduleVoteCoreToEntity scheduleVoteCoreToEntity = new ScheduleVoteCoreToEntity();

    @Override
    public void registerSchedule(ScheduleVoteCore scheduleVoteCore) throws Exception {
        scheduleVoteAdapter.registerScheduleVoteEntity(scheduleVoteCoreToEntity.convertToEntity(scheduleVoteCore));
    }
}
