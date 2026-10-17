package com.careerlens.repository;

import com.careerlens.entity.CareerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CareerProfileRepository
        extends JpaRepository<CareerProfile, Long> {

    Optional<CareerProfile> findByUserId(Long userId);

    boolean existsByUserId(Long userId);
}