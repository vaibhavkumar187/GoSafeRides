package com.vvcoders.project.gosaferides.goSafeRides.repositories;

import com.vvcoders.project.gosaferides.goSafeRides.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
}
