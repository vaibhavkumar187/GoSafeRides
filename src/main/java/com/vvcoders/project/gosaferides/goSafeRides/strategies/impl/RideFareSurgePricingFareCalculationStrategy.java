package com.vvcoders.project.gosaferides.goSafeRides.strategies.impl;

import com.vvcoders.project.gosaferides.goSafeRides.entities.RideRequest;
import com.vvcoders.project.gosaferides.goSafeRides.services.DistanceService;
import com.vvcoders.project.gosaferides.goSafeRides.strategies.RideFareCalculationStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        return distanceService.calculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropOffLocation()) * RIDE_FARE_MULTIPLIER * SURGE_CHARGE;
    }
}
