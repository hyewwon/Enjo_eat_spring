package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.ReplyDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryGroupService;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import com.enjo_eat_spring.enjo_eat_spring.website.service.ReplyService;
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
    ReplyService replyService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public EateryWebController(EateryService eateryService, EateryGroupService eateryGroupService, ReplyService replyService){
        this.eateryService = eateryService;
        this.eateryGroupService = eateryGroupService;
        this.replyService = replyService;
    }

    @GetMapping("/eatery-manage/{groupId}")
    public String getAllEateriesByGroup(Model model, @PathVariable Long groupId){
        List<EateryDTO.ListResponseDTO> eateryList = eateryService.getEateryList(groupId);
        int openFlag = eateryGroupService.getGroup(groupId).getOpenFlag();
        model.addAttribute("eateries", eateryList);
        model.addAttribute("groupId", groupId);
        model.addAttribute("openFlag", openFlag);
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

    @GetMapping("/eatery-detail/{eateryId}")
    public String getEatery(Model model, @PathVariable Long eateryId){
        Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();
        EateryDTO.ResponseDTO eateryResponseDTO = eateryService.getEatery(eateryId);
        List<ReplyDTO.ResponseDTO> replyResponseList = replyService.getRelies(eateryId);
        model.addAttribute("replies", replyResponseList);
        model.addAttribute("eatery", eateryResponseDTO);
        model.addAttribute("username", authentication.getName());
        return "eatery/eatery_detail";
    }

    @GetMapping("/eatery-edit/{eateryId}")
    public String editEatery(Model model, @PathVariable Long eateryId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        EateryDTO.ResponseDTO eateryResponseDTO = eateryService.getEatery(eateryId);
        model.addAttribute("eatery", eateryResponseDTO);
        model.addAttribute("username", authentication.getName());
        return "eatery/eatery_edit";
    }

}
