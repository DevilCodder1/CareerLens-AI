package com.careerlens.dto;

import java.util.List;

public class SkillGapDTO {

    private String careerName;
    private List<String> currentSkills;
    private List<String> missingSkills;
    private int skillGapCount;

    public SkillGapDTO(
            String careerName,
            List<String> currentSkills,
            List<String> missingSkills,
            int skillGapCount) {

        this.careerName = careerName;
        this.currentSkills = currentSkills;
        this.missingSkills = missingSkills;
        this.skillGapCount = skillGapCount;
    }

    public String getCareerName() {
        return careerName;
    }

    public List<String> getCurrentSkills() {
        return currentSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public int getSkillGapCount() {
        return skillGapCount;
    }
}