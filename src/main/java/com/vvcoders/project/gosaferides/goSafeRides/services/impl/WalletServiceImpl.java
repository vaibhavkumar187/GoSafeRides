package com.vvcoders.project.gosaferides.goSafeRides.services.impl;

import com.vvcoders.project.gosaferides.goSafeRides.entities.Ride;
import com.vvcoders.project.gosaferides.goSafeRides.entities.User;
import com.vvcoders.project.gosaferides.goSafeRides.entities.Wallet;
import com.vvcoders.project.gosaferides.goSafeRides.entities.WalletTransaction;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.TransactionMethod;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.TransactionType;
import com.vvcoders.project.gosaferides.goSafeRides.exceptions.ResourceNotFoundException;
import com.vvcoders.project.gosaferides.goSafeRides.repositories.WalletRepository;
import com.vvcoders.project.gosaferides.goSafeRides.services.WalletService;
import com.vvcoders.project.gosaferides.goSafeRides.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final WalletTransactionService walletTransactionService;

    @Override
    @Transactional
    public Wallet addMoneyToWallet(User user, Ride ride, Double amount, String transactionId, TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setWalletBalance(wallet.getWalletBalance()+amount);

        WalletTransaction walletTransaction = new WalletTransaction();
        walletTransaction.setTransactionId(transactionId);
        walletTransaction.setWallet(wallet);
        walletTransaction.setTransactionMethod(transactionMethod);
        walletTransaction.setTransactionType(TransactionType.CREDIT);
        walletTransaction.setAmount(amount);
        walletTransaction.setRide(ride);

        walletTransactionService.createNewWalletTransaction(walletTransaction);
        return walletRepository.save(wallet);
    }

    @Override
    @Transactional
    public Wallet deductMoneyFromWallet(User user, Ride ride, Double amount, String transactionId, TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setWalletBalance(wallet.getWalletBalance()-amount);

        WalletTransaction walletTransaction = new WalletTransaction();
        walletTransaction.setTransactionId(transactionId);
        walletTransaction.setWallet(wallet);
        walletTransaction.setTransactionMethod(transactionMethod);
        walletTransaction.setTransactionType(TransactionType.DEBIT);
        walletTransaction.setAmount(amount);
        walletTransaction.setRide(ride);

        walletTransactionService.createNewWalletTransaction(walletTransaction);
        return walletRepository.save(wallet);
    }

    @Override
    public void withdrawAllMyMoneyFromWallet() {

    }

    @Override
    public Wallet findById(Long walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(()-> new ResourceNotFoundException("Wallet not found with id: "+walletId));
    }

    @Override
    public Wallet createNewWallet(User user) {
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet findByUser(User user) {
        return walletRepository.findByUser(user)
                .orElseThrow(()-> new ResourceNotFoundException("Wallet not found for user with id: "+user.getId()));
    }

}
