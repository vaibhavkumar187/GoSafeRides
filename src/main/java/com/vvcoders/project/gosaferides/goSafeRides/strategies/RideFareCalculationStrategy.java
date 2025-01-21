package com.vvcoders.project.gosaferides.goSafeRides.strategies;

import com.vvcoders.project.gosaferides.goSafeRides.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER= 10;
    double SURGE_CHARGE= 2;
    double calculateFare(RideRequest rideRequest);

}
