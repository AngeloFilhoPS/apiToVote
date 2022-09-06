package com.angelo.voteapicloud.voteApi.entrypoint.rest.controller;

import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.ScheduleVoteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/schedule")
public class ScheduleVoteController {

    @PostMapping
    public ResponseEntity registerSchedule(@Valid @RequestBody ScheduleVoteDTO scheduleVote) throws Exception{
        try {
            System.out.println( scheduleVote.toString());
           return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            System.out.println("DEU RUIM");
            throw e;
        }
    }

}
