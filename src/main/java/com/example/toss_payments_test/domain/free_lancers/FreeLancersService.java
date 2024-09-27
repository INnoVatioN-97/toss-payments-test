package com.example.toss_payments_test.domain.free_lancers;

import com.example.toss_payments_test.domain.free_lancers.response.FreeLancersListResponse;
import com.example.toss_payments_test.global.exception.exceptions.FreeLancerNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FreeLancersService {
    private final FreeLancersRepository repository;


    List<FreeLancersListResponse> findMany(Integer page, Integer size, String sortBy) {
        Sort sort = Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(page - 1, size, sort);

        Page<FreeLancers> results = repository.findAll(pageRequest);

        return results.stream().map(each -> FreeLancersListResponse.builder()
                .name(each.getName())
                .searchCount(each.getSearchCount())
                .createdAt(each.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                .build()).toList();
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
