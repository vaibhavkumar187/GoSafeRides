package com.vvcoders.project.gosaferides.goSafeRides.dto;
import lombok.Data;

import java.util.List;

@Data
public class WalletDTO {

    private Long id;

    private UserDTO user;

    private Double walletBalance;

    private List<WalletTransactionDTO> transactions;

}
