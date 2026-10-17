package com.careerlens.controller;

import com.careerlens.dto.CareerMatchDTO;
import com.careerlens.service.CareerRecommendationService;
import org.springframework.web.bind.annotation.*;
import com.careerlens.dto.SkillGapDTO;
import com.careerlens.dto.LearningRoadmapDTO;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class CareerRecommendationController {

    private final CareerRecommendationService careerRecommendationService;

    public CareerRecommendationController(
            CareerRecommendationService careerRecommendationService) {

        this.careerRecommendationService = careerRecommendationService;
    }

    @GetMapping("/{userId}")
    public List<CareerMatchDTO> getRecommendations(
            @PathVariable Long userId) {

        return careerRecommendationService.recommendCareers(userId);
    }
    @GetMapping("/{userId}/skill-gap/{careerName}")
    public SkillGapDTO getSkillGap(
            @PathVariable Long userId,
            @PathVariable String careerName) {

        return careerRecommendationService.getSkillGap(userId, careerName);
    }
    @GetMapping("/{userId}/roadmap/{careerName}")
    public LearningRoadmapDTO getLearningRoadmap(
            @PathVariable Long userId,
            @PathVariable String careerName) {

        return careerRecommendationService.getLearningRoadmap(userId, careerName);
    }
}