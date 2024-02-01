package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryGroupService;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequiredArgsConstructor
@RequestMapping("/eatery")
public class EateryWebController {
    EateryService eateryService;
    EateryGroupService eateryGroupService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public EateryWebController(EateryService eateryService, EateryGroupService eateryGroupService){
        this.eateryService = eateryService;
        this.eateryGroupService = eateryGroupService;
    }

    @GetMapping("/eatery-manage/{groupId}")
    public String getAllEateries(Model model, @PathVariable Long groupId){
        List<EateryDTO.ListResponseDTO> eateryList = eateryService.getEateryList(groupId);
        model.addAttribute("eateries", eateryList);
        return "eatery/eatery_manage";
    }

    @GetMapping("/eatery-create/{groupId}")
    public String createEatery(Model model, @PathVariable Long groupId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        EateryGroupDTO.ResponseDTO eateryGroup = eateryGroupService.getGroup(groupId);
        model.addAttribute("eateryGroup", eateryGroup);
        model.addAttribute("username", authentication.getName());
        return "eatery/eatery_create";
    }

}
