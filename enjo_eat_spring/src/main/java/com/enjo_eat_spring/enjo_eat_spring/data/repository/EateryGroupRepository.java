package com.enjo_eat_spring.enjo_eat_spring.data.repository;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EateryGroupRepository extends JpaRepository<EateryGroup, Long> {
    List<EateryGroup> findAllByUser(User user);
}
