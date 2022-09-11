package com.angelo.voteapicloud.voteApi.infra.database.repository;

import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureMockMvc
class VoteRepositoryTest {

    @Autowired
    protected VoteRepository repository;

    @Autowired
    protected TestEntityManager entityManager;

    @Test
    void  findByIdScheduleVoteAndIdVoteSession(){

        VoteEntity voteSave = entityManager.persist(
                VoteEntity.builder()
                        .idVoteSession(1L)
                        .idScheduleVote(1L)
                        .dtVote(new Date())
                        .cpf("02315527261")
                        .vote("SIM")
                        .build()
        );

        VoteEntity voteResponse = repository.findByIdScheduleVoteAndIdVoteSession(1L,1L);

        Assertions.assertEquals(voteSave,voteResponse);

        Assertions.assertEquals(voteSave.getId(), voteResponse.getId());
        Assertions.assertEquals(voteSave.getDtVote(), voteResponse.getDtVote());
        Assertions.assertEquals(voteSave.getCpf(),voteResponse.getCpf());
        Assertions.assertEquals(voteSave.getIdScheduleVote(), voteResponse.getIdScheduleVote());
        Assertions.assertEquals(voteSave.getVote(), voteResponse.getVote());
        Assertions.assertEquals(voteSave.getIdVoteSession(),voteResponse.getIdVoteSession());
    }

}