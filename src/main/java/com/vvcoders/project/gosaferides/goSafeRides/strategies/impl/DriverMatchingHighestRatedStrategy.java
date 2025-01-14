package com.vvcoders.project.gosaferides.goSafeRides.strategies.impl;

import com.vvcoders.project.gosaferides.goSafeRides.dto.RideRequestDTO;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Driver;
import com.vvcoders.project.gosaferides.goSafeRides.strategies.DriverMatchingStrategy;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverMatchingHighestRatedStrategy implements DriverMatchingStrategy {
    @Override
    public List<Driver> findMatchingDriver(RideRequestDTO rideRequestDTO) {
        return List.of();
    }
}
