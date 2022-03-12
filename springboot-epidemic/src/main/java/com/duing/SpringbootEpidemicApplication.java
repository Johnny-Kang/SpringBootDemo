package com.duing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@MapperScan("com.duing.mapper")
@EnableScheduling
public class SpringbootEpidemicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEpidemicApplication.class, args);
    }

}
