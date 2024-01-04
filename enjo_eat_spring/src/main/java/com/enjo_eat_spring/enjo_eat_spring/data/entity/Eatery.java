package com.enjo_eat_spring.enjo_eat_spring.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "eatery")
public class Eatery extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "eatery_name")
    private String eateryName;

    @Column(name = "eatery_type")
    private String eatery_type;

    @Column(name = "eatery_real_location")
    private String eateryRealLocation;

    @Column(name = "eatery_location")
    private String eateryLocation;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "image_id")
    private Image image;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "group_id")
    private EateryGroup group;

    @OneToMany(mappedBy = "eatery")
    private List<Reply> replies = new ArrayList<>();

}
