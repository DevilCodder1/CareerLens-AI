package com.careerlens.controller;

import com.careerlens.dto.CareerDetailsDTO;
import com.careerlens.service.CareerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/careers")
public class CareerController {

    private final CareerService careerService;

    public CareerController(CareerService careerService) {
        this.careerService = careerService;
    }

    @GetMapping
    public List<CareerDetailsDTO> getAllCareers() {
        return careerService.getAllCareers();
    }

    @GetMapping("/{careerName}")
    public CareerDetailsDTO getCareerByName(
            @PathVariable String careerName) {

        return careerService.getCareerByName(careerName);
    }
}