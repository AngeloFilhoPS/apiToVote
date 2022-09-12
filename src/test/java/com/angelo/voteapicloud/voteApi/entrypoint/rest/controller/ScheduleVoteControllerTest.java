package com.angelo.voteapicloud.voteApi.entrypoint.rest.controller;

import com.angelo.voteapicloud.voteApi.core.adapter.ScheduleVoteControllerAdapter;
import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.ScheduleVoteDTO;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class ScheduleVoteControllerTest {

    @MockBean
    private ScheduleVoteControllerAdapter adapter;

    @InjectMocks
    private ScheduleVoteController controller;

    @BeforeEach
    public void setUP(){
        MockitoAnnotations.initMocks(this);
        standaloneSetup(this.controller);
    }

    @Test
    public void shouldRegisterScheduleVote() throws Exception{
        ScheduleVoteDTO scheduleVoteDTO = ScheduleVoteDTO.builder()
                .scheduleName("test")
                .scheduleDescription("test")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(scheduleVoteDTO)
                .when()
                .post("schedule")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void shouldReturnBadRequest(){
        ScheduleVoteDTO scheduleVoteDTO = ScheduleVoteDTO.builder().build();

        given()
                .contentType(ContentType.JSON)
                .body(scheduleVoteDTO)
                .when()
                .post("/schedule")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void shouldReturnSuccessFindAllSchedule() throws Exception{
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/schedule")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

}