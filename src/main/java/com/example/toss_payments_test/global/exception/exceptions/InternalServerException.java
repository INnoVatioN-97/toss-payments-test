package com.example.toss_payments_test.global.exception.exceptions;


import com.example.toss_payments_test.global.exception.error.ErrorCode;
import com.example.toss_payments_test.global.exception.error.GlobalException;

public class InternalServerException extends GlobalException {
    public InternalServerException(String details) {
        super(ErrorCode.INTERNAL_SERVER_ERROR, details);
    }
}
