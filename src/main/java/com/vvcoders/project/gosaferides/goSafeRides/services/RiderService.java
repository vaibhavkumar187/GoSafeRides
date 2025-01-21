package com.vvcoders.project.gosaferides.goSafeRides.services;

import com.vvcoders.project.gosaferides.goSafeRides.dto.DriverDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.RideDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.RideRequestDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.RiderDTO;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Rider;
import com.vvcoders.project.gosaferides.goSafeRides.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RiderService {

    RideRequestDTO requestRide(RideRequestDTO rideRequestDTO);

    RideDTO cancelRide(Long rideId);

    DriverDTO rateDriver(Long rideId, Integer rating);

    RiderDTO getMyProfile();

    Page<RideDTO> getAllMyRides(PageRequest pageRequest);

    Rider createRider(User user);

    Rider getCurrentRider();

}
