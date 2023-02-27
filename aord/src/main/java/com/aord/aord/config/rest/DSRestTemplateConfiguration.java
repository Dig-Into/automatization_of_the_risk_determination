package com.aord.aord.config.rest;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DSRestTemplateConfiguration {
    @Bean(name = "DataServiceRT")
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        HttpComponentsClientHttpRequestFactory requestFactory = null;

        HttpClient httpClient = HttpClients.custom()
                .setMaxConnTotal(5)
                .setMaxConnPerRoute(5)
                .build();

        requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(10000);

        restTemplate.setRequestFactory(requestFactory);

        return restTemplate;
    }

}