package com.example.flatservice.service.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class BuildingServiceClient {
    private final static String URL = "http://localhost:47074/building/api/v1/corps/get-addres";
    public static String getAddressByCorpId(Long corpId) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL + "/" + corpId);
        ResponseEntity<String> response = restTemplate.getForEntity(builder.toUriString(), String.class);
        return response.getBody();
    }
}
