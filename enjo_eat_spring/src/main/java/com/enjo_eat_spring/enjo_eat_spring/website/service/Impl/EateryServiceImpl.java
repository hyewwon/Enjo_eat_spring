package com.enjo_eat_spring.enjo_eat_spring.website.service.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.Eatery;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.AuthDAO;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.EateryDAO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EateryServiceImpl implements EateryService {
    EateryDAO eateryDAO;
    AuthDAO authDAO;

    @Autowired
    public EateryServiceImpl(EateryDAO eateryDAO, AuthDAO authDAO){
        this.eateryDAO = eateryDAO;
        this.authDAO = authDAO;
    }

    @Override
    public List<EateryDTO.ListResponseDTO> getEateryList(Long groupId) {
        List<Eatery> eateryList = eateryDAO.getEateryList(groupId);
        List<EateryDTO.ListResponseDTO> eateryDTOList = new ArrayList<>();
        for(Eatery eatery: eateryList){
            EateryDTO.ListResponseDTO eateryDTO = EateryDTO.ListResponseDTO.builder()
                    .id(eatery.getId())
                    .eateryName(eatery.getEateryName())
                    .eateryType(eatery.getEateryType())
                    .user(eatery.getUser())
                    .groupId(eatery.getGroup().getId())
                    .build();
            eateryDTOList.add(eateryDTO);
        }
        return eateryDTOList;
    }
}
