package com.enjo_eat_spring.enjo_eat_spring.data.dto;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.Image;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ImageDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class RequestDTO{
        private String imageName;
        private String originImageName;
        private String imagePath;

        public Image toEntity(){
            return Image.builder()
                    .imageName(imageName)
                    .originImageName(originImageName)
                    .imagePath(imagePath)
                    .build();
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class ResponseDTO{
        private Long id;
        private String imageName;
        private String originImageName;
        private String imagePath;

        public ResponseDTO toDTO(Image image){
            return ResponseDTO.builder()
                    .id(image.getId())
                    .imageName(image.getImageName())
                    .originImageName(image.getOriginImageName())
                    .imagePath(image.getImagePath())
                    .build();
        }
    }
}
