package com.angelo.voteapicloud.voteApi.entrypoint.rest.controller;

import com.angelo.voteapicloud.voteApi.commons.mappers.VoteSessionDTOtoEntity;
import com.angelo.voteapicloud.voteApi.core.adapter.VoteSessionControllerAdapter;
import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.VoteSessionDTO;
import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteSessionEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/votesession")
public class VoteSessionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VoteSessionController.class);

    @Autowired
    VoteSessionControllerAdapter sessionControllerAdapter;


    @PostMapping
    public ResponseEntity openSessionVotes(@Valid @RequestBody VoteSessionDTO votingSession) throws Exception {
            LOGGER.info("VoteSessionController - open session votes - init flow - API REQUEST");
        try{
            sessionControllerAdapter.registerVoteSession(votingSession);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            throw e;
        }
    }

    @PatchMapping
    public ResponseEntity<VoteSessionEntity> finishSessionVotes(@RequestParam() Long id) throws Exception{
        try {
            LOGGER.info("VoteSessionController - finish session votes - init flow - API REQUEST");
            return ResponseEntity.status(HttpStatus.CREATED).body(sessionControllerAdapter.finishSessionVotes(id));
        }catch (Exception e){
            throw e;
        }
    }


}
