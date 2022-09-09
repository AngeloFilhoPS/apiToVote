package com.angelo.voteapicloud.voteApi.entrypoint.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VoteDTO {

    @NotNull(message = "idPauta cannot be null")
    private Long idScheduleVote;

    @NotNull(message = "idSession cannot be null")
    private Long idVoteSession;

    @NotBlank(message = "vote cannot be null")
    private String vote;

    @NotBlank(message = "CPF cannot be null")
    private String cpf;
}
