package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryGroupService;
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
    EateryGroupService eateryGroupService;

    @Autowired
    public EateryAPIController(EateryGroupService eateryGroupService){
        this.eateryGroupService = eateryGroupService;
    }

    @PostMapping("/group-create")
    public ResponseEntity<?> postGroupCreate(@RequestBody EateryGroupDTO.CreateRequestDTO createRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body("저장되었습니다.");
    }
}
