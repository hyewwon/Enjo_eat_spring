package com.enjo_eat_spring.enjo_eat_spring.common.authorization;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    UserRole(String value){
        this.value = value;
    }

    private String value;
}
