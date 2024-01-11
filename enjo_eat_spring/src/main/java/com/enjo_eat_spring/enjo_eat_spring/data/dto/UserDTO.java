package com.enjo_eat_spring.enjo_eat_spring.data.dto;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class CreateRequestDTO{
        private String userid;
        private String username;
        private String password;

        public void encodePassword(String encodedPassword){
            this.password = encodedPassword;
        }

        public User toEntity(){
            return User.builder()
                    .userid(userid)
                    .username(username)
                    .password(password)
                    .build();
        }


    }
}
