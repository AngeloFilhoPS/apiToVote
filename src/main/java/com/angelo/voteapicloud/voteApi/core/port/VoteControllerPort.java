package com.angelo.voteapicloud.voteApi.core.port;

import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.VoteDTO;
import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteEntity;

public interface VoteControllerPort {
    VoteEntity sendVote(VoteDTO voteEntity) throws Exception;
}
