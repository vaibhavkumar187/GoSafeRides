package com.vvcoders.project.gosaferides.goSafeRides.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiderDTO {

    private Long id;
    private UserDTO user;
    private Double rating;
}
