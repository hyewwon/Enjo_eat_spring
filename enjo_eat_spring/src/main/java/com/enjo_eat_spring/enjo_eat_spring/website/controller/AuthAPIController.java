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

    @PostMapping("/check-userid")
    public BasicResponseDTO<Object> CheckUserId(@RequestParam("userid") String userId){
        boolean result = authService.checkUserId(userId);
        if(!result){
            return BasicResponseDTO.getFailMessage(false, ResponseEnum.BAD_REQUEST);
        }

        return BasicResponseDTO.getSuccessMessage(true, ResponseEnum.OK);
    }
}
