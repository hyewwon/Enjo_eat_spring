package com.enjo_eat_spring.enjo_eat_spring.website.service;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryDTO;

import java.util.List;

public interface EateryService {
    List<EateryDTO.ListResponseDTO> getEateryList(Long groupId);
}
