package com.enjo_eat_spring.enjo_eat_spring.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Optional;
import java.util.function.Predicate;

@Getter
@RequiredArgsConstructor
public enum ResponseEnum {
    OK(200, HttpStatus.OK, "OK"),
    BAD_REQUEST(400, HttpStatus.BAD_REQUEST, "BAD_REQUEST"),
    NOT_FOUND(404, HttpStatus.NOT_FOUND, "NOT_FOUND"),
    INTERNAL_SERER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR");

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;

    public String getMessage(Throwable e){
        return this.getMessage(this.getMessage() + "-" + e.getMessage());
    }

    public String getMessage(String message){
        //  NullPointerException 방지 (Null 검사) - null이 올 수 있는 값을 감싸는 Wrapper 클래스
        return Optional.ofNullable(message)
                .filter(Predicate.not(String::isBlank))
                .orElse(this.getMessage());
    }

}
