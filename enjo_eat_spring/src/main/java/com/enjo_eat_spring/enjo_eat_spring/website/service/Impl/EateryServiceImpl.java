package com.enjo_eat_spring.enjo_eat_spring.website.service.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.AuthDAO;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.EateryDAO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EateryServiceImpl implements EateryService {
    EateryDAO eateryDAO;
    AuthDAO authDAO;

    @Autowired
    public EateryServiceImpl(EateryDAO eateryDAO, AuthDAO authDAO){
        this.eateryDAO = eateryDAO;
        this.authDAO = authDAO;
    }

    @Override
    public List<EateryGroupDTO.ResponseDTO> getGroupList() {
        List<EateryGroup> eateryGroupList = eateryDAO.getGroupList();
        List<EateryGroupDTO.ResponseDTO> eateryGroupDTOList = new ArrayList<>();
        for(EateryGroup group : eateryGroupList){
            EateryGroupDTO.ResponseDTO groupDTO =EateryGroupDTO.ResponseDTO.builder()
                    .groupName(group.getGroupName())
                    .groupComment(group.getGroupComment())
                    .groupLocation(group.getGroupLocation())
                    .build();

            eateryGroupDTOList.add(groupDTO);
        }
        return eateryGroupDTOList;
    }

    @Override
    public Long createGroup(EateryGroupDTO.CreateRequestDTO createRequestDTO, String username) {
        User user = authDAO.getUser(username);
        createRequestDTO.setUser(user);
        EateryGroup eateryGroup = createRequestDTO.toEntity();
        Long eateryId = eateryDAO.createGroup(eateryGroup);
        return eateryId;
    }
}
