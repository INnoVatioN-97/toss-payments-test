package com.example.toss_payments_test.global.exception.exceptions;


import com.example.toss_payments_test.global.exception.error.ErrorCode;
import com.example.toss_payments_test.global.exception.error.GlobalException;

public class FreeLancerNotFoundException extends GlobalException {
    public FreeLancerNotFoundException(String details) {
        super(ErrorCode.FREE_LANCER_NOT_FOUND, details);
    }
}
