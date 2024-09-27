package com.example.toss_payments_test.domain.free_lancers;

import com.example.toss_payments_test.domain.free_lancers.response.FreeLancersListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/free-lancers")
public class FreeLancersController {
    private final FreeLancersService service;


    @GetMapping()
    List<FreeLancersListResponse> findMany(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            @RequestParam("sortBy") String sortBy
    ) {

        return service.findMany(page, size, sortBy);
    }

    @GetMapping("/{id}")
    FreeLancers findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }
}
