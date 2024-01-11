package com.enjo_eat_spring.enjo_eat_spring.website.service;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.UserDTO;

public interface AuthService {
    void joinUser(UserDTO.CreateRequestDTO createRequestDTO);
}
