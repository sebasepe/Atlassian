package com.atlassian.platform.pc24363u202220783;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Pc24363u202220783Application {

    public static void main(String[] args) {
        SpringApplication.run(Pc24363u202220783Application.class, args);
    }

}
