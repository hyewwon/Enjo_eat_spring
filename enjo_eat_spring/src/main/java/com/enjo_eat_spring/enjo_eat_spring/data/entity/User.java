package com.enjo_eat_spring.enjo_eat_spring.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "user")
public class User extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userid", unique = true)
    private String userid;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false )
    private String password;

    @OneToMany(mappedBy = "user")
    private List<EateryGroup> groups = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Eatery> eateries = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Reply> replies = new ArrayList<>();

}
