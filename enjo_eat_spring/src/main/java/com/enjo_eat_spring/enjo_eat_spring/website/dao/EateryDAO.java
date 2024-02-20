package com.enjo_eat_spring.enjo_eat_spring.website.dao;


import com.enjo_eat_spring.enjo_eat_spring.data.entity.Eatery;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.Image;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;

import java.util.List;

public interface EateryDAO {
    Image getEateryImage(Long imageId);
    Eatery getEatery(Long eateryId);
    Boolean createEatery(Eatery eatery);
    Long createEateryImage(Image image);
    Boolean updateEatery(Eatery eatery, Long eateryId, User user);
    Boolean deleteEatery(Long eateryId, User user);
    List<Eatery> getEateryList(Long groupId);
    List<Eatery> getAllEateryList();
    List<Eatery> getEateryListByUser(Long groupId, User user);
    List<Eatery> getEateryListTop5();
}
