package com.enjo_eat_spring.enjo_eat_spring.data.repository;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findAllByEatery_Id(Long eatery_id);
}
