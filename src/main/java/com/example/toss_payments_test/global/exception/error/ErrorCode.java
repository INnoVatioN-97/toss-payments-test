package com.example.toss_payments_test.global.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    FREE_LANCER_NOT_FOUND("프리랜서를 찾을 수 없습니다.", 404),
    INTERNAL_SERVER_ERROR("서버 에러입니다.", 500);

    private String message;
    private int code;
}
