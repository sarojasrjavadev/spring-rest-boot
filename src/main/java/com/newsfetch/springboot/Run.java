package com.newsfetch.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring-security-config.xml")
public class Run {

    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }
}
