package com.angelo.voteapicloud.voteApi.infra.database.repository;

import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity,Long> {

    VoteEntity findByIdScheduleVoteAndIdVoteSession(Long idScheduleVote, Long idVoteSession);
    List<VoteEntity> findAllByIdScheduleVote(Long idScheduleVote);

}
