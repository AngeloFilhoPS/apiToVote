package com.angelo.voteapicloud.voteApi.commons.exceptions.mappers;

import java.io.Serializable;

public interface BaseEntity<ID> extends Serializable {
    ID getId();
    void setId(ID id);
}