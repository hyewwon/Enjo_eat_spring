package com.enjo_eat_spring.enjo_eat_spring.data.dto;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

        @NotBlank
        @Size(min = 2, message = "2자리 이상 입력해주세요.")
        private String username;

        @NotBlank
        @Size(min = 5, message = "5자리 이상 입력해주세요.")
        private String userid;

        @NotBlank
        @Size(min = 5, message = "5자리 이상 입력해 주세요.")
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
