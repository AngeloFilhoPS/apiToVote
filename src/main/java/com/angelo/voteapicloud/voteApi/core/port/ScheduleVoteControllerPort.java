package com.angelo.voteapicloud.voteApi.core.port;


import com.angelo.voteapicloud.voteApi.core.domain.dto.rest.ScheduleVoteCore;

public interface ScheduleVoteControllerPort {

    boolean registerSchedule(ScheduleVoteCore scheduleVoteCore) throws Exception;

}
