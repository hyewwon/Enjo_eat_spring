package com.enjo_eat_spring.enjo_eat_spring.website.service;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;

public interface EateryService {
    EateryGroupDTO  createGroup(String groupName, String groupComment, String groupLocation);
}
