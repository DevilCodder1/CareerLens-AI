package com.careerlens.dto;

public class CareerProfileResponseDTO {

    private Long id;
    private Long userId;
    private String education;
    private Double cgpa;
    private String skills;
    private String interests;
    private String preferredRole;
    private String careerGoal;

    public CareerProfileResponseDTO() {
    }

    public CareerProfileResponseDTO(
            Long id,
            Long userId,
            String education,
            Double cgpa,
            String skills,
            String interests,
            String preferredRole,
            String careerGoal) {

        this.id = id;
        this.userId = userId;
        this.education = education;
        this.cgpa = cgpa;
        this.skills = skills;
        this.interests = interests;
        this.preferredRole = preferredRole;
        this.careerGoal = careerGoal;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEducation() {
        return education;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public String getSkills() {
        return skills;
    }

    public String getInterests() {
        return interests;
    }

    public String getPreferredRole() {
        return preferredRole;
    }

    public String getCareerGoal() {
        return careerGoal;
    }
}