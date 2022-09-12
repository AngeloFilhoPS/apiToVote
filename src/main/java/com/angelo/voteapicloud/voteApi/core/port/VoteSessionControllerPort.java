package com.angelo.voteapicloud.voteApi.core.port;

import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.VoteSessionDTO;
import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteSessionEntity;

public interface VoteSessionControllerPort {

    VoteSessionEntity registerVoteSession(VoteSessionDTO voteSessionEntity) throws Exception;

    VoteSessionEntity finishSessionVotes(Long id) throws Exception;
}
