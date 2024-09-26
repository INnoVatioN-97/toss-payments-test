package com.example.toss_payments_test.domain.free_lancers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller("/free-lancers")
@RequiredArgsConstructor
public class FreeLancersController {
    private final FreeLancersService service;

}
