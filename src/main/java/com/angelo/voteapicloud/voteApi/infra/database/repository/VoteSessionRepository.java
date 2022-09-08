package com.angelo.voteapicloud.voteApi.infra.database.repository;

import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteSessionRepository extends JpaRepository<VoteSessionEntity,Long> {

    VoteSessionEntity findByIdAndSessionOpen(Long id, boolean sessionOpen);

}
