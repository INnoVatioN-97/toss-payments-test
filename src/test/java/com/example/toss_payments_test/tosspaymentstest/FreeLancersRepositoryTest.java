package com.example.toss_payments_test.tosspaymentstest;

import com.example.toss_payments_test.domain.free_lancers.FreeLancers;
import com.example.toss_payments_test.domain.free_lancers.FreeLancersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FreeLancersRepositoryTest {

    @Autowired
    private FreeLancersRepository freeLancersRepository;

    @Test
    public void saveTest() {
        FreeLancers entity = FreeLancers.builder()
                .name("테스트1")
                .email("test@gmail.com")
                .build();

        FreeLancers saved = freeLancersRepository.save(entity);

        Assertions.assertEquals("테스트1", saved.getName());
        Assertions.assertEquals("test@gmail.com", saved.getEmail());

        System.out.println(saved);
    }
}
