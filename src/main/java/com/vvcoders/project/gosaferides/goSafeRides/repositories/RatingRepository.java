package com.vvcoders.project.gosaferides.goSafeRides.repositories;

import com.vvcoders.project.gosaferides.goSafeRides.entities.Driver;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Rating;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Ride;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface RatingRepository  extends JpaRepository<Rating, Long> {

    List<Rating> findByDriver(Driver driver);
    List<Rating> findByRider(Rider rider);

    Optional<Rating> findByRide(Ride ride);
}
