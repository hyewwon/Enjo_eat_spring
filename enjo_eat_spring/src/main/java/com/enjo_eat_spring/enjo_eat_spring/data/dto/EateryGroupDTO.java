package com.enjo_eat_spring.enjo_eat_spring.data.dto;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class EateryGroupDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class CreateRequestDTO{
        private String groupName;
        private String groupComment;
        private String groupLocation;

        public EateryGroup toEntity(){
            return EateryGroup.builder()
                    .groupName(groupName)
                    .groupComment(groupComment)
                    .groupLocation(groupLocation)
                    .build();
        }
    }

}
