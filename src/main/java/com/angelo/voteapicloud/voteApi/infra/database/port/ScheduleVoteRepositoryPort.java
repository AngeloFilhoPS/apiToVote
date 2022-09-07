package com.angelo.voteapicloud.voteApi.infra.database.port;

import com.angelo.voteapicloud.voteApi.infra.database.entity.ScheduleVoteEntity;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import java.util.List;


public interface ScheduleVoteRepositoryPort  {

    ScheduleVoteEntity registerScheduleVoteEntity(ScheduleVoteEntity scheduleVoteEntity) throws Exception;
    List<ScheduleVoteEntity> findAllScheduleVote() throws Exception;

}
