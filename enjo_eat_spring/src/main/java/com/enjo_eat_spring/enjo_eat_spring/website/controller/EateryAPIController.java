package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessCode;
import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessResponse;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    public EateryAPIController(EateryService eateryGroupService){
        this.eateryGroupService = eateryGroupService;
    }

    @PostMapping("/group-create")
    public ResponseEntity<SuccessResponse<Long>> postGroupCreate(@RequestBody EateryGroupDTO.CreateRequestDTO createRequestDTO){
        Long eateryId = eateryGroupService.createGroup(createRequestDTO);
        SuccessResponse<Long> response = SuccessResponse.of(SuccessCode.SELECT_SUCCESS, eateryId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
