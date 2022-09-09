package com.angelo.voteapicloud.voteApi.infra.client;

import com.angelo.voteapicloud.voteApi.infra.client.model.DocumentOk;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DocumentVerifyClient {

    static String webService = "https://user-info.herokuapp.com/users/";
    static int codigoSucesso = 200;

    public DocumentOk checkIfIsAValidDocument(String cpf) throws Exception {
        String urlParaChamada = webService + cpf;

        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(urlParaChamada, DocumentOk.class);
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }

}
