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
import java.util.Objects;

@Service
public class VoteAdapter implements VoteRepositoryPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(VoteAdapter.class);

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private ScheduleVoteAdapter scheduleVoteAdapter;



    @Override
    public VoteEntity sendVote(VoteEntity voteEntity) throws Exception {
        //TODO ERRO NA DEPENDENCIA DE PARSE, VERIFICAR JACKSON
        verifyCpf(voteEntity.getCpf());
        LOGGER.info("VoteAdapter - sendVote - verify if exist ScheduleVote");
        scheduleVoteAdapter.existScheduleVote(voteEntity.getIdScheduleVote());
        LOGGER.info("VoteAdapter - sendVote - verify complete");
        isDuplicateVote(voteEntity);
        LOGGER.info("VoteAdapter - sendVote - verify duplicate vote");
        return voteRepository.save(voteEntity);
    }

    boolean isDuplicateVote(VoteEntity voteEntity){
        if(voteRepository.findByIdScheduleVoteAndIdVoteSession(
                voteEntity.getIdScheduleVote(),voteEntity.getIdVoteSession()) != null){
            throw new DuplicateKeyException("Voto já computado");
        }else return true;
    }

    private void verifyCpf(String cpf) throws Exception {
        DocumentVerifyClient verifyClient = new DocumentVerifyClient();
        if (Objects.equals(verifyClient.checkIfIsAValidDocument(cpf).getStatus(), "UNABLE_TO_VOTE"))
            throw new Exception("Este CPF não está válido para a votação");
    }

    @Override
    public List<VoteEntity> findAllVoteEntityByIdVoteSession(Long id) throws Exception {
        return voteRepository.findAllByIdScheduleVote(id);
    }
}
