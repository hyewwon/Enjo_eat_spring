package com.enjo_eat_spring.enjo_eat_spring.website.dao.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.Eatery;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.Image;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.EateryGroupRepository;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.EateryRepository;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.ImageRepository;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.EateryDAO;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EateryDAOImpl implements EateryDAO {
    EateryRepository eateryRepository;
    EateryGroupRepository eateryGroupRepository;
    ImageRepository imageRepository;
    private final Logger log = LoggerFactory.getLogger(getClass());

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
    public List<Eatery> getAllEateryList() {
        return eateryRepository.findAll();
    }

    @Override
    @Transactional
    public Boolean createEatery(Eatery eatery) {
        eateryRepository.save(eatery);
        return true;
    }

    @Override
    public Long createEateryImage(Image image) {
        return imageRepository.save(image).getId();
    }

    @Override
    public Image getEateryImage(Long imageId) {
        return imageRepository.findById(imageId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 이미지 입니다")
        );
    }

    @Override
    public Eatery getEatery(Long eateryId) {
        return eateryRepository.findById(eateryId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 후기입니다.")
        );
    }

    @Override
    public List<Eatery> getEateryListByUser(Long groupId, User user) {
        EateryGroup eateryGroup = eateryGroupRepository.findById(groupId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 그룹입니다.")
        );
        return eateryRepository.findAllByUserAndGroup(user, eateryGroup);
    }

    @Override
    public Boolean updateEatery(Eatery eatery, Long eateryId, User user) {
        Eatery origin_eatery = eateryRepository.findById(eateryId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 음식점 입니다.")
        );
        if(origin_eatery.getUser() != user){
            throw new UsernameNotFoundException("삭제 권한이 없습니다.");
        }
        origin_eatery.update(eatery.getEateryName(),eatery.getEateryType(), eatery.getEateryLocation(), eatery.getEateryRealLocation(), eatery.getComment());
        eateryRepository.save(origin_eatery);
        return true;
    }

    @Override
    public Boolean deleteEatery(Long eateryId, User user) {
        Eatery eatery = eateryRepository.findById(eateryId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 음식점 입니다.")
        );
        if(eatery.getUser() != user){
            throw new UsernameNotFoundException("삭제 권한이 없습니다.");
        }
        eateryRepository.delete(eatery);
        return true;
    }

    @Override
    public List<Eatery> getEateryListTop5() {
        Long eateries_size = eateryRepository.countAllBy();
        if(eateries_size < 5){
            return eateryRepository.findAll();
        }
        return eateryRepository.findTop5ByOrderByCreatedAtDesc();
    }

}
