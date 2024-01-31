package com.enjo_eat_spring.enjo_eat_spring.data.repository;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
