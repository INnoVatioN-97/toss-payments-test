package com.example.toss_payments_test.domain.free_lancers;

import com.example.toss_payments_test.domain.free_lancers.response.FreeLancersListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/free-lancers")
public class FreeLancersController {
    private final FreeLancersService service;


    @GetMapping()
    List<FreeLancersListResponse> findMany(Pageable pageable) {

        return service.findMany(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
    }

    @GetMapping("/{id}")
    FreeLancers findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }
}
