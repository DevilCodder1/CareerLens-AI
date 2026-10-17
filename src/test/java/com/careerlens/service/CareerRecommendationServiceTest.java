
package com.careerlens.service;

import com.careerlens.dto.CareerMatchDTO;
import com.careerlens.entity.CareerProfile;
import com.careerlens.repository.CareerProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CareerRecommendationServiceTest {

    @Mock
    private CareerProfileRepository careerProfileRepository;

    private CareerDataService careerDataService;
    private CareerRecommendationService careerRecommendationService;

    private CareerProfile profile;

    @BeforeEach
    void setUp() {
        careerDataService = new CareerDataService();

        careerRecommendationService =
                new CareerRecommendationService(
                        careerProfileRepository,
                        careerDataService
                );

        profile = new CareerProfile();
        profile.setSkills("Java, Spring Boot, SQL, Git");
        profile.setInterests(
                "Backend Development, Software Engineering, Web Development"
        );
        profile.setPreferredRole("Java Backend Developer");

    }

    @Test
    void shouldThrowExceptionWhenCareerProfileDoesNotExist() {
        when(careerProfileRepository.findByUserId(99L))
                .thenReturn(Optional.empty());

        assertThrows(
                IllegalArgumentException.class,
                () -> careerRecommendationService.recommendCareers(99L)
        );
    }


    @Test
    void shouldReturnRecommendationsInDescendingScoreOrder() {

        when(careerProfileRepository.findByUserId(1L))
                .thenReturn(Optional.of(profile));

        List<CareerMatchDTO> recommendations =
                careerRecommendationService.recommendCareers(1L);

        assertNotNull(recommendations);
        assertFalse(recommendations.isEmpty());

        for (int i = 0; i < recommendations.size() - 1; i++) {
            assertTrue(
                    recommendations.get(i).getMatchScore()
                            >= recommendations.get(i + 1).getMatchScore()
            );
        }
    }



    @Test
    void shouldRecommendPreferredCareerHighly() {

        when(careerProfileRepository.findByUserId(1L))
                .thenReturn(Optional.of(profile));

        List<CareerMatchDTO> recommendations =
                careerRecommendationService.recommendCareers(1L);

        assertEquals(
                "Java Backend Developer",
                recommendations.get(0).getCareerName()
        );
    }

    @Test
    void shouldReturnCorrectSkillGap() {

        when(careerProfileRepository.findByUserId(1L))
                .thenReturn(Optional.of(profile));

        var skillGap = careerRecommendationService.getSkillGap(
                1L, "Java Backend Developer"
        );

        assertNotNull(skillGap);
        assertEquals("Java Backend Developer", skillGap.getCareerName());
        assertNotNull(skillGap.getCurrentSkills());
        assertNotNull(skillGap.getMissingSkills());

        assertEquals(
                skillGap.getMissingSkills().size(),
                skillGap.getSkillGapCount()
        );
    }

    @Test
    void shouldThrowExceptionForUnknownCareer() {

        when(careerProfileRepository.findByUserId(1L))
                .thenReturn(Optional.of(profile));

        assertThrows(
                IllegalArgumentException.class,
                () -> careerRecommendationService.getSkillGap(
                        1L, "Unknown Career"
                )
        );
    }

    @Test
    void shouldGenerateRoadmapForMissingSkills() {

        when(careerProfileRepository.findByUserId(1L))
                .thenReturn(Optional.of(profile));

        var roadmap = careerRecommendationService.getLearningRoadmap(
                1L, "Java Backend Developer"
        );

        assertNotNull(roadmap);
        assertEquals("Java Backend Developer", roadmap.getCareerName());
        assertNotNull(roadmap.getRoadmap());
        assertFalse(roadmap.getRoadmap().isEmpty());
    }

    @Test
    void shouldAssignRoadmapPrioritiesInAscendingOrder() {

        when(careerProfileRepository.findByUserId(1L))
                .thenReturn(Optional.of(profile));

        var roadmap = careerRecommendationService.getLearningRoadmap(
                1L, "Java Backend Developer"
        );

        var items = roadmap.getRoadmap();

        for (int i = 0; i < items.size(); i++) {
            assertEquals(i + 1, items.get(i).getPriority());
        }
    }

    @Test
    void shouldReturnEmptyRoadmapWhenNoSkillsAreMissing() {

        profile.setSkills(
                "Java, Spring Boot, SQL, Git, REST API, Spring Security, Docker"
        );

        when(careerProfileRepository.findByUserId(1L))
                .thenReturn(Optional.of(profile));

        var roadmap = careerRecommendationService.getLearningRoadmap(
                1L, "Java Backend Developer"
        );

        assertNotNull(roadmap);
        assertTrue(roadmap.getRoadmap().isEmpty());
    }

    @Test
    void shouldIncludeLearningReasonsForRoadmapItems() {

        when(careerProfileRepository.findByUserId(1L))
                .thenReturn(Optional.of(profile));

        var roadmap = careerRecommendationService.getLearningRoadmap(
                1L, "Java Backend Developer"
        );

        for (var item : roadmap.getRoadmap()) {
            assertNotNull(item.getReason());
            assertFalse(item.getReason().isBlank());
        }
    }

}
