package com.careerlens.dto;

import java.util.List;

public class CareerRecommendationResponseDTO {

    private String recommendedCareer;
    private int matchScore;
    private List<String> matchedSkills;
    private List<String> missingSkills;

    public CareerRecommendationResponseDTO(
            String recommendedCareer,
            int matchScore,
            List<String> matchedSkills,
            List<String> missingSkills) {

        this.recommendedCareer = recommendedCareer;
        this.matchScore = matchScore;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
    }

    public String getRecommendedCareer() {
        return recommendedCareer;
    }

    public int getMatchScore() {
        return matchScore;
    }

    public List<String> getMatchedSkills() {
        return matchedSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }
}