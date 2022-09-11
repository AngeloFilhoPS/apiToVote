package com.angelo.voteapicloud.voteApi.infra.client;

import com.angelo.voteapicloud.voteApi.infra.client.model.DocumentOk;
import org.springframework.web.client.RestTemplate;

public class DocumentVerifyClient {

    static String webService = "https://user-info.herokuapp.com/users/";
    static int successCode = 200;

    public DocumentOk checkIfIsAValidDocument(String cpf) throws Exception {
        String url = webService + cpf;

        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(url, DocumentOk.class);
        } catch (Exception e) {
            throw new Exception("ERRO: CPF INVALIDO/NAO REGISTRADO " + e);
        }
    }

}
