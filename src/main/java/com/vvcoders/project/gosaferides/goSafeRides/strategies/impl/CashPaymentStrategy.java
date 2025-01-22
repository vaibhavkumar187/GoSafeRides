package com.vvcoders.project.gosaferides.goSafeRides.strategies.impl;

import com.vvcoders.project.gosaferides.goSafeRides.entities.Driver;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Payment;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.PaymentStatus;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.TransactionMethod;
import com.vvcoders.project.gosaferides.goSafeRides.repositories.PaymentRepository;
import com.vvcoders.project.gosaferides.goSafeRides.services.WalletService;
import com.vvcoders.project.gosaferides.goSafeRides.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();

        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;
        walletService.deductMoneyFromWallet(driver.getUser(), payment.getRide(), platformCommission, null, TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
