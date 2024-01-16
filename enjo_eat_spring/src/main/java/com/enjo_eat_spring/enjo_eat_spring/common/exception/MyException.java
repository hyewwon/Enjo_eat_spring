package com.enjo_eat_spring.enjo_eat_spring.common.exception;

import lombok.Getter;

@Getter
public class MyException extends RuntimeException{
    private String result;
    private ErrorEnum errorCode;
    private String message;

    public MyException(ErrorEnum errorCode){
        this.result = "ERROR";
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}
