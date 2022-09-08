package com.angelo.voteapicloud.voteApi.core.port;


import com.angelo.voteapicloud.voteApi.core.domain.dto.rest.ScheduleVoteCore;
import com.angelo.voteapicloud.voteApi.infra.database.entity.ScheduleVoteEntity;

import java.util.List;

public interface ScheduleVoteControllerPort {

    void registerSchedule(ScheduleVoteCore scheduleVoteCore) throws Exception;
    List<ScheduleVoteEntity> findAllScheduleVotes() throws Exception;

}
