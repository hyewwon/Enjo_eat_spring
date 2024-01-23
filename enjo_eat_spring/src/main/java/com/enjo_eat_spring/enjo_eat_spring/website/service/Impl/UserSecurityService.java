package com.enjo_eat_spring.enjo_eat_spring.website.service.Impl;

import com.enjo_eat_spring.enjo_eat_spring.common.authorization.UserRole;
import com.enjo_eat_spring.enjo_eat_spring.data.dto.MyUserDetails;
import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import com.enjo_eat_spring.enjo_eat_spring.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        Optional<User> _user = this.userRepository.findByUserid(userid);
        if(_user.isEmpty()) {
            throw new UsernameNotFoundException("아이디 혹은 비밀번호가 맞지 않습니다.");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("admin".equals(userid)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }
        return new MyUserDetails(_user.get());
    }
}
