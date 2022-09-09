package com.angelo.voteapicloud.voteApi.infra.database.adapter;

import com.angelo.voteapicloud.voteApi.infra.client.DocumentVerifyClient;
import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteEntity;
import com.angelo.voteapicloud.voteApi.infra.database.port.VoteRepositoryPort;
import com.angelo.voteapicloud.voteApi.infra.database.repository.VoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteAdapter implements VoteRepositoryPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(VoteAdapter.class);

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private ScheduleVoteAdapter scheduleVoteAdapter;

    @Autowired
    private DocumentVerifyClient documentVerifyClient;

    @Override
    public VoteEntity sendVote(VoteEntity voteEntity) throws Exception {
        documentVerifyClient.checkIfIsAValidDocument(voteEntity.getCpf());
        scheduleVoteAdapter.existScheduleVote(voteEntity.getIdScheduleVote());
        isDuplicateVote(voteEntity);
        return voteRepository.save(voteEntity);
    }

    boolean isDuplicateVote(VoteEntity voteEntity){
        if(voteRepository.findByIdScheduleVoteAndIdVoteSession(
                voteEntity.getIdScheduleVote(),voteEntity.getIdVoteSession()) != null){
            throw new DuplicateKeyException("Voto já computado");
        }else return true;
    }

    @Override
    public List<VoteEntity> findAllVoteEntityByIdVoteSession(Long id) throws Exception {
        return voteRepository.findAllByIdScheduleVote(id);
    }
}
