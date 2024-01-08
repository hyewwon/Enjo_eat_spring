package com.enjo_eat_spring.enjo_eat_spring.website.dao.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.EateryGroupRepository;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.EateryDAO;
import org.springframework.stereotype.Service;

@Service
public class EateryDAOImpl implements EateryDAO {
    EateryGroupRepository eateryGroupRepository;

    public EateryDAOImpl(EateryGroupRepository eateryGroupRepository){
        this.eateryGroupRepository = eateryGroupRepository;
    }
    @Override
    public EateryGroup createGroup(EateryGroup eateryGroup) {
        EateryGroup eatery = eateryGroupRepository.save(eateryGroup);
        return eatery;
    }
}
