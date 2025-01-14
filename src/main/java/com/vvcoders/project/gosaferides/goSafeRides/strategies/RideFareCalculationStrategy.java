package com.vvcoders.project.gosaferides.goSafeRides.strategies;

import com.vvcoders.project.gosaferides.goSafeRides.dto.RideRequestDTO;

public interface RideFareCalculationStrategy {

    double calculateFare(RideRequestDTO rideRequestDTO);

}
