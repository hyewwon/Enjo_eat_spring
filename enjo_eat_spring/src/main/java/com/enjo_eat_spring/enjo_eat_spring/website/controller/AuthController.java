package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@NoArgsConstructor
public class AuthController {
    @GetMapping("/")
    public String home(){
        return "auth/home";
    }
}
