package com.izeno.snowflakedemo.service;

import com.izeno.snowflakedemo.model.UserDataRs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class TalendService {

    @Autowired
    RestTemplate restTemplate;

    public String getData() throws Exception {

        try {
            String url = "http://localhost:8065/services/sapura/api/v1/sync";
            ResponseEntity<String> response;
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

            response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);

            return response.getBody();

        }catch (Exception e){
            e.printStackTrace();
            log.error("ERROR SYNC DATA : {}", e.getMessage());
            throw new Exception(e);
        }
    }
}
