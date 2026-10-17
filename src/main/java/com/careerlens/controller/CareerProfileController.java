package com.careerlens.controller;

import com.careerlens.dto.CareerProfileRequestDTO;
import com.careerlens.dto.CareerProfileResponseDTO;
import com.careerlens.service.CareerProfileService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/career-profiles")
public class CareerProfileController {

    private final CareerProfileService careerProfileService;

    public CareerProfileController(
            CareerProfileService careerProfileService) {

        this.careerProfileService = careerProfileService;
    }

    @PostMapping("/{userId}")
    public CareerProfileResponseDTO createProfile(
            @PathVariable Long userId,
            @Valid @RequestBody CareerProfileRequestDTO request) {

        return careerProfileService.createProfile(userId, request);
    }

    @GetMapping("/{userId}")
    public CareerProfileResponseDTO getProfile(
            @PathVariable Long userId) {

        return careerProfileService.getProfileByUserId(userId);
    }
}