package com.vvcoders.project.gosaferides.goSafeRides.entities;

import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.TransactionMethod;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private TransactionMethod transactionMethod;

    @ManyToOne
    private Ride ride;

    private String transactionId;

    @CreationTimestamp
    private LocalDateTime transactionTime;

    @ManyToOne
    private Wallet wallet;



}
