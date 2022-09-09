package com.angelo.voteapicloud.voteApi.infra.database.entity;

import com.angelo.voteapicloud.voteApi.commons.mappers.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VoteEntity implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "idScheduleVote cannot be null")
    private Long idScheduleVote;

    @NotNull(message = "idVoteSession cannot be null")
    private Long idVoteSession;

    @NotBlank(message = "vote cannot be null")
    private String vote;

    @NotBlank(message = "CPF cannot be null")
    private String cpf;

    private Date dtVote;

}
