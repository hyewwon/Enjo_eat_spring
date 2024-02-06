package com.enjo_eat_spring.enjo_eat_spring.website.service;


import com.enjo_eat_spring.enjo_eat_spring.data.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {
    Boolean createReply(ReplyDTO.RequestDTO requestDTO, Long eateryId, String username);
    Boolean deleteReply(Long replyId, String username);
    List<ReplyDTO.ResponseDTO> getRelies(Long eateryId);
}
