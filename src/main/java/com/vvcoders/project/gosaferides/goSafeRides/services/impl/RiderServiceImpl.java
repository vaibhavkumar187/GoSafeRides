package com.vvcoders.project.gosaferides.goSafeRides.services.impl;


import com.vvcoders.project.gosaferides.goSafeRides.dto.DriverDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.RideDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.RideRequestDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.RiderDTO;
import com.vvcoders.project.gosaferides.goSafeRides.entities.*;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.RideRequestStatus;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.RideStatus;
import com.vvcoders.project.gosaferides.goSafeRides.exceptions.ResourceNotFoundException;
import com.vvcoders.project.gosaferides.goSafeRides.repositories.RiderRepository;
import com.vvcoders.project.gosaferides.goSafeRides.services.*;
import com.vvcoders.project.gosaferides.goSafeRides.strategies.RideStrategyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideRequestService rideRequestService;
    private final RiderRepository riderRepository;
    private final RideStrategyManager rideStrategyManager;
    private final RideService rideService;
    private final DriverService driverService;
    private final RatingService ratingService;

    @Override
    public RideRequestDTO requestRide(RideRequestDTO rideRequestDTO) {
        Rider currentRider = getCurrentRider();

        RideRequest rideRequest = modelMapper.map(rideRequestDTO, RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

        rideRequest.setRider(currentRider);

        Double fare = rideStrategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);
        rideRequest.setRideFare(fare);

        RideRequest savedRideRequest = rideRequestService.save(rideRequest);

        rideStrategyManager.driverMatchingStrategy(currentRider.getRating()).findMatchingDrivers(rideRequest);

        return modelMapper.map(savedRideRequest, RideRequestDTO.class);
    }
    @Override
    public RideDTO cancelRide(Long rideId) {
        Ride ride = rideService.getRideById(rideId);

        Rider rider = getCurrentRider();
        if(!rider.equals(ride.getRider())){
            throw new RuntimeException("Rider does not own this ride with id: "+rideId);
        }

        if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
            throw new RuntimeException("Ride status not confirmed, hence can't be cancelled."+ride.getRideStatus());
        }

        Ride savedRide= rideService.updateRideStatus(ride, RideStatus.CANCELLED);
        driverService.updateDriverAvailability(ride.getDriver(), true);
        return modelMapper.map(savedRide, RideDTO.class);
    }

    @Override
    public DriverDTO rateDriver(Long rideId, Integer rating) {
        return ratingService.rateDriver(rideId, rating);
    }

    @Override
    public RiderDTO getMyProfile() {
        Rider currentRider = getCurrentRider();
        return modelMapper.map(currentRider, RiderDTO.class);
    }

    @Override
    public Page<RideDTO> getAllMyRides(PageRequest pageRequest) {
        Rider currentRider = getCurrentRider();
        return rideService.getAllRidesOfRider(currentRider,pageRequest).map(
                ride -> modelMapper.map(ride, RideDTO.class)
        );
    }

    @Override
    public Rider createRider(User user) {
        Rider rider= Rider.builder()
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {
        return riderRepository.findById(1L).orElseThrow(()-> new ResourceNotFoundException("Rider not found with id: "+1));
    }

}
