package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/eatery")
public class EateryWebController {
    EateryService eateryService;

    @Autowired
    public EateryWebController(EateryService eateryService){
        this.eateryService = eateryService;
    }

    @GetMapping("/group-manage")
    public String getAllGroups(Model model){
        List<EateryGroupDTO.ResponseDTO> eateryGroupList = eateryService.getGroupList();
        model.addAttribute("groups", eateryGroupList);
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
