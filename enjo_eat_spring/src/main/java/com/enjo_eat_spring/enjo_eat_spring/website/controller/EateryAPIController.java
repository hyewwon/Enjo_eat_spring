package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.common.response.BasicResponseDTO;
import com.enjo_eat_spring.enjo_eat_spring.common.response.ResponseEnum;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eatery-api")
public class EateryAPIController {
    EateryService eateryGroupService;

    @Autowired
    public EateryAPIController(EateryService eateryGroupService){
        this.eateryGroupService = eateryGroupService;
    }

    @PostMapping("/group-create")
    public BasicResponseDTO<Object> postGroupCreate(@RequestBody EateryGroupDTO.CreateRequestDTO createRequestDTO){
        Long eateryId = eateryGroupService.createGroup(createRequestDTO);
        return BasicResponseDTO.getSuccessData(true, ResponseEnum.OK, "저장되었습니다.", eateryId);
    }
}
