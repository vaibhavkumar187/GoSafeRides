package com.vvcoders.project.gosaferides.goSafeRides.services.impl;

import com.vvcoders.project.gosaferides.goSafeRides.dto.DriverDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.RiderDTO;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Driver;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Rating;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Ride;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Rider;
import com.vvcoders.project.gosaferides.goSafeRides.exceptions.ResourceNotFoundException;
import com.vvcoders.project.gosaferides.goSafeRides.exceptions.RuntimeConflictException;
import com.vvcoders.project.gosaferides.goSafeRides.repositories.DriverRepository;
import com.vvcoders.project.gosaferides.goSafeRides.repositories.RatingRepository;
import com.vvcoders.project.gosaferides.goSafeRides.repositories.RiderRepository;
import com.vvcoders.project.gosaferides.goSafeRides.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final DriverRepository driverRepository;
    private final RiderRepository riderRepository;
    private final ModelMapper modelMapper;

    @Override
    public RiderDTO rateRider(Ride ride, Integer rating) {
        Rider rider = ride.getRider();
        Rating ratingObj= ratingRepository.findByRide(ride)
                .orElseThrow(()-> new ResourceNotFoundException("Rating not found for ride id: "+ ride.getId()));

        if(ratingObj.getRiderRating()!=null)
            throw new RuntimeConflictException("Rider has already been rated!");

        ratingObj.setRiderRating(rating);
        ratingRepository.save(ratingObj);

        Double newRating= ratingRepository.findByRider(rider)
                .stream().mapToDouble(r -> r.getRiderRating())
                .average().orElse(0.0);

        rider.setRating(newRating);
        return modelMapper.map(riderRepository.save(rider), RiderDTO.class);
    }

    @Override
    public DriverDTO rateDriver(Ride ride, Integer rating) {
        Driver driver= ride.getDriver();
        Rating ratingObj= ratingRepository.findByRide(ride)
                .orElseThrow(()-> new ResourceNotFoundException("Rating not found for ride id: "+ ride.getId()));

        if(ratingObj.getDriverRating()!=null)
            throw new RuntimeConflictException("Driver has already been rated!");

        ratingObj.setDriverRating(rating);
        ratingRepository.save(ratingObj);

        Double newRating= ratingRepository.findByDriver(driver)
                .stream().mapToDouble(r -> r.getDriverRating())
                .average().orElse(0.0);

        driver.setRating(newRating);
        return modelMapper.map(driverRepository.save(driver), DriverDTO.class);
    }

    @Override
    public void createNewRating(Ride ride) {

        Rating rating = Rating.builder()
                .rider(ride.getRider())
                .driver(ride.getDriver())
                .ride(ride)
                .build();

        ratingRepository.save(rating);
    }
}
