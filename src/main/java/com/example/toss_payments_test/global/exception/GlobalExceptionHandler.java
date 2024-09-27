package com.example.toss_payments_test.global.exception;

import com.example.toss_payments_test.global.exception.error.ErrorCode;
import com.example.toss_payments_test.global.exception.error.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> handlePapyrusException(GlobalException e) {
        log.error(e.getMessage(), e.getDetails(), e);

        final ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(
                new ErrorResponse(
                        errorCode.getCode(),
                        errorCode.getMessage(),
                        e.getDetails(),
                        LocalDateTime.now().toString()
                ),
                HttpStatus.valueOf(errorCode.getCode())
        );
    }
}
