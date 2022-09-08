package com.angelo.voteapicloud.voteApi.infra.database.repository;

import com.angelo.voteapicloud.voteApi.infra.database.entity.ScheduleVoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ScheduleVoteRepository extends JpaRepository<ScheduleVoteEntity, Long> {

    Optional<ScheduleVoteEntity> findById(Long uuid);

    List<ScheduleVoteEntity> findAll();

}
