package com.enjo_eat_spring.enjo_eat_spring.website.dao.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.Eatery;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.EateryGroupRepository;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.EateryRepository;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.ImageRepository;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.EateryDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EateryDAOImpl implements EateryDAO {
    EateryRepository eateryRepository;
    EateryGroupRepository eateryGroupRepository;
    ImageRepository imageRepository;

    @Autowired
    public EateryDAOImpl(EateryRepository eateryRepository, EateryGroupRepository eateryGroupRepository, ImageRepository imageRepository){
        this.eateryRepository = eateryRepository;
        this.eateryGroupRepository = eateryGroupRepository;
        this.imageRepository = imageRepository;
    }
    @Override
    public List<Eatery> getEateryList(Long groupId) {
        EateryGroup eateryGroup = eateryGroupRepository.findById(groupId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 그룹입니다.")
        );
        return eateryRepository.findAllByGroup(eateryGroup);
    }

    @Override
    @Transactional
    public Boolean createEatery(Eatery eatery) {
        eateryRepository.save(eatery);
        imageRepository.save(eatery.getImage());
        return true;
    }
}
