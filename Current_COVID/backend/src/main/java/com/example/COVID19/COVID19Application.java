package com.example.COVID19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class COVID19Application {
    public static void main(String[] args) {
        SpringApplication.run(COVID19Application.class, args);
    }

}



