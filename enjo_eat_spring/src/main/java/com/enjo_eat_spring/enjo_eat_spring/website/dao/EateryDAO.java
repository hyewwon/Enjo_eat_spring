package com.enjo_eat_spring.enjo_eat_spring.website.dao;


import com.enjo_eat_spring.enjo_eat_spring.data.entity.Eatery;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.Image;

import java.util.List;

public interface EateryDAO {
    List<Eatery> getEateryList(Long groupId);
    Boolean createEatery(Eatery eatery);
    Long createEateryImage(Image image);
    Image getEateryImage(Long imageId);
}
