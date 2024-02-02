package com.enjo_eat_spring.enjo_eat_spring.website.service;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.ImageDTO;

import java.util.List;

public interface EateryService {
    List<EateryDTO.ListResponseDTO> getEateryList(Long groupId);
    Boolean createEatery(EateryDTO.RequestDTO requestDTO, Long imageId, Long groupId, String username);
    Long createEateryImage(ImageDTO.RequestDTO imageDTO);
    EateryDTO.ResponseDTO getEatery(Long eateryId);
}
