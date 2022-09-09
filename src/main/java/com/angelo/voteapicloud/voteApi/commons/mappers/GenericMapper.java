package com.angelo.voteapicloud.voteApi.commons.mappers;

public interface GenericMapper<E extends BaseEntity, D> {

    E convertToEntity(D dto);
}