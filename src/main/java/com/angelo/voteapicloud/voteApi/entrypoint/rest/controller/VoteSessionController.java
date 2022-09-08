package com.angelo.voteapicloud.voteApi.entrypoint.rest.controller;

import com.angelo.voteapicloud.voteApi.commons.exceptions.mappers.VoteSessionDTOtoEntity;
import com.angelo.voteapicloud.voteApi.core.adapter.VoteSessionControllerAdapter;
import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.VoteSessionDTO;
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

    private final VoteSessionDTOtoEntity voteSessionDTOtoEntity = new VoteSessionDTOtoEntity();

    @PostMapping
    public ResponseEntity openSessionVotes(@Valid @RequestBody VoteSessionDTO votingSession) throws Exception {
            LOGGER.info("VoteSessionController - open session votes - init flow");
        try{
            sessionControllerAdapter.registerVoteSession(voteSessionDTOtoEntity.convertToEntity(votingSession));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            throw e;
        }
    }

}
