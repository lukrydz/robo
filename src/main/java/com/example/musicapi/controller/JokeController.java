package com.example.musicapi.controller;

import com.example.musicapi.model.DadJoke;
import com.example.musicapi.service.DadJokeFetcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/joke")
public class JokeController {

    private DadJokeFetcher jokeFetcher;

    public JokeController(DadJokeFetcher jokeFetcher) {
        this.jokeFetcher = jokeFetcher;
    }

    @GetMapping
    public DadJoke getJoke() {
        return jokeFetcher.getJoke();
    }
}
