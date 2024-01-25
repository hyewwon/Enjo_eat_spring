package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessCode;
import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessResponse;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryGroupService;
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
@RequestMapping("/eateryGroup-api")
public class EateryGroupAPIController {
    EateryGroupService eateryGroupService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public EateryGroupAPIController(EateryGroupService eateryGroupService){
        this.eateryGroupService = eateryGroupService;
    }

    @PostMapping("/group-create")
    public ResponseEntity<SuccessResponse<Long>> createGroup(@RequestBody EateryGroupDTO.RequestDTO requestDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            throw new UsernameNotFoundException("권한이 없습니다.");
        }
        Long groupId = eateryGroupService.createGroup(requestDTO, authentication.getName());
        SuccessResponse<Long> response = SuccessResponse.of(SuccessCode.INSERT_SUCCESS, groupId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/group-edit/{groupId}")
    public ResponseEntity<SuccessResponse<Long>> updateGroup(@RequestBody EateryGroupDTO.RequestDTO requestDTO, @PathVariable Long groupId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            throw new UsernameNotFoundException("권한이 없습니다.");
        }
        Long id = eateryGroupService.updateGroup(requestDTO, groupId, authentication.getName());
        SuccessResponse<Long> response = SuccessResponse.of(SuccessCode.UPDATE_SUCCESS, id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/group-delete/{groupId}")
    public ResponseEntity<SuccessResponse<Boolean>> deleteGroup(@PathVariable Long groupId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            throw new UsernameNotFoundException("권한이 없습니다.");
        }
        Boolean result  = eateryGroupService.deleteGroup(groupId, authentication.getName());
        SuccessResponse<Boolean> response = SuccessResponse.of(SuccessCode.DELETE_SUCCESS, result);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
