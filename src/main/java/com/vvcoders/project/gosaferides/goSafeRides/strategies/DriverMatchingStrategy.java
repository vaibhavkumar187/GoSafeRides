package com.vvcoders.project.gosaferides.goSafeRides.strategies;

import com.vvcoders.project.gosaferides.goSafeRides.dto.RideRequestDTO;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Driver;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDriver(RideRequestDTO rideRequestDTO);

}
