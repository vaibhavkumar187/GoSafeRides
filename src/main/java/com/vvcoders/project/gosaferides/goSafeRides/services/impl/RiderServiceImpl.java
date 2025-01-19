package com.vvcoders.project.gosaferides.goSafeRides.services.impl;


import com.vvcoders.project.gosaferides.goSafeRides.dto.*;
import com.vvcoders.project.gosaferides.goSafeRides.entities.RideRequest;
import com.vvcoders.project.gosaferides.goSafeRides.services.RiderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;

    @Override
    public RideRequestDTO requestRide(RideRequestDTO rideRequestDTO) {

        RideRequest rideRequest = modelMapper.map(rideRequestDTO, RideRequest.class);

        System.out.println(rideRequest);

        return null;
    }
    @Override
    public RideDTO cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDTO rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDTO getMyProfile() {
        return null;
    }

    @Override
    public List<RideDTO> getAllMyRides() {
        return List.of();
    }
}
