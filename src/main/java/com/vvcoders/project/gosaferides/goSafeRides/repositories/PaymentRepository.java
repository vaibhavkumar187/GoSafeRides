package com.vvcoders.project.gosaferides.goSafeRides.repositories;

import com.vvcoders.project.gosaferides.goSafeRides.entities.Payment;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByRide(Ride ride);
}
