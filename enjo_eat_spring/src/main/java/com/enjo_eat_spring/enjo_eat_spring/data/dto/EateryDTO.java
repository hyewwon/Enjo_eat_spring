package com.enjo_eat_spring.enjo_eat_spring.data.dto;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class EateryDTO {
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class RequestDTO {
        private String eateryName;
        private String eateryType;
        private String eateryRealLocation;
        private String eateryLocation;
        private String comment;
        private Image image;
        private User user;
        private EateryGroup group;

        public void setImage(Image image) {
            this.image = image;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public void setGroup(EateryGroup group) {
            this.group = group;
        }

        public Eatery toEntity() {
            return Eatery.builder()
                    .eateryName(eateryName)
                    .eateryType(eateryType)
                    .eateryRealLocation(eateryRealLocation)
                    .eateryLocation(eateryLocation)
                    .comment(comment)
                    .user(user)
                    .group(group)
                    .image(image)
                    .build();
        }

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class ResponseDTO {
        private Long id;
        private String eateryName;
        private String eateryType;
        private String eateryRealLocation;
        private String eateryLocation;
        private String comment;
        private Image image;
        private String username;
        private Long groupId;
        private List<Reply> reply;

        public EateryDTO.ResponseDTO toDto(Eatery eatery) {
            return ResponseDTO.builder()
                    .id(eatery.getId())
                    .eateryType(eatery.getEateryType())
                    .eateryName(eatery.getEateryName())
                    .eateryRealLocation(eatery.getEateryRealLocation())
                    .eateryLocation(eatery.getEateryLocation())
                    .comment(eatery.getComment())
                    .image(eatery.getImage())
                    .username(eatery.getUser().getUsername())
                    .groupId(eatery.getGroup().getId())
                    .reply(eatery.getReplies())
                    .build();
        }
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class ListResponseDTO {
        private Long id;
        private String eateryName;
        private String eateryType;
        private User user;
        private Long groupId;
    }

    public EateryDTO.ListResponseDTO toDto(Eatery eatery) {
        return ListResponseDTO.builder()
                .id(eatery.getId())
                .eateryName(eatery.getEateryName())
                .user(eatery.getUser())
                .groupId(eatery.getGroup().getId())
                .build();
    }

}
