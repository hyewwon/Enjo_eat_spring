package com.enjo_eat_spring.enjo_eat_spring.website.dao;


import com.enjo_eat_spring.enjo_eat_spring.data.entity.Eatery;

import java.util.List;

public interface EateryDAO {
    List<Eatery> getEateryList(Long groupId);
}
