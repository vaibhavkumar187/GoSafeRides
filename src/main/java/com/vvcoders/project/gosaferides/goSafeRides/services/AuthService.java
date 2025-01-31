package com.vvcoders.project.gosaferides.goSafeRides.services;

import com.vvcoders.project.gosaferides.goSafeRides.dto.DriverDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.SignUpDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.UserDTO;

public interface AuthService {

    String[] login(String email, String password);

    UserDTO signup(SignUpDTO signUpDTO);

    DriverDTO onboardNewDriver(Long userId, String vehicleId);

}
