package com.angelo.voteapicloud.voteApi.core.port;


import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.ScheduleVoteDTO;
import com.angelo.voteapicloud.voteApi.infra.database.entity.ScheduleVoteEntity;

import java.util.List;

public interface ScheduleVoteControllerPort {

    void registerSchedule(ScheduleVoteDTO scheduleVoteDTO) throws Exception;
    List<ScheduleVoteEntity> findAllScheduleVotes() throws Exception;

}
