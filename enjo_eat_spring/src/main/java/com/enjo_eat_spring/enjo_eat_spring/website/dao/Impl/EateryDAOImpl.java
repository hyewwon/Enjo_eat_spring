package com.enjo_eat_spring.enjo_eat_spring.website.dao.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.EateryGroupRepository;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.EateryDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EateryDAOImpl implements EateryDAO {
    EateryGroupRepository eateryGroupRepository;

    @Autowired
    public EateryDAOImpl(EateryGroupRepository eateryGroupRepository){
        this.eateryGroupRepository = eateryGroupRepository;
    }

    @Override
    public List<EateryGroup> getGroupList() {
        return eateryGroupRepository.findAll();
    }

    @Override
    @Transactional
    public Long createGroup(EateryGroup eateryGroup) {
        EateryGroup eatery = eateryGroupRepository.save(eateryGroup);
        return eatery.getId();
    }
}
