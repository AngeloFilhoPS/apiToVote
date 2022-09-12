package com.angelo.voteapicloud.voteApi.infra.database.repository;

import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteSessionEntity;
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
class VoteSessionRepositoryTest {

    @Autowired
    private VoteSessionRepository repository;

    @Autowired
    protected TestEntityManager entityManager;


    @Test
    void findByIdAndSessionOpen(){
        VoteSessionEntity voteSessionSave = entityManager.persist(
                VoteSessionEntity.builder()
                        .idScheduleVote(1L)
                        .sessionOpen(true)
                        .votesYes(0)
                        .votesNo(0)
                        .dtOpenSession(new Date())
                        .minDurationSession(5)
                        .build());

        VoteSessionEntity voteSessioResponse = repository.findByIdAndSessionOpen(1L,true);

        Assertions.assertEquals(voteSessionSave,voteSessioResponse);

        Assertions.assertEquals(voteSessionSave.isSessionOpen(),voteSessioResponse.isSessionOpen());
        Assertions.assertEquals(voteSessionSave.getIdScheduleVote(),voteSessioResponse.getIdScheduleVote());
        Assertions.assertEquals(voteSessionSave.getVotesYes(), voteSessioResponse.getVotesYes());
        Assertions.assertEquals(voteSessionSave.getVotesNo(),voteSessioResponse.getVotesNo());
        Assertions.assertEquals(voteSessionSave.getDtOpenSession(),voteSessioResponse.getDtOpenSession());
        Assertions.assertEquals(voteSessionSave.getMinDurationSession(),voteSessioResponse.getMinDurationSession());
    }
}