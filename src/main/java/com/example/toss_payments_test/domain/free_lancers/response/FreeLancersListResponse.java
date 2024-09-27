package com.example.toss_payments_test.domain.free_lancers.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FreeLancersListResponse {
    private String name;

    private Long searchCount;

    private String createdAt;
}
