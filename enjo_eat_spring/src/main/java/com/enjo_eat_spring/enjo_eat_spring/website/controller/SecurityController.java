package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessCode;
import com.enjo_eat_spring.enjo_eat_spring.common.repsonse.SuccessResponse;
import com.enjo_eat_spring.enjo_eat_spring.website.service.Impl.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/security")
public class SecurityController {
    MyUserDetailsService myUserDetailsService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public SecurityController(MyUserDetailsService myUserDetailsService){
        this.myUserDetailsService = myUserDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<SuccessResponse<Boolean>> login(@RequestBody Map<String, String> userData){
        myUserDetailsService.loadUserByUsername(userData.get("userid"));
        SuccessResponse<Boolean> response = SuccessResponse.of(SuccessCode.SELECT_SUCCESS, true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
