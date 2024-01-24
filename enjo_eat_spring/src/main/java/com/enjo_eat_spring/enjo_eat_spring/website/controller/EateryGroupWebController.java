package com.enjo_eat_spring.enjo_eat_spring.website.controller;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryGroupService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/eatery")
public class EateryGroupWebController {
    EateryGroupService eateryGroupService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public EateryGroupWebController(EateryGroupService eateryGroupService){
        this.eateryGroupService = eateryGroupService;
    }

    @GetMapping("/group-manage")
    public String getAllGroups(Model model){
        List<EateryGroupDTO.ResponseDTO> eateryGroupList = eateryGroupService.getGroupList();
        model.addAttribute("groups", eateryGroupList);
        return "eatery_group/group_manage";
    }

    @GetMapping("/group-create")
    public String getGroupCreate(){
        return "eatery_group/group_create";
    }

    @GetMapping("/group-edit/{groupId}")
    public String getGroupEdit(@PathVariable Long groupId, Model model){
        EateryGroupDTO.ResponseDTO responseDTO = eateryGroupService.getGroup(groupId);
        log.error(responseDTO.getGroupComment());
        model.addAttribute("group", responseDTO);
        return "eatery_group/group_edit";
    }

}
