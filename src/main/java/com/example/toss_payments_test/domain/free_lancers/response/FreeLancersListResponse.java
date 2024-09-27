package com.example.toss_payments_test.domain.free_lancers.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FreeLancersListResponse {
    private String name;

    private Long searchCount;

    private String createdAt;


}
