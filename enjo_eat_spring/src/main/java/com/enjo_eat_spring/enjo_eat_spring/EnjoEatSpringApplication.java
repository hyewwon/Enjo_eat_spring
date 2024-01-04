package com.enjo_eat_spring.enjo_eat_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class EnjoEatSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnjoEatSpringApplication.class, args);
    }

}
