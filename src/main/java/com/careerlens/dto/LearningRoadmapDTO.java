package com.careerlens.dto;

import java.util.List;

public class LearningRoadmapDTO {

    private String careerName;
    private List<RoadmapItemDTO> roadmap;

    public LearningRoadmapDTO(
            String careerName,
            List<RoadmapItemDTO> roadmap) {

        this.careerName = careerName;
        this.roadmap = roadmap;
    }

    public String getCareerName() {
        return careerName;
    }

    public List<RoadmapItemDTO> getRoadmap() {
        return roadmap;
    }
}