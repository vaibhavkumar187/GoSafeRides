package com.vvcoders.project.gosaferides.goSafeRides.dto;

import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.TransactionMethod;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.TransactionType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WalletTransactionDTO {

    private Long id;

    private Double amount;

    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    private RideDTO ride;

    private String transactionId;

    private LocalDateTime transactionTime;

    private WalletDTO wallet;


}
