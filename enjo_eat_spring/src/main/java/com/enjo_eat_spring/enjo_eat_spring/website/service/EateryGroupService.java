package com.enjo_eat_spring.enjo_eat_spring.website.service;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;

import java.util.List;

public interface EateryGroupService {
    EateryGroupDTO.ResponseDTO getGroup(Long groupId);
    Long createGroup(EateryGroupDTO.RequestDTO RequestDTO, String username);
    Long updateGroup(EateryGroupDTO.RequestDTO RequestDTO, Long groupId, String username);
    Boolean deleteGroup(Long groupId, String username);
    List<EateryGroupDTO.ResponseDTO> getGroupList();
    List<EateryGroupDTO.ResponseDTO> getGroupListByUser(String username);
}
