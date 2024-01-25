package com.enjo_eat_spring.enjo_eat_spring.data.dto;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.Eatery;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class EateryDTO {
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class ListResponseDTO{
        private Long id;
        private String eateryName;
        private String eateryType;
        private User user;
        private Long groupId;
    }

    public EateryDTO.ListResponseDTO toDto(Eatery eatery){
        return ListResponseDTO.builder()
                .id(eatery.getId())
                .eateryName(eatery.getEateryName())
                .user(eatery.getUser())
                .groupId(eatery.getGroup().getId())
                .build();
    }
}
