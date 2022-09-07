package com.angelo.voteapicloud.voteApi.core.port;


import com.angelo.voteapicloud.voteApi.core.domain.dto.rest.ScheduleVoteCore;

public interface ScheduleVoteControllerPort {

    void registerSchedule(ScheduleVoteCore scheduleVoteCore) throws Exception;

}
