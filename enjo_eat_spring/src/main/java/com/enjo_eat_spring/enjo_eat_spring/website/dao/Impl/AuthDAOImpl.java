package com.enjo_eat_spring.enjo_eat_spring.website.dao.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.UserRepository;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.AuthDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

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
        if(Objects.equals(type, "userid")){
            return userRepository.existsByUserid(userData);
        } else if (Objects.equals(type, "username")) {
            return userRepository.existsByUsername(userData);
        }
        return false;
    }

    @Override
    public User loginUser(String userid) {
        Optional<User> result =  userRepository.findByUserid(userid);
        return result.orElse(null);
    }
}
