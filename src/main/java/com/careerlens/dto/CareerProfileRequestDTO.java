package com.careerlens.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CareerProfileRequestDTO {

    @NotBlank(message = "Education is required")
    private String education;

    @NotNull(message = "CGPA is required")
    @DecimalMin(value = "0.0", message = "CGPA cannot be less than 0")
    @DecimalMax(value = "10.0", message = "CGPA cannot be greater than 10")
    private Double cgpa;

    @NotBlank(message = "Skills are required")
    private String skills;

    @NotBlank(message = "Interests are required")
    private String interests;

    @NotBlank(message = "Preferred role is required")
    private String preferredRole;

    @NotBlank(message = "Career goal is required")
    private String careerGoal;

    public CareerProfileRequestDTO() {
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getPreferredRole() {
        return preferredRole;
    }

    public void setPreferredRole(String preferredRole) {
        this.preferredRole = preferredRole;
    }

    public String getCareerGoal() {
        return careerGoal;
    }

    public void setCareerGoal(String careerGoal) {
        this.careerGoal = careerGoal;
    }
}