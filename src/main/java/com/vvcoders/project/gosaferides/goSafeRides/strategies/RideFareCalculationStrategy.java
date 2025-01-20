package com.vvcoders.project.gosaferides.goSafeRides.strategies;

import com.vvcoders.project.gosaferides.goSafeRides.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double calculateFare(RideRequest rideRequest);

}
