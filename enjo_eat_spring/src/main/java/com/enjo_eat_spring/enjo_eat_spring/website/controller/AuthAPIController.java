package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessCode;
import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessResponse;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.UserDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth-api")
public class AuthAPIController {
    AuthService authService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public AuthAPIController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/join")
    public ResponseEntity<SuccessResponse<Boolean>> JoinUser(@RequestBody @Valid UserDTO.CreateRequestDTO createRequestDTO){
        authService.joinUser(createRequestDTO);
        SuccessResponse<Boolean> response = SuccessResponse.of(SuccessCode.INSERT_SUCCESS, true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ResponseBody
    @PostMapping("/check-userData")
    public ResponseEntity<SuccessResponse<Boolean>> CheckUserId(@RequestBody Map<String, String> userData){
        boolean dataExists = authService.checkUserData(userData.get("data"), userData.get("type"));
        SuccessResponse<Boolean> response = SuccessResponse.of(SuccessCode.SELECT_SUCCESS, dataExists);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
