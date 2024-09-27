package com.example.toss_payments_test.global.exception.error;

import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String details;

    public GlobalException(ErrorCode errorCode, String details) {
        this.errorCode = errorCode;
        this.details = details;
    }
}
