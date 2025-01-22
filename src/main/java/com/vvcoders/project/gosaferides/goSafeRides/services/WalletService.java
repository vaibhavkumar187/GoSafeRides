package com.vvcoders.project.gosaferides.goSafeRides.services;

import com.vvcoders.project.gosaferides.goSafeRides.entities.Ride;
import com.vvcoders.project.gosaferides.goSafeRides.entities.User;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Wallet;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.TransactionMethod;

public interface WalletService {

    Wallet addMoneyToWallet(User user, Ride ride, Double amount, String transactionId, TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user, Ride ride, Double amount, String transactionId, TransactionMethod transactionMethod);

    void withdrawAllMyMoneyFromWallet();

    Wallet findById(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findByUser(User user);

}
