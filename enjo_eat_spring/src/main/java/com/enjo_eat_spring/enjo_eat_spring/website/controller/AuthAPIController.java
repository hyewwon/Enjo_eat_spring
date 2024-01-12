package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.common.response.BasicResponseDTO;
import com.enjo_eat_spring.enjo_eat_spring.common.response.ResponseEnum;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.UserDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.ObjectEqualityComparator;
import org.hibernate.type.descriptor.java.ObjectJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        authService.joinUser(createRequestDTO);
        return BasicResponseDTO.getSuccessMessage(true, ResponseEnum.OK);
    }

    @PostMapping("/check-userData")
    public BasicResponseDTO<Object> CheckUserId(@RequestParam("type") String type, @RequestParam("data") String userData){
        System.out.println("====================in=========================");
        boolean result = authService.checkUserData(userData, type);
        return BasicResponseDTO.getSuccessMessage(result, ResponseEnum.OK);
    }
}
