package com.vvcoders.project.gosaferides.goSafeRides.strategies;

import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.PaymentMethod;
import com.vvcoders.project.gosaferides.goSafeRides.strategies.impl.CashPaymentStrategy;
import com.vvcoders.project.gosaferides.goSafeRides.strategies.impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {

    private final WalletPaymentStrategy walletPaymentStrategy;
    private final CashPaymentStrategy cashPaymentStrategy;

    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod){
        return switch (paymentMethod){
            case WALLET -> walletPaymentStrategy;
            case CASH -> cashPaymentStrategy;
        };
    }

}
