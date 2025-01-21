package com.vvcoders.project.gosaferides.goSafeRides.repositories;

import com.vvcoders.project.gosaferides.goSafeRides.entities.Driver;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Ride;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Rider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
    Page<Ride> findByRider(Rider rider, PageRequest pageRequest);
    Page<Ride> findByDriver(Driver driver, PageRequest pageRequest);
    int countByRider(Rider rider);
    int countByDriver(Driver driver);
}
