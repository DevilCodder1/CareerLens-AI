package com.careerlens.dto;

import java.util.List;

public class CareerMatchDTO {

    private String careerName;
    private int matchScore;

    private int skillScore;
    private int interestScore;
    private int roleScore;

    private List<String> matchedSkills;
    private List<String> missingSkills;

    public CareerMatchDTO(
            String careerName,
            int matchScore,
            int skillScore,
            int interestScore,
            int roleScore,
            List<String> matchedSkills,
            List<String> missingSkills) {

        this.careerName = careerName;
        this.matchScore = matchScore;
        this.skillScore = skillScore;
        this.interestScore = interestScore;
        this.roleScore = roleScore;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
    }

    public String getCareerName() {
        return careerName;
    }

    public int getMatchScore() {
        return matchScore;
    }

    public int getSkillScore() {
        return skillScore;
    }

    public int getInterestScore() {
        return interestScore;
    }

    public int getRoleScore() {
        return roleScore;
    }

    public List<String> getMatchedSkills() {
        return matchedSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }
}