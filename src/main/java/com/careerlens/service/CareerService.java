package com.careerlens.service;

import com.careerlens.dto.CareerDetailsDTO;
import com.careerlens.model.CareerOption;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CareerService {
    private final CareerDataService careerDataService;
    public CareerService(CareerDataService careerDataService) {
        this.careerDataService = careerDataService;
    }

    public List<CareerDetailsDTO> getAllCareers() {

        List<CareerDetailsDTO> careers = new ArrayList<>();

        for (CareerOption career : careerDataService.getCareerOptions()) {

            careers.add(
                    new CareerDetailsDTO(
                            career.getCareerName(),
                            career.getDescription(),
                            career.getRequiredSkills(),
                            career.getRelatedInterests()
                    )
            );
        }

        return careers;
    }

    public CareerDetailsDTO getCareerByName(String careerName) {

        CareerOption career = careerDataService.getCareerOptions()
                .stream()
                .filter(option ->
                        option.getCareerName().equalsIgnoreCase(careerName))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Career not found"));

        return new CareerDetailsDTO(
                career.getCareerName(),
                career.getDescription(),
                career.getRequiredSkills(),
                career.getRelatedInterests()
        );
    }


}