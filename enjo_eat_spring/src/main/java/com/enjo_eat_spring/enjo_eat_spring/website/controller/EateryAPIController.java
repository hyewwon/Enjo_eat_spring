package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessCode;
import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessResponse;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.ImageDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eatery-api")
public class EateryAPIController {
    EateryService eateryService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public EateryAPIController(EateryService eateryService){
        this.eateryService = eateryService;
    }

    @PostMapping(value = "/eatery-create/{groupId}",  consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<SuccessResponse<Boolean>> createEatery(@RequestPart EateryDTO.RequestDTO requestDTO, @RequestPart MultipartFile eateryImage, @PathVariable Long groupId) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            throw new UsernameNotFoundException("권한이 없습니다.");
        }

        // 이미지 저장
        String projectPath = System.getProperty("user.dir") + "\\enjo_eat_spring\\src\\main\\resources\\static\\eatery_image";
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + eateryImage.getOriginalFilename();
        File saveFile = new File(projectPath, fileName);
        eateryImage.transferTo(saveFile);
        ImageDTO.RequestDTO imageDTO = new ImageDTO.RequestDTO(fileName, eateryImage.getOriginalFilename(), "\\eatery_image\\");

        Long imageId = eateryService.createEateryImage(imageDTO);
        Boolean result = eateryService.createEatery(requestDTO, imageId, groupId, authentication.getName());
        SuccessResponse<Boolean> response = SuccessResponse.of(SuccessCode.INSERT_SUCCESS, result);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
