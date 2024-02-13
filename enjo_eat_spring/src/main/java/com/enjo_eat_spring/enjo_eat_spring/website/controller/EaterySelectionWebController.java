package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryGroupService;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Controller
@RequiredArgsConstructor
@RequestMapping("/eatery-selection")
public class EaterySelectionWebController {
    EateryGroupService eateryGroupService;
    EateryService eateryService;

    @Autowired
    public EaterySelectionWebController(EateryGroupService eateryGroupService, EateryService eateryService){
        this.eateryGroupService = eateryGroupService;
        this.eateryService = eateryService;
    }

    @GetMapping("/group-select")
    public String getAllGroups(Model model){
        List<EateryGroupDTO.ResponseDTO> eateryGroupList = eateryGroupService.getGroupList();
        model.addAttribute("groups", eateryGroupList);
        return "eatery_selection/group_select";
    }

   @GetMapping("/eatery-select/{groupId}")
    public String getAllEateriesByGroup(Model model, @PathVariable Long groupId){
        List<Long> eateryIdList = eateryService.getEateryIdList(groupId);
       Collections.shuffle(eateryIdList);
        model.addAttribute("eateryIdList", eateryIdList);
        return "eatery_selection/eatery_select";
   }
}
