package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@NoArgsConstructor
@RequestMapping("/")
public class AuthWebController {
    @GetMapping("/")
    public String home(){
        return "auth/home";
    }

    @GetMapping("/login")
    public String loginUser(){
        return "auth/login";
    }

    @GetMapping("/join")
    public String joinUser(){
        return "auth/join";
    }
}

