package com.angelo.voteapicloud.voteApi.entrypoint.rest.controller;

import com.angelo.voteapicloud.voteApi.core.adapter.ScheduleVoteControllerAdapter;
import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.ScheduleVoteDTO;
import com.angelo.voteapicloud.voteApi.infra.database.entity.ScheduleVoteEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleVoteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleVoteController.class);

    @Autowired
    ScheduleVoteControllerAdapter scheduleVoteControllerAdapter;



    @PostMapping
    public ResponseEntity registerSchedule(@Valid @RequestBody ScheduleVoteDTO scheduleVote) throws Exception{
        try {
            LOGGER.info("ScheduleVoteController - registerSchedule - init flow");
            scheduleVoteControllerAdapter.registerSchedule(scheduleVote);
           return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            throw e;
        }
    }

    @GetMapping
    public ResponseEntity<List<ScheduleVoteEntity>> findAllSchedulesVotes() throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scheduleVoteControllerAdapter.findAllScheduleVotes());
        }catch (Exception e){
            throw e;
        }
    }

}
