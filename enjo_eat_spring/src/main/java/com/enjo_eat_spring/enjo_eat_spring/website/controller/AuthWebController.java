package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryGroupService;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@NoArgsConstructor
@RequestMapping("/")
public class AuthWebController {
    EateryGroupService eateryGroupService;
    EateryService eateryService;

    @Autowired
    public AuthWebController(EateryGroupService eateryGroupService, EateryService eateryService){
        this.eateryGroupService = eateryGroupService;
        this.eateryService = eateryService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<EateryDTO.ListResponseDTO> eateryTop5 = eateryService.getEateryListTop5();
        model.addAttribute("eateryTop5", eateryTop5);
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

    @GetMapping("/my-page")
    public String getMyPage(){
        return "auth/my_page";
    }

    @GetMapping("/my-group")
    public String getMyGroup(Model model){
        Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();
        List<EateryGroupDTO.ResponseDTO> eateryGroupList = eateryGroupService.getGroupListByUser(authentication.getName());
        model.addAttribute("groups", eateryGroupList);
        return "auth/my_group";
    }

    @GetMapping("/my-eatery/{groupId}")
    public String getMyEatery(Model model, @PathVariable Long groupId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<EateryDTO.ListResponseDTO> eateryList = eateryService.getEateryListByUser(groupId, authentication.getName());
        model.addAttribute("eateries", eateryList);
        model.addAttribute("groupId", groupId);
        return "auth/my_eatery";
    }

}

