package com.angelo.voteapicloud.voteApi.infra.database.adapter;

import com.angelo.voteapicloud.voteApi.infra.database.entity.ScheduleVoteEntity;
import com.angelo.voteapicloud.voteApi.infra.database.port.ScheduleVoteRepositoryPort;
import com.angelo.voteapicloud.voteApi.infra.database.repository.ScheduleVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleVoteAdapter implements ScheduleVoteRepositoryPort {

    @Autowired
    private ScheduleVoteRepository scheduleVoteRepository;

    @Override
    public ScheduleVoteEntity registerScheduleVoteEntity(ScheduleVoteEntity scheduleVoteEntity) throws Exception {
        return scheduleVoteRepository.save(scheduleVoteEntity);
    }

    @Override
    public List<ScheduleVoteEntity> findAllScheduleVote() throws Exception{
        if(scheduleVoteRepository.findAll().size()==0) {
            throw new Exception("Não foram encontradas pautas");
        } return findAllScheduleVote();


    }
}
