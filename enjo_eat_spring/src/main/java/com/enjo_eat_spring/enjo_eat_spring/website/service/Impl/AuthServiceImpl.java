package com.enjo_eat_spring.enjo_eat_spring.website.service.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.UserDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.AuthDAO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    AuthDAO authDAO;
    PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(AuthDAO authDAO, PasswordEncoder passwordEncoder) {
        this.authDAO = authDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void joinUser(UserDTO.CreateRequestDTO createRequestDTO) {
        String encodedPassword = passwordEncoder.encode(createRequestDTO.getPassword());
        createRequestDTO.encodePassword(encodedPassword);
        User user = createRequestDTO.toEntity();
        authDAO.joinUser(user);
    }

    @Override
    public boolean checkUserData(String userData, String type) {
        return authDAO.checkUserData(userData, type);
    }

}
