package com.enjo_eat_spring.enjo_eat_spring.website.controller;

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
    public ResponseEntity<String> postGroupCreate(@RequestBody EateryGroupDTO.CreateRequestDTO createRequestDTO){
        String groupName  = createRequestDTO.getGroupName();
        String groupComment = createRequestDTO.getGroupComment();
        String groupLocation = createRequestDTO.getGroupLocation();
        eateryGroupService
        return ResponseEntity.status(HttpStatus.CREATED).body("저장되었습니다.");
    }
}
