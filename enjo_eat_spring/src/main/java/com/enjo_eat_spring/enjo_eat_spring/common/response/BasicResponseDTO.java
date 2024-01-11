package com.enjo_eat_spring.enjo_eat_spring.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BasicResponseDTO<T> {
    private final Boolean success;
    private final Integer code;
    private final String message;
    private final T data;

    public static <T> BasicResponseDTO<T> getSuccessMessage(Boolean success, ResponseEnum code){
        return new BasicResponseDTO<>(success, code.getCode(), code.getMessage(), null);
    }

    public static <T> BasicResponseDTO<T> getFailMessage(Boolean success, ResponseEnum errorCode){
        return new BasicResponseDTO<>(success, errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> BasicResponseDTO<T> getErrorMessage(Boolean success, ResponseEnum errorCode, String message){
        return new BasicResponseDTO<>(success, errorCode.getCode(), errorCode.getMessage(message), null);
    }

    public static <T> BasicResponseDTO<T> getSuccessData(Boolean success, ResponseEnum code, String message, T data){
        return new BasicResponseDTO<>(success, code.getCode(), code.getMessage(), data);
    }


}
