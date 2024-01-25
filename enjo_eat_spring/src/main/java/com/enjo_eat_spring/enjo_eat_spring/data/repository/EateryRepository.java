package com.enjo_eat_spring.enjo_eat_spring.data.repository;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.Eatery;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EateryRepository extends JpaRepository<Eatery, Long> {
    List<Eatery> findAllByGroup(EateryGroup eateryGroup);
}
