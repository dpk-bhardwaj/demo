package com.deepak.repository;

import com.deepak.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository 
        extends JpaRepository<Color, Integer> {
}
