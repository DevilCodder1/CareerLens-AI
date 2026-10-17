package com.careerlens.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "career_profiles")
public class CareerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String education;

    private Double cgpa;

    private String skills;

    private String interests;

    private String preferredRole;

    private String careerGoal;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    public CareerProfile() {
    }

    public CareerProfile(
            String education,
            Double cgpa,
            String skills,
            String interests,
            String preferredRole,
            String careerGoal,
            User user) {

        this.education = education;
        this.cgpa = cgpa;
        this.skills = skills;
        this.interests = interests;
        this.preferredRole = preferredRole;
        this.careerGoal = careerGoal;
        this.user = user;
    }

    public Long getId() {
        return id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}