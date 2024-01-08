package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/eatery")
public class EateryWebConroller {
    @GetMapping("/group-manage")
    public String getAllGroups(){
        return "eatery/group_manage";
    }

    @GetMapping("/group-create")
    public String getGroupCreate(){
        return "eatery/group_create";
    }

    @GetMapping("/group-edit")
    public String getGroupEdit(){
        return "eatery/group_edit";
    }

}
