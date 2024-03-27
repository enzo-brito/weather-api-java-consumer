package com.app.weather.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WeatherConfig {

    // Configuração para criar uma instância de RestTemplate
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}