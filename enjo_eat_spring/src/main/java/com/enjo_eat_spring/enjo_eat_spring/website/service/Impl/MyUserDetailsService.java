package com.enjo_eat_spring.enjo_eat_spring.website.service.Impl;

import com.enjo_eat_spring.enjo_eat_spring.data.dto.MyUserDetails;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import com.enjo_eat_spring.enjo_eat_spring.website.dao.AuthDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    AuthDAO authDAO;

    @Autowired
    public MyUserDetailsService(AuthDAO authDAO){
        this.authDAO = authDAO;
    }
    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        User user = authDAO.loginUser(userid);
        if(user == null){
            throw new UsernameNotFoundException("해당 유저를 찾을 수 없습니다.");
        }
        return new MyUserDetails(user);
    }
}
