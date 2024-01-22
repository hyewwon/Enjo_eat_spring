package com.enjo_eat_spring.enjo_eat_spring.website.service;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService{
    void joinUser(UserDTO.CreateRequestDTO createRequestDTO);
    boolean checkUserData(String userData, String type);
}
