package com.angelo.voteapicloud.voteApi.infra.client.model;
import lombok.Builder;
import lombok.Data;
import java.io.Serializable;

@Data
@Builder
public class DocumentOk implements Serializable{


    private String status;

    public DocumentOk(){
    };
    public DocumentOk(String status){
        this.status = status;
    }
}

