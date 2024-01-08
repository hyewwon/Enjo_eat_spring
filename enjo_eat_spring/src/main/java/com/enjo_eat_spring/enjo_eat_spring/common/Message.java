package com.enjo_eat_spring.enjo_eat_spring.common;

import lombok.Getter;

@Getter
public class Message {
    private ResponseEnum status;
    private String message;
    private Object data;
}
