package com.angelo.voteapicloud.voteApi.infra.database.port;

import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteEntity;

import java.util.List;

public interface VoteRepositoryPort {

    VoteEntity sendVote(VoteEntity voteEntity) throws Exception;
    List<VoteEntity> findAllVoteEntityByIdVoteSession(Long id) throws Exception;

}
