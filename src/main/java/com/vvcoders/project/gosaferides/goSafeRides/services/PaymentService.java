package com.vvcoders.project.gosaferides.goSafeRides.services;

import com.vvcoders.project.gosaferides.goSafeRides.entities.Payment;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Ride;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    Payment updatePaymentStatus(Payment payment, PaymentStatus paymentStatus);


}
