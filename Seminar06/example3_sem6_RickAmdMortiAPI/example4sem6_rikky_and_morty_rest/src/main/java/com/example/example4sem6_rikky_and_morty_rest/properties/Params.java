package com.example.example4sem6_rikky_and_morty_rest.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "param")
@Data
public class Params {
    private String CHARACTER_API;
}
