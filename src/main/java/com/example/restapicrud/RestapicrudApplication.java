package com.example.restapicrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RestapicrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapicrudApplication.class, args);
    }

}
