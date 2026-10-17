package com.careerlens.dto;

import java.util.List;

public class CareerDetailsDTO {

    private String careerName;
    private String description;
    private List<String> requiredSkills;
    private List<String> relatedInterests;

    public CareerDetailsDTO(
            String careerName,
            String description,
            List<String> requiredSkills,
            List<String> relatedInterests) {

        this.careerName = careerName;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.relatedInterests = relatedInterests;
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
}