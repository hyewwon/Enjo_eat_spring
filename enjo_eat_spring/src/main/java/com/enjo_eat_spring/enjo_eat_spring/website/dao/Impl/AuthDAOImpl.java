package com.enjo_eat_spring.enjo_eat_spring.website.dao.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.UserRepository;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.AuthDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthDAOImpl implements AuthDAO{
    UserRepository userRepository;

    @Autowired
    public AuthDAOImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void joinUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean checkUserData(String userData, String type) {
        boolean result = false;
        if(Objects.equals(type, "userid")){
            result =  userRepository.existsByUserid(userData);
        } else if (Objects.equals(type, "username")) {
            result =  userRepository.existsByUsername(userData);
        }
        return result;
    }
}
