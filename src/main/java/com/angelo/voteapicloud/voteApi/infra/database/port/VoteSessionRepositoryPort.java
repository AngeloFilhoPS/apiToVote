package com.angelo.voteapicloud.voteApi.infra.database.port;

import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteSessionEntity;

public interface VoteSessionRepositoryPort {

    VoteSessionEntity registerVoteSessionEntity(VoteSessionEntity voteSessionEntity) throws Exception;

}
