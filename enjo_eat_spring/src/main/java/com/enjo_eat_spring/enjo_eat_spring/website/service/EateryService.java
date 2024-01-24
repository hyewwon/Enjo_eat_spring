package com.enjo_eat_spring.enjo_eat_spring.website.service;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;

import java.util.List;

public interface EateryService {
    List<EateryGroupDTO.ResponseDTO> getGroupList();
    Long createGroup(EateryGroupDTO.CreateRequestDTO createRequestDTO, String username);
}
