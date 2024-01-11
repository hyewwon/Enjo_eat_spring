package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.common.response.BasicResponseDTO;
import com.enjo_eat_spring.enjo_eat_spring.common.response.ResponseEnum;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.UserDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth-api")
public class AuthAPIController {
    AuthService authService;

    @Autowired
    public AuthAPIController(AuthService authService){
        this.authService = authService;
    }
    @PostMapping("/join")
    public BasicResponseDTO<Object> JoinUser(@RequestBody UserDTO.CreateRequestDTO createRequestDTO){
        return BasicResponseDTO.getSuccessMessage(true, ResponseEnum.OK);
    }
}
