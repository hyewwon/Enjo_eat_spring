package com.enjo_eat_spring.enjo_eat_spring.website.dao.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.Reply;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.ReplyRepository;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.ReplyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyDAOImpl implements ReplyDAO {
    ReplyRepository replyRepository;

    @Autowired
    public ReplyDAOImpl(ReplyRepository replyRepository){
        this.replyRepository = replyRepository;
    }

    @Override
    public Boolean createReply(Reply reply) {
        replyRepository.save(reply);
        return true;
    }
}
