package com.enjo_eat_spring.enjo_eat_spring.website.dao;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;

import java.util.List;

public interface EateryGroupDAO {
    List<EateryGroup> getGroupList();
    EateryGroup getGroup(Long groupId);
    Long createGroup(EateryGroup eateryGroup);
    Long updateGroup(EateryGroup eateryGroup, Long groupId);
    Boolean deleteGroup(Long groupId, User user);
    List<EateryGroup> getGroupListByUser(User user);
}
