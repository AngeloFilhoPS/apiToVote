package com.angelo.voteapicloud.voteApi.commons.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequestError {

    private int code;

    private String errorMessage;

    private List<String> errorList;
}