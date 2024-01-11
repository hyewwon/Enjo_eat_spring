package com.enjo_eat_spring.enjo_eat_spring.website.dao.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.UserRepository;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.AuthDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
}
