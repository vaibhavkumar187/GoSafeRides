package com.vvcoders.project.gosaferides.goSafeRides.strategies.impl;

import com.vvcoders.project.gosaferides.goSafeRides.dto.RideRequestDTO;
import com.vvcoders.project.gosaferides.goSafeRides.strategies.RideFareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {


    @Override
    public double calculateFare(RideRequestDTO rideRequestDTO) {
        return 0;
    }
}
