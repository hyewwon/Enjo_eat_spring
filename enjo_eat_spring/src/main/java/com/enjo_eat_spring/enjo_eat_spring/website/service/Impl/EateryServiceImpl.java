package com.enjo_eat_spring.enjo_eat_spring.website.service.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.EateryDAO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EateryServiceImpl implements EateryService {
    EateryDAO eateryDAO;

    @Autowired
    public EateryServiceImpl(EateryDAO eateryDAO){
        this.eateryDAO = eateryDAO;
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
    public Long createGroup(EateryGroupDTO.CreateRequestDTO createRequestDTO) {
        EateryGroup eateryGroup = createRequestDTO.toEntity();
        Long eateryId = eateryDAO.createGroup(eateryGroup);
        return eateryId;
    }
}
