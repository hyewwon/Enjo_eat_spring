package com.enjo_eat_spring.enjo_eat_spring.data.dto;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.Eatery;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.Image;
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
    public static  class RequestDTO{
        private String eateryName;
        private String eateryType;
        private String eateryRealLocation;
        private String eateryLocation;
        private String comment;
        private Image image;
        private User user;
        private EateryGroup group;

        public void setImage(Image image){
            this.image = image;
        }
        public void setUser(User user){
            this.user = user;
        }
        public void setGroup(EateryGroup group){
            this.group = group;
        }

        public Eatery toEntity(){
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
