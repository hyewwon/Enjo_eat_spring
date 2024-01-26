package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessCode;
import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessResponse;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryDTO;
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
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/eatery-create/{groupId}")
    public ResponseEntity<SuccessResponse<Boolean>> createEatery(@RequestBody EateryDTO.RequestDTO requestDTO, @PathVariable Long groupId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            throw new UsernameNotFoundException("권한이 없습니다.");
        }
        Boolean result = eateryService.createEatery(requestDTO, groupId, authentication.getName());
        SuccessResponse<Boolean> response = SuccessResponse.of(SuccessCode.INSERT_SUCCESS, result);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
