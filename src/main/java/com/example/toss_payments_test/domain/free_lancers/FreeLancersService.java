package com.example.toss_payments_test.domain.free_lancers;

import com.example.toss_payments_test.domain.free_lancers.response.FreeLancersListResponse;
import com.example.toss_payments_test.global.exception.exceptions.FreeLancerNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FreeLancersService {
    private final FreeLancersRepository repository;


    List<FreeLancersListResponse> findMany(Integer page, Integer size, Sort sort) {
        return repository.findMany(page, size, sort);
    }

    @SneakyThrows
    public FreeLancers findOne(Long id) {
        Optional<FreeLancers> data = repository.findById(id);

        FreeLancers found = data.orElseThrow(() -> new FreeLancerNotFoundException("error"));
        found.setSearchCount(found.getSearchCount() + 1);
        repository.save(found);

        return found;
    }


}
