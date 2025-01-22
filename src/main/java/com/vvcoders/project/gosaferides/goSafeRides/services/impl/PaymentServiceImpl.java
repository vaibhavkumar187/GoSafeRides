package com.vvcoders.project.gosaferides.goSafeRides.services.impl;

import com.vvcoders.project.gosaferides.goSafeRides.entities.Payment;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Ride;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.PaymentStatus;
import com.vvcoders.project.gosaferides.goSafeRides.exceptions.ResourceNotFoundException;
import com.vvcoders.project.gosaferides.goSafeRides.repositories.PaymentRepository;
import com.vvcoders.project.gosaferides.goSafeRides.services.PaymentService;
import com.vvcoders.project.gosaferides.goSafeRides.strategies.PaymentStrategyManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentStrategyManager paymentStrategyManager;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Ride ride) {
        Payment payment = paymentRepository.findByRide(ride).orElseThrow(()-> new ResourceNotFoundException("Paynment not associate with this ride id: "+ride.getId()));
        paymentStrategyManager.paymentStrategy(payment.getPaymentMethod()).processPayment(payment);
    }

    @Override
    public Payment createNewPayment(Ride ride) {
        Payment payment= Payment.builder()
                .paymentMethod(ride.getPaymentMethod())
                .ride(ride)
                .paymentStatus(PaymentStatus.PENDING)
                .amount(ride.getRideFare())
                .build();
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePaymentStatus(Payment payment, PaymentStatus paymentStatus) {
        payment.setPaymentStatus(paymentStatus);
        return paymentRepository.save(payment);
    }
}
