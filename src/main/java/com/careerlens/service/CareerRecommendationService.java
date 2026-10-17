package com.careerlens.service;

import com.careerlens.dto.CareerMatchDTO;
import com.careerlens.entity.CareerProfile;
import com.careerlens.model.CareerOption;
import com.careerlens.repository.CareerProfileRepository;
import org.springframework.stereotype.Service;
import com.careerlens.dto.SkillGapDTO;
import com.careerlens.dto.LearningRoadmapDTO;
import com.careerlens.dto.RoadmapItemDTO;
import com.careerlens.service.CareerDataService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class CareerRecommendationService {

    private final CareerProfileRepository careerProfileRepository;
    private final CareerDataService careerDataService;
    public CareerRecommendationService(
            CareerProfileRepository careerProfileRepository,
            CareerDataService careerDataService) {

        this.careerProfileRepository = careerProfileRepository;
        this.careerDataService = careerDataService;
    }

    public List<CareerMatchDTO> recommendCareers(Long userId) {

        CareerProfile profile = careerProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Career profile not found"));

        String userSkills = profile.getSkills().toLowerCase();
        String userInterests = profile.getInterests().toLowerCase();
        String preferredRole = profile.getPreferredRole().toLowerCase();

        List<CareerOption> careers = careerDataService.getCareerOptions();

        List<CareerMatchDTO> recommendations = new ArrayList<>();

        for (CareerOption career : careers) {

            // ---------------- SKILL SCORE ----------------
            List<String> matchedSkills = new ArrayList<>();
            List<String> missingSkills = new ArrayList<>();

            for (String requiredSkill : career.getRequiredSkills()) {

                if (hasSkill(userSkills, requiredSkill)) {
                    matchedSkills.add(requiredSkill);
                } else {
                    missingSkills.add(requiredSkill);
                }
            }

            int skillScore = 0;

            for (String matchedSkill : matchedSkills) {
                skillScore += career.getSkillWeights()
                        .getOrDefault(matchedSkill.toLowerCase(), 0);
            }

            // ---------------- INTEREST SCORE ----------------
// ---------------- INTEREST SCORE ----------------
            int interestScore = 0;

            for (String interest : career.getRelatedInterests()) {
                if (userInterests.contains(interest.toLowerCase())) {
                    interestScore += career.getInterestWeights()
                            .getOrDefault(interest.toLowerCase(), 0);
                }
            }

            // ---------------- ROLE SCORE ----------------
            int roleScore = 0;

            if (preferredRole.contains(career.getCareerName().toLowerCase())
                    || career.getCareerName().toLowerCase().contains(preferredRole)) {

                roleScore = 100;
            }

            // ---------------- FINAL SCORE ----------------
            int matchScore =
                    (skillScore * 60
                            + interestScore * 20
                            + roleScore * 20) / 100;

            recommendations.add(
                    new CareerMatchDTO(
                            career.getCareerName(),
                            matchScore,
                            skillScore,
                            interestScore,
                            roleScore,
                            matchedSkills,
                            missingSkills
                    )
            );
        }

        recommendations.sort(
                Comparator.comparingInt(CareerMatchDTO::getMatchScore)
                        .reversed()
        );

        return recommendations;
    }
    public SkillGapDTO getSkillGap(Long userId, String careerName) {



        CareerProfile profile = careerProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Career profile not found"));

        CareerOption selectedCareer = careerDataService.getCareerOptions()
                .stream()
                .filter(career ->
                        career.getCareerName().equalsIgnoreCase(careerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Career not found"));

        String userSkills = profile.getSkills().toLowerCase();


        List<String> currentSkills = new ArrayList<>();
        List<String> missingSkills = new ArrayList<>();

        for (String requiredSkill : selectedCareer.getRequiredSkills()) {

            if (hasSkill(userSkills, requiredSkill)) {
                currentSkills.add(requiredSkill);
            } else {
                missingSkills.add(requiredSkill);
            }
        }

        return new SkillGapDTO(
                selectedCareer.getCareerName(),
                currentSkills,
                missingSkills,
                missingSkills.size()
        );
    }
    public LearningRoadmapDTO getLearningRoadmap(Long userId, String careerName) {

        SkillGapDTO skillGap = getSkillGap(userId, careerName);

        List<RoadmapItemDTO> roadmap = new ArrayList<>();

        int priority = 1;

        for (String skill : skillGap.getMissingSkills()) {

            String reason;

            switch (skill.toLowerCase()) {

                case "rest api":
                    reason = "Essential for building and integrating backend APIs";
                    break;

                case "spring security":
                    reason = "Important for authentication and authorization";
                    break;

                case "docker":
                    reason = "Useful for application deployment and containerization";
                    break;

                case "javascript":
                    reason = "Required for frontend development and web applications";
                    break;

                case "html":
                    reason = "Foundation of web page structure";
                    break;

                case "css":
                    reason = "Used for styling and responsive web interfaces";
                    break;

                case "react":
                    reason = "Popular library for building modern frontend applications";
                    break;

                case "python":
                    reason = "Widely used for data analysis, automation and machine learning";
                    break;

                case "sql":
                    reason = "Essential for working with relational databases";
                    break;

                case "statistics":
                    reason = "Important for data analysis and machine learning";
                    break;

                case "linux":
                    reason = "Important for servers, cloud and DevOps environments";
                    break;

                case "kubernetes":
                    reason = "Used for container orchestration and scalable deployments";
                    break;

                case "jenkins":
                    reason = "Used for continuous integration and continuous delivery";
                    break;

                case "aws":
                    reason = "Important cloud platform skill for modern deployments";
                    break;

                default:
                    reason = "Important skill for this career path";
            }

            roadmap.add(
                    new RoadmapItemDTO(
                            skill,
                            priority,
                            reason
                    )
            );

            priority++;
        }

        return new LearningRoadmapDTO(
                skillGap.getCareerName(),
                roadmap
        );
    }

    private boolean hasSkill(String userSkills, String requiredSkill) {

        String[] skills = userSkills
                .toLowerCase()
                .split(",");

        for (String skill : skills) {

            if (skill.trim().equals(requiredSkill.toLowerCase().trim())) {
                return true;
            }
        }

        return false;
    }
}