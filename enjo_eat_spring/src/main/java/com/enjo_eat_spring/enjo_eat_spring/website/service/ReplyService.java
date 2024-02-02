package com.enjo_eat_spring.enjo_eat_spring.website.service;


import com.enjo_eat_spring.enjo_eat_spring.data.dto.ReplyDTO;

public interface ReplyService {
    Boolean createReply(ReplyDTO.RequestDTO requestDTO, Long eateryId, String username);
}
