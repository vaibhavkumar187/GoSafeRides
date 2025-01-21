package com.vvcoders.project.gosaferides.goSafeRides.services.impl;

import com.vvcoders.project.gosaferides.goSafeRides.dto.DriverDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.RiderDTO;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Driver;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Ride;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Rider;
import com.vvcoders.project.gosaferides.goSafeRides.repositories.DriverRepository;
import com.vvcoders.project.gosaferides.goSafeRides.repositories.RiderRepository;
import com.vvcoders.project.gosaferides.goSafeRides.services.RatingService;
import com.vvcoders.project.gosaferides.goSafeRides.services.RideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RiderRepository riderRepository;
    private final DriverRepository driverRepository;
    private final RideService rideService;
    private final ModelMapper modelMapper;

    @Override
    public RiderDTO rateRider(Long rideId, Integer rating) {
        Ride ride = rideService.getRideById(rideId);
        Rider currentRider= ride.getRider();
        if(Objects.isNull(currentRider)){
            throw new RuntimeException("No rider assigned with this ride");
        }

        double riderRating = currentRider.getRating();
        int riderRideCount = rideService.getCountOfRidesForRider(currentRider)-1;

        Rider savedRider = updateRiderRating(currentRider, riderRating, riderRideCount, rating);
        return modelMapper.map(savedRider, RiderDTO.class);
    }

    @Override
    public DriverDTO rateDriver(Long rideId, Integer rating) {
        Ride ride = rideService.getRideById(rideId);
        Driver currentDriver= ride.getDriver();
        if(Objects.isNull(currentDriver)){
            throw new RuntimeException("No driver assigned with this ride");
        }

        double driverRating = currentDriver.getRating();
        int driverRideCount = rideService.getCountOfRidesForDriver(currentDriver)-1;

        Driver savedDriver = updateDriverRating(currentDriver, driverRating, driverRideCount, rating);
        return modelMapper.map(savedDriver, DriverDTO.class);
    }

    public Driver updateDriverRating(Driver driver, Double allTimeRating, Integer noOfRides, Integer currentRating) {
        double driverNewRating = (allTimeRating*noOfRides+currentRating)/(noOfRides+1);
        driver.setRating(driverNewRating);
        return driverRepository.save(driver);
    }

    public Rider updateRiderRating(Rider rider, Double allTimeRating, Integer noOfRides, Integer currentRating) {
        double riderNewRating = (allTimeRating*noOfRides+currentRating)/(noOfRides+1);
        rider.setRating(riderNewRating);
        return riderRepository.save(rider);
    }
}
