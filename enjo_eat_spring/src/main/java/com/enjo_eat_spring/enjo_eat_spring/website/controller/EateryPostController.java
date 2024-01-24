package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessCode;
import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessResponse;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/eatery-api")
public class EateryPostController {
    EateryService eateryGroupService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public EateryPostController(EateryService eateryGroupService){
        this.eateryGroupService = eateryGroupService;
    }

    @PostMapping("/group-create")
    public ResponseEntity<SuccessResponse<Long>> postGroupCreate(@RequestBody EateryGroupDTO.CreateRequestDTO createRequestDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            throw new UsernameNotFoundException("권한이 없습니다.");
        }
        Long eateryId = eateryGroupService.createGroup(createRequestDTO, authentication.getName());
        SuccessResponse<Long> response = SuccessResponse.of(SuccessCode.SELECT_SUCCESS, eateryId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
