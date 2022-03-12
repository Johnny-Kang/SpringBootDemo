package com.duing.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "vegetables")
@PropertySource("classpath:vegetables.properties")
@Data
public class VegetablesConfig {
    private String tomato;
    private String eggplant;
    private String greenpepper;
}
