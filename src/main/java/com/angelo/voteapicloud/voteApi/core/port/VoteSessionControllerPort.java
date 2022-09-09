package com.angelo.voteapicloud.voteApi.core.port;

import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteSessionEntity;

public interface VoteSessionControllerPort {

    VoteSessionEntity registerVoteSession(VoteSessionEntity voteSessionEntity) throws Exception;
    VoteSessionEntity finishSessionVotes(Long id) throws Exception;
}
