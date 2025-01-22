package com.vvcoders.project.gosaferides.goSafeRides.strategies.impl;

import com.vvcoders.project.gosaferides.goSafeRides.entities.Driver;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Payment;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Rider;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.PaymentStatus;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.TransactionMethod;
import com.vvcoders.project.gosaferides.goSafeRides.repositories.PaymentRepository;
import com.vvcoders.project.gosaferides.goSafeRides.services.WalletService;
import com.vvcoders.project.gosaferides.goSafeRides.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(), payment.getRide(), payment.getAmount(), null, TransactionMethod.RIDE);

        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;
        double driverShare= payment.getAmount() - platformCommission;
        walletService.addMoneyToWallet(driver.getUser(), payment.getRide(), driverShare, null, TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
