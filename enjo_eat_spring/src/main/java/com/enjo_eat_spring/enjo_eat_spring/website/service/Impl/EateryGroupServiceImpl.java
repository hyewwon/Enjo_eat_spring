package com.enjo_eat_spring.enjo_eat_spring.website.service.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.EateryGroupDTO;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.EateryGroup;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.AuthDAO;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.EateryGroupDAO;
import com.enjo_eat_spring.enjo_eat_spring.website.service.EateryGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EateryGroupServiceImpl implements EateryGroupService {
    EateryGroupDAO eateryGroupDAO;
    AuthDAO authDAO;

    @Autowired
    public EateryGroupServiceImpl(EateryGroupDAO eateryGroupDAO, AuthDAO authDAO){
        this.eateryGroupDAO = eateryGroupDAO;
        this.authDAO = authDAO;
    }

    @Override
    public List<EateryGroupDTO.ResponseDTO> getGroupList() {
        List<EateryGroup> eateryGroupList = eateryGroupDAO.getGroupList();
        List<EateryGroupDTO.ResponseDTO> eateryGroupDTOList = new ArrayList<>();
        for(EateryGroup group : eateryGroupList){
            EateryGroupDTO.ResponseDTO groupDTO = EateryGroupDTO.ResponseDTO.builder()
                    .id(group.getId())
                    .groupName(group.getGroupName())
                    .groupComment(group.getGroupComment())
                    .groupLocation(group.getGroupLocation())
                    .openFlag(group.getOpenFlag())
                    .build();

            eateryGroupDTOList.add(groupDTO);
        }
        return eateryGroupDTOList;
    }

    @Override
    public EateryGroupDTO.ResponseDTO getGroup(Long groupId) {
        EateryGroup group = eateryGroupDAO.getGroup(groupId);
        EateryGroupDTO.ResponseDTO groupDTO = EateryGroupDTO.ResponseDTO.builder()
                .id(group.getId())
                .groupName(group.getGroupName())
                .groupComment(group.getGroupComment())
                .groupLocation(group.getGroupLocation())
                .openFlag(group.getOpenFlag())
                .user(group.getUser())
                .build();
        return groupDTO;
    }


    @Override
    public Long createGroup(EateryGroupDTO.RequestDTO requestDTO, String username) {
        User user = authDAO.getUser(username);
        requestDTO.setUser(user);
        EateryGroup eateryGroup = requestDTO.toEntity();
        return eateryGroupDAO.createGroup(eateryGroup);
    }

    @Override
    public Long updateGroup(EateryGroupDTO.RequestDTO requestDTO, Long groupId, String username) {
        User user = authDAO.getUser(username);
        requestDTO.setUser(user);
        EateryGroup eateryGroup = requestDTO.toEntity();
        return eateryGroupDAO.updateGroup(eateryGroup, groupId);
    }

    @Override
    public Boolean deleteGroup(Long groupId, String username) {
        User user = authDAO.getUser(username);
        return eateryGroupDAO.deleteGroup(groupId, user);
    }

    @Override
    public List<EateryGroupDTO.ResponseDTO> getGroupListByUser(String username) {
        User user = authDAO.getUser(username);
        List<EateryGroup> eateryGroupList = eateryGroupDAO.getGroupListByUser(user);
        List<EateryGroupDTO.ResponseDTO> eateryGroupDTOList = new ArrayList<>();
        for(EateryGroup group : eateryGroupList){
            EateryGroupDTO.ResponseDTO groupDTO = EateryGroupDTO.ResponseDTO.builder()
                    .id(group.getId())
                    .groupName(group.getGroupName())
                    .groupComment(group.getGroupComment())
                    .groupLocation(group.getGroupLocation())
                    .openFlag(group.getOpenFlag())
                    .build();

            eateryGroupDTOList.add(groupDTO);
        }
        return eateryGroupDTOList;
    }
}
