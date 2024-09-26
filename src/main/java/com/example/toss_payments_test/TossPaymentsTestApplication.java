package com.example.toss_payments_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TossPaymentsTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TossPaymentsTestApplication.class, args);
    }

}
