package com.enjo_eat_spring.enjo_eat_spring.website.dao.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.Eatery;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.Reply;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.EateryRepository;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.ReplyRepository;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.ReplyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyDAOImpl implements ReplyDAO {
    EateryRepository eateryRepository;
    ReplyRepository replyRepository;

    @Autowired
    public ReplyDAOImpl(ReplyRepository replyRepository, EateryRepository eateryRepository){
        this.replyRepository = replyRepository;
        this.eateryRepository = eateryRepository;
    }

    @Override
    public List<Reply> getReplyList(Long eateryId) {
        Eatery eatery = eateryRepository.findById(eateryId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 게시물 입니다.")
        );
        return replyRepository.findAllByEatery_Id(eateryId);

    }

    @Override
    public Boolean createReply(Reply reply) {
        replyRepository.save(reply);
        return true;
    }

    @Override
    public Boolean deleteReply(Long replyId, User user) {
        Reply reply = replyRepository.findById(replyId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 댓글 입니다.")
        );
        if(reply.getUser() != user){
            throw new UsernameNotFoundException("삭제 권한이 없습니다.");
        }
        replyRepository.delete(reply);
        return true;
    }

}
