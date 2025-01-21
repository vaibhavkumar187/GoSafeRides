package com.vvcoders.project.gosaferides.goSafeRides.services.impl;

import com.vvcoders.project.gosaferides.goSafeRides.dto.RideRequestDTO;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Driver;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Ride;
import com.vvcoders.project.gosaferides.goSafeRides.entities.RideRequest;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Rider;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.RideRequestStatus;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.RideStatus;
import com.vvcoders.project.gosaferides.goSafeRides.exceptions.ResourceNotFoundException;
import com.vvcoders.project.gosaferides.goSafeRides.repositories.RideRepository;
import com.vvcoders.project.gosaferides.goSafeRides.services.RideRequestService;
import com.vvcoders.project.gosaferides.goSafeRides.services.RideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {

    private final ModelMapper modelMapper;
    private final RideRepository rideRepository;
    private final RideRequestService rideRequestService;


    @Override
    public Ride getRideById(Long rideId) {
        return rideRepository.findById(rideId).orElseThrow(()-> new ResourceNotFoundException("Ride not found with id: "+rideId));
    }


    @Override
    public Ride createNewRide(RideRequest rideRequest, Driver driver) {
        rideRequest.setRideRequestStatus(RideRequestStatus.CONFIRMED);
        Ride ride = modelMapper.map(rideRequest, Ride.class);
        ride.setId(null);
        ride.setDriver(driver);
        ride.setRideStatus(RideStatus.CONFIRMED);
        ride.setOtp(generateOtp());

        rideRequestService.update(rideRequest);
        return rideRepository.save(ride);
    }

    @Override
    public Ride updateRideStatus(Ride ride, RideStatus rideStatus) {
        ride.setRideStatus(rideStatus);
        return rideRepository.save(ride);
    }

    @Override
    public Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest) {
        return rideRepository.findByRider(rider, pageRequest);
    }

    @Override
    public Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest) {
        return rideRepository.findByDriver(driver, pageRequest);
    }

    @Override
    public int getCountOfRidesForDriver(Driver currentDriver) {
        return rideRepository.countByDriver(currentDriver);
    }

    @Override
    public int getCountOfRidesForRider(Rider currentRider) {
        return rideRepository.countByRider(currentRider);
    }

    private String generateOtp() {
        Random random = new Random();
        int otpInt = random.nextInt(10000);
        return String.format("%04d",otpInt);
    }
}
