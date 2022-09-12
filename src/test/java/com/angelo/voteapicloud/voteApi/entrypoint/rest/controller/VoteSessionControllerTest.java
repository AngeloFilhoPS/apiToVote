package com.angelo.voteapicloud.voteApi.entrypoint.rest.controller;

import com.angelo.voteapicloud.voteApi.core.adapter.VoteSessionControllerAdapter;
import com.angelo.voteapicloud.voteApi.entrypoint.rest.dto.VoteSessionDTO;
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
class VoteSessionControllerTest {

    @MockBean
    private VoteSessionControllerAdapter adapter;

    @InjectMocks
    private VoteSessionController controller;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        standaloneSetup(this.controller);
    }

    @Test
    public void shouldReturnSuccessInInsertVoteSession() throws Exception{
        VoteSessionDTO voteSessionDTO = VoteSessionDTO.builder()
                .idScheduleVote(1L)
                .minDurationSession(60)
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(voteSessionDTO)
                .when()
                .post("votesession")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void shouldReturnNotFoundInInsertVoteSessionNoExist(){
        VoteSessionDTO voteSessionDTO = VoteSessionDTO.builder()
                .idScheduleVote(null)
                .minDurationSession(null)
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(voteSessionDTO)
                .when()
                .post("/votession")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void shouldReturnSuccessEndsVoteSession() throws Exception{
        VoteSessionDTO voteSessionDTO = VoteSessionDTO.builder()
                .idScheduleVote(1L)
                .build();

        given().param("id",1)
                .when()
                .patch("/votesession")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void shouldReturnErrorInEndsVoteSession() throws Exception{
        VoteSessionDTO voteSessionDTO = VoteSessionDTO.builder()
                .idScheduleVote(1L)
                .build();

        given()
                .when()
                .patch("/votession")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());

    }

}