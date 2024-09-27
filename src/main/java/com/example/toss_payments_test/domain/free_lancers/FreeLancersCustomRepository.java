package com.example.toss_payments_test.domain.free_lancers;

import com.example.toss_payments_test.domain.free_lancers.response.FreeLancersListResponse;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface FreeLancersCustomRepository {

    List<FreeLancersListResponse> findMany(Integer page, Integer size, Sort sort);


}
