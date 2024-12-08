package com.javaacademy.wedding_host;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class WeddingHostApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeddingHostApplication.class, args);
    }

}
