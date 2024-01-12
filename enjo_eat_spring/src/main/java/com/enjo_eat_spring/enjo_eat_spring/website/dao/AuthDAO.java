package com.enjo_eat_spring.enjo_eat_spring.website.dao;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;

public interface AuthDAO {
    void joinUser(User user);
    boolean checkUserData(String userData, String type);
}
