package com.angelo.voteapicloud.voteApi.core.port;

import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteEntity;
import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteSessionEntity;

public interface VoteControllerPort {
    VoteEntity sendVote(VoteEntity voteEntity) throws Exception;
}
