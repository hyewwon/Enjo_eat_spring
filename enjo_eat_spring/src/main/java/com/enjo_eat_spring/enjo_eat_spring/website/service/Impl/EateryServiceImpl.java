package com.enjo_eat_spring.enjo_eat_spring.website.service.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.ImageDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.Eatery;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.Image;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.AuthDAO;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.EateryDAO;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.EateryGroupDAO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EateryServiceImpl implements EateryService {
    EateryDAO eateryDAO;
    EateryGroupDAO eateryGroupDAO;
    AuthDAO authDAO;

    @Autowired
    public EateryServiceImpl(EateryDAO eateryDAO, EateryGroupDAO eateryGroupDAO, AuthDAO authDAO){
        this.eateryDAO = eateryDAO;
        this.eateryGroupDAO = eateryGroupDAO;
        this.authDAO = authDAO;
    }

    @Override
    public List<EateryDTO.ListResponseDTO> getEateryList(Long groupId) {
        List<Eatery> eateryList = eateryDAO.getEateryList(groupId);
        List<EateryDTO.ListResponseDTO> eateryDTOList = new ArrayList<>();
        for(Eatery eatery: eateryList){
            EateryDTO.ListResponseDTO eateryDTO = EateryDTO.ListResponseDTO.builder()
                    .id(eatery.getId())
                    .eateryName(eatery.getEateryName())
                    .eateryType(eatery.getEateryType())
                    .image(eatery.getImage())
                    .user(eatery.getUser())
                    .groupId(eatery.getGroup().getId())
                    .build();
            eateryDTOList.add(eateryDTO);
        }
        return eateryDTOList;
    }

    @Override
    public Boolean createEatery(EateryDTO.RequestDTO requestDTO, Long imageId, Long groupId, String username) {
        User user = authDAO.getUser(username);
        EateryGroup eateryGroup = eateryGroupDAO.getGroup(groupId);
        Image image = eateryDAO.getEateryImage(imageId);
        requestDTO.setUser(user);
        requestDTO.setGroup(eateryGroup);
        requestDTO.setImage(image);
        Eatery eatery = requestDTO.toEntity();
        return eateryDAO.createEatery(eatery);
    }

    @Override
    public Long createEateryImage(ImageDTO.RequestDTO imageDTO) {
        Image image = imageDTO.toEntity();
        return eateryDAO.createEateryImage(image);
    }

    @Override
    public EateryDTO.ResponseDTO getEatery(Long eateryId) {
        Eatery eatery = eateryDAO.getEatery(eateryId);
        EateryDTO.ResponseDTO eateryDTO = new EateryDTO.ResponseDTO();
        return eateryDTO.toDto(eatery);
    }

    @Override
    public List<EateryDTO.ListResponseDTO> getEateryListByUser(Long groupId, String username) {
        User user = authDAO.getUser(username);
        List<Eatery> eateryList = eateryDAO.getEateryListByUser(groupId, user);
        List<EateryDTO.ListResponseDTO> eateryDTOList = new ArrayList<>();
        for(Eatery eatery: eateryList){
            EateryDTO.ListResponseDTO eateryDTO = EateryDTO.ListResponseDTO.builder()
                    .id(eatery.getId())
                    .eateryName(eatery.getEateryName())
                    .eateryType(eatery.getEateryType())
                    .image(eatery.getImage())
                    .user(eatery.getUser())
                    .groupId(eatery.getGroup().getId())
                    .build();
            eateryDTOList.add(eateryDTO);
        }
        return eateryDTOList;
    }

    @Override
    public List<EateryDTO.ListResponseDTO> getEateryListTop5() {
        List<Eatery> eateryList = eateryDAO.getEateryListTop5();
        List<EateryDTO.ListResponseDTO> eateryDTOList = new ArrayList<>();
        for(Eatery eatery: eateryList){
            EateryDTO.ListResponseDTO eateryDTO = EateryDTO.ListResponseDTO.builder()
                    .id(eatery.getId())
                    .eateryName(eatery.getEateryName())
                    .eateryType(eatery.getEateryType())
                    .comment(eatery.getComment())
                    .image(eatery.getImage())
                    .user(eatery.getUser())
                    .groupId(eatery.getGroup().getId())
                    .build();
            eateryDTOList.add(eateryDTO);
        }
        return eateryDTOList;
    }

    @Override
    public Boolean updateEatery(EateryDTO.RequestDTO requestDTO, Long eateryId, String username) {
        User user = authDAO.getUser(username);
        Eatery eatery = requestDTO.toEntity();
        return eateryDAO.updateEatery(eatery, eateryId, user);
    }

    @Override
    public Boolean deleteEatery(Long eateryId, String username) {
        User user = authDAO.getUser(username);
        return eateryDAO.deleteEatery(eateryId, user);
    }

    @Override
    public EateryDTO.SelectionResponseDTO getSelectedEatery(Long eateryId) {
        Eatery eatery = eateryDAO.getEatery(eateryId);
        EateryDTO.SelectionResponseDTO eateryDTO = new EateryDTO.SelectionResponseDTO();
        return eateryDTO.toDto(eatery);
    }

    @Override
    public List<Long> getEateryIdList(Long groupId) {
        List<Eatery> eateryList = eateryDAO.getEateryList(groupId);
        List<Long> eateryIdList = new ArrayList<>();
        for(Eatery eatery: eateryList){
            eateryIdList.add(eatery.getId());
        }
        return eateryIdList;
    }

    @Override
    public List<String> getAllEateryLocationList() {
        List<Eatery> eateryList = eateryDAO.getAllEateryList();
        List<String> eateryLocationList = new ArrayList<>();
        for(Eatery eatery : eateryList){
            eateryLocationList.add(eatery.getEateryLocation());
        }
        return eateryLocationList;
    }
}
