package com.angelo.voteapicloud.voteApi.core.adapter;

import com.angelo.voteapicloud.voteApi.core.domain.dto.rest.ScheduleVoteCore;
import com.angelo.voteapicloud.voteApi.core.port.ScheduleVoteControllerPort;

public class ScheduleVoteControllerAdapter implements ScheduleVoteControllerPort {


    @Override
    public boolean registerSchedule(ScheduleVoteCore scheduleVoteCore) throws Exception {
        return false;
    }
}
