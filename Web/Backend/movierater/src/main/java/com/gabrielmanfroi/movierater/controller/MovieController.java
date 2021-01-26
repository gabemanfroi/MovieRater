package com.gabrielmanfroi.movierater.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
@RequestMapping("/api/movies")
@RestController
public class MovieController {

    private final RestTemplate restTemplate;

    private final String key = "api_key=c8c657e0ef32df94781f02aa086b611f";

    public MovieController(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/trending")
    public String getMoviesPlainJSON(){
        String url = "https://api.themoviedb.org/3/trending/all/day?"+key;
        return this.restTemplate.getForObject(url, String.class);
    }

}
