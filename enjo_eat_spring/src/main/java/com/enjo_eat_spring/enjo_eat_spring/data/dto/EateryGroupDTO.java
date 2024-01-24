package com.enjo_eat_spring.enjo_eat_spring.data.dto;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import lombok.*;

public class EateryGroupDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class CreateRequestDTO{
        private String groupName;
        private String groupComment;
        private String groupLocation;
        private User user;

        public void setUser(User user) {
            this.user = user;
        }

        public EateryGroup toEntity(){
            return EateryGroup.builder()
                    .groupName(groupName)
                    .groupComment(groupComment)
                    .groupLocation(groupLocation)
                    .user(user)
                    .build();
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class ResponseDTO{
        private String groupName;
        private String groupComment;
        private String groupLocation;

        public ResponseDTO toDto(EateryGroup eateryGroup){
            return ResponseDTO.builder()
                    .groupName(eateryGroup.getGroupName())
                    .groupComment(eateryGroup.getGroupComment())
                    .groupLocation(eateryGroup.getGroupComment())
                    .build();
        }
    }

}
