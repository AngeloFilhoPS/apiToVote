package com.angelo.voteapicloud.voteApi.infra.database.repository;

import com.angelo.voteapicloud.voteApi.infra.database.entity.ScheduleVoteEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureMockMvc
class ScheduleVoteRepositoryTest {

    @Autowired
    private ScheduleVoteRepository repository;


    @Autowired
    protected TestEntityManager entityManager;

    @Test
    void findById(){
        ScheduleVoteEntity scheduleVoteEntitySave = entityManager.persist(ScheduleVoteEntity.builder()
                .scheduleName("title")
                .scheduleDescription("descript")
                .build());

        Optional<ScheduleVoteEntity> scheduleVoteEntityResponse = repository.findById(1L);

        Assertions.assertEquals(scheduleVoteEntitySave,scheduleVoteEntityResponse.get());

        Assertions.assertEquals(scheduleVoteEntitySave.getScheduleName(), scheduleVoteEntityResponse.get().getScheduleName());

        Assertions.assertEquals(scheduleVoteEntitySave.getScheduleDescription(), scheduleVoteEntityResponse.get().getScheduleDescription());

    }
}