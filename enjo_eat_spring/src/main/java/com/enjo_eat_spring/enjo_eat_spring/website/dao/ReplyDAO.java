package com.enjo_eat_spring.enjo_eat_spring.website.dao;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.Reply;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;

import java.util.List;

public interface ReplyDAO {
    Boolean createReply(Reply reply);
    List<Reply> getReplyList(Long eateryId);
    Boolean deleteReply(Long replyId, User user);
}
