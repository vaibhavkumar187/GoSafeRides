package com.vvcoders.project.gosaferides.goSafeRides.strategies;

import com.vvcoders.project.gosaferides.goSafeRides.entities.Payment;

public interface PaymentStrategy {

    double PLATFORM_COMMISSION= 0.3;
    void processPayment(Payment payment);

}
