package com.enjo_eat_spring.enjo_eat_spring.website.dao;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;

import java.util.List;

public interface EateryDAO {
    List<EateryGroup> getGroupList();
    Long createGroup(EateryGroup eateryGroup);
}
