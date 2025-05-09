package com.pe.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FirstCommitApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstCommitApplication.class, args);
    }

}
