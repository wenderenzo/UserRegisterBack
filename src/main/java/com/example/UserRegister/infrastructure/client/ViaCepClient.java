package com.example.UserRegister.infrastructure.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ViaCepClient {

    private final RestTemplate restTemplate;

    public ViaCepClient() {
        this.restTemplate = new RestTemplate();
    }

    public String getAddress(String zipCode) {
        String url = "https://viacep.com.br/ws/" + zipCode + "/json/";
        return restTemplate.getForObject(url, String.class);
    }
}
