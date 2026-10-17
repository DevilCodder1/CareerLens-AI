package com.careerlens.dto;

public class RoadmapItemDTO {

    private String skill;
    private int priority;
    private String reason;

    public RoadmapItemDTO(
            String skill,
            int priority,
            String reason) {

        this.skill = skill;
        this.priority = priority;
        this.reason = reason;
    }

    public String getSkill() {
        return skill;
    }

    public int getPriority() {
        return priority;
    }

    public String getReason() {
        return reason;
    }
}