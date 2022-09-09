package com.angelo.voteapicloud.voteApi.entrypoint.rest.controller;

import com.angelo.voteapicloud.voteApi.commons.mappers.VoteDTOtoEntity;
import com.angelo.voteapicloud.voteApi.core.adapter.VoteControllerAdapter;
import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.VoteDTO;
import com.angelo.voteapicloud.voteApi.infra.database.entity.VoteEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/vote")
public class VoteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VoteController.class);

    @Autowired
    VoteControllerAdapter voteControllerAdapter;

    private final VoteDTOtoEntity voteDTOtoEntity = new VoteDTOtoEntity();

    @PostMapping
    public ResponseEntity<VoteEntity> sendVote(@Valid @RequestBody VoteDTO voteDTO) throws Exception{
        try {
            LOGGER.info("Vote Controller - sendVote - init flow");
            System.out.println(voteDTO.getCpf());
            return ResponseEntity.status(HttpStatus.CREATED).body(voteControllerAdapter.sendVote(voteDTOtoEntity.convertToEntity(voteDTO)));
        }catch (Exception e){
            throw e;
        }
    }


}
