package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessCode;
import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessResponse;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.ReplyDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import com.enjo_eat_spring.enjo_eat_spring.website.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply-api")
public class ReplyAPIController {
    ReplyService replyService;

    @Autowired
    public ReplyAPIController(ReplyService replyService, EateryService eateryService){
        this.replyService = replyService;
    }

    @PostMapping(value = "/reply-create/{eateryId}")
    public ResponseEntity<SuccessResponse<Boolean>> createReply(@RequestBody ReplyDTO.RequestDTO requestDTO, @PathVariable Long eateryId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            throw new UsernameNotFoundException("권한이 없습니다.");
        }
        Boolean result = replyService.createReply(requestDTO, eateryId, authentication.getName());
        SuccessResponse<Boolean> response = SuccessResponse.of(SuccessCode.INSERT_SUCCESS, result);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
