package com.enjo_eat_spring.enjo_eat_spring.website.service.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import org.springframework.stereotype.Service;

@Service
public class EateryGroupServiceImpl implements EateryService {
    @Override
    public EateryGroupDTO createGroup(String groupName, String groupComment, String groupLocation) {
        EateryGroup eateryGroup = new EateryGroupDTO.CreateRequestDTO();

        return null;
    }
}
