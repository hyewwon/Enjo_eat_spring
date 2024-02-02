package com.enjo_eat_spring.enjo_eat_spring.website.service.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.ReplyDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.Eatery;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.Reply;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.AuthDAO;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.EateryDAO;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.ReplyDAO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {
    ReplyDAO replyDAO;
    EateryDAO eateryDAO;
    AuthDAO authDAO;

    @Autowired
    public ReplyServiceImpl(ReplyDAO replyDAO, EateryDAO eateryDAO, AuthDAO authDAO){
        this.replyDAO = replyDAO;
        this.eateryDAO = eateryDAO;
        this.authDAO = authDAO;
    }

    @Override
    public Boolean createReply(ReplyDTO.RequestDTO requestDTO, Long eateryId, String username) {
        User user = authDAO.getUser(username);
        Eatery eatery = eateryDAO.getEatery(eateryId);
        requestDTO.setUser(user);
        requestDTO.setEatery(eatery);
        Reply reply = requestDTO.toEntity();
        return replyDAO.createReply(reply);
    }
}
