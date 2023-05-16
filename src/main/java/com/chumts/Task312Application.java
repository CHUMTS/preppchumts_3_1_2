package com.chumts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.chumts.task.model")
@SpringBootApplication
public class Task312Application {

    public static void main(String[] args) {
        SpringApplication.run(Task312Application.class, args);
    }

}
