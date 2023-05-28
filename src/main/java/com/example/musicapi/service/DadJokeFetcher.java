package com.example.musicapi.service;


import com.example.musicapi.model.DadJoke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class DadJokeFetcher {

    private final String API_URL = "https://icanhazdadjoke.com/";

    @Autowired
    private RestTemplate restTemplate;

    public DadJoke getJoke() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity entity = new HttpEntity<>(null, headers);

        return restTemplate.exchange(API_URL, HttpMethod.GET, entity, DadJoke.class).getBody();

    }
}
