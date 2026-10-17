package com.careerlens.model;

import java.util.List;
import java.util.Map;

public class CareerOption {

    private String careerName;
    private String description;
    private List<String> requiredSkills;
    private List<String> relatedInterests;
    private Map<String, Integer> skillWeights;
    private Map<String, Integer> interestWeights;

    public CareerOption(
            String careerName,
            String description,
            List<String> requiredSkills,
            List<String> relatedInterests,
            Map<String, Integer> skillWeights,
            Map<String, Integer> interestWeights) {

        this.careerName = careerName;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.relatedInterests = relatedInterests;
        this.skillWeights = skillWeights;
        this.interestWeights = interestWeights;
    }
    public Map<String, Integer> getSkillWeights() {
        return skillWeights;
    }

    public String getCareerName() {
        return careerName;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public List<String> getRelatedInterests() {
        return relatedInterests;
    }
    public Map<String, Integer> getInterestWeights() {
        return interestWeights;
    }
}