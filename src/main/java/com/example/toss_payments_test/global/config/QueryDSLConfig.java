package com.example.toss_payments_test.global.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryDSLConfig {

    @Bean
    JPAQueryFactory jpaQueryFactory(EntityManager manager) {
        return new JPAQueryFactory(manager);
    }


}
