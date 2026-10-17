package com.careerlens.service;

import com.careerlens.dto.CareerProfileRequestDTO;
import com.careerlens.dto.CareerProfileResponseDTO;
import com.careerlens.entity.CareerProfile;
import com.careerlens.entity.User;
import com.careerlens.repository.CareerProfileRepository;
import com.careerlens.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CareerProfileService {

    private final CareerProfileRepository careerProfileRepository;
    private final UserRepository userRepository;

    public CareerProfileService(
            CareerProfileRepository careerProfileRepository,
            UserRepository userRepository) {

        this.careerProfileRepository = careerProfileRepository;
        this.userRepository = userRepository;
    }

    public CareerProfileResponseDTO createProfile(
            Long userId,
            CareerProfileRequestDTO request) {

        if (careerProfileRepository.existsByUserId(userId)) {
            throw new IllegalArgumentException(
                    "Career profile already exists for this user"
            );
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new IllegalArgumentException("User not found")
                );

        CareerProfile profile = new CareerProfile(
                request.getEducation(),
                request.getCgpa(),
                request.getSkills(),
                request.getInterests(),
                request.getPreferredRole(),
                request.getCareerGoal(),
                user
        );

        CareerProfile savedProfile =
                careerProfileRepository.save(profile);

        return convertToResponse(savedProfile);
    }

    public CareerProfileResponseDTO getProfileByUserId(Long userId) {

        CareerProfile profile =
                careerProfileRepository.findByUserId(userId)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Career profile not found"
                                )
                        );

        return convertToResponse(profile);
    }

    private CareerProfileResponseDTO convertToResponse(
            CareerProfile profile) {

        return new CareerProfileResponseDTO(
                profile.getId(),
                profile.getUser().getId(),
                profile.getEducation(),
                profile.getCgpa(),
                profile.getSkills(),
                profile.getInterests(),
                profile.getPreferredRole(),
                profile.getCareerGoal()
        );
    }
}