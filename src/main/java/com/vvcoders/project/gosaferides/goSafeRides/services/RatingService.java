package com.vvcoders.project.gosaferides.goSafeRides.services;

import com.vvcoders.project.gosaferides.goSafeRides.dto.DriverDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.RiderDTO;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Ride;

public interface RatingService {

    RiderDTO rateRider(Ride ride, Integer rating);
    DriverDTO rateDriver(Ride ride, Integer rating);
    void createNewRating(Ride ride);
}
