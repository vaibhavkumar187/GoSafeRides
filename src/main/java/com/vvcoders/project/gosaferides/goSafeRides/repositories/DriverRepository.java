package com.vvcoders.project.gosaferides.goSafeRides.repositories;

import com.vvcoders.project.gosaferides.goSafeRides.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
