package com.enjo_eat_spring.enjo_eat_spring.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorEnum {
    USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다."),
    INVALID_ID_PERMISSION(HttpStatus.UNAUTHORIZED, "권한이 없습니다."),
    DUPLICATED_DATA(HttpStatus.CONFLICT, "중복되는 데이터 입니다."),
    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "DB 에러..");

    private HttpStatus status;
    private String message;
}
