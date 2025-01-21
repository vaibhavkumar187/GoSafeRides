package com.vvcoders.project.gosaferides.goSafeRides.services;

import com.vvcoders.project.gosaferides.goSafeRides.dto.DriverDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.RiderDTO;

public interface RatingService {

    RiderDTO rateRider(Long rideId, Integer rating);
    DriverDTO rateDriver(Long rideId, Integer rating);
}
