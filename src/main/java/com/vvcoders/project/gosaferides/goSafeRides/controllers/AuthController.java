package com.vvcoders.project.gosaferides.goSafeRides.controllers;

import com.vvcoders.project.gosaferides.goSafeRides.dto.DriverDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.OnBoardDriverDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.SignUpDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.UserDTO;
import com.vvcoders.project.gosaferides.goSafeRides.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    ResponseEntity<UserDTO> signUp(@RequestBody SignUpDTO signUpDTO){
        return new ResponseEntity<>(authService.signup(signUpDTO),HttpStatus.CREATED);
    }

    @PostMapping("/onboardNewDriver/{userId}")
    ResponseEntity<DriverDTO> onboardNewDriver(@PathVariable Long userId, @RequestBody OnBoardDriverDTO onBoardDriverDTO){
        return new ResponseEntity<>(authService.onboardNewDriver(userId, onBoardDriverDTO.getVehicleId()), HttpStatus.CREATED);
    }
}
