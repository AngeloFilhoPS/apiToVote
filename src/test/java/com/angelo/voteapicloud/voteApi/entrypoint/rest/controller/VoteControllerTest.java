package com.angelo.voteapicloud.voteApi.entrypoint.rest.controller;

import com.angelo.voteapicloud.voteApi.core.adapter.VoteControllerAdapter;
import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.VoteDTO;
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
class VoteControllerTest {

    @MockBean
    private VoteControllerAdapter adapter;

    @InjectMocks
    private VoteController controller;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        standaloneSetup(this.controller);
    }

    @Test
    public void shouldReturnSuccessInInsertVote()throws Exception{
        VoteDTO voteDTO = VoteDTO.builder()
                .idScheduleVote(1L)
                .cpf("023155262630")
                .idVoteSession(1L)
                .vote("SIM")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(voteDTO)
                .when()
                .post("/vote")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void shouldReturnErrorRequestInInsertVote(){
        VoteDTO voteDTO = VoteDTO.builder()
                .idVoteSession(1L)
                .idVoteSession(1L)
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(voteDTO)
                .when()
                .post("/vote")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());

    }

}