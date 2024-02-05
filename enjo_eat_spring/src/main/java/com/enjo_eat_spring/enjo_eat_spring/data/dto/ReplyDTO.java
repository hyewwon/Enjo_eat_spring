package com.enjo_eat_spring.enjo_eat_spring.data.dto;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.Eatery;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.Reply;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ReplyDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class RequestDTO{
        private String reply;
        private User user;
        private Eatery eatery;

        public void setUser(User user){
            this.user = user;
        }
        public void setEatery(Eatery eatery){
            this.eatery =  eatery;
        }

        public Reply toEntity(){
            return Reply.builder()
                    .reply(reply)
                    .user(user)
                    .eatery(eatery)
                    .build();
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class ResponseDTO{
        private Long id;
        private String reply;
        private User user;
        private LocalDateTime createdAt;

        public ResponseDTO toDTO(Reply reply){
            return ResponseDTO.builder()
                    .id(reply.getId())
                    .reply(reply.getReply())
                    .user(reply.getUser())
                    .createdAt(reply.getCreatedAt())
                    .build();
        }
    }
}
