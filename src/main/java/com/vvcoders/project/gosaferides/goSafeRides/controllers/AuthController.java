package com.vvcoders.project.gosaferides.goSafeRides.controllers;

import com.vvcoders.project.gosaferides.goSafeRides.advices.ApiResponse;
import com.vvcoders.project.gosaferides.goSafeRides.dto.*;
import com.vvcoders.project.gosaferides.goSafeRides.services.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Value("${deployment.env}")
    private String deployEnv;

    @PostMapping("/signup")
    ResponseEntity<UserDTO> signUp(@RequestBody SignUpDTO signUpDTO){
        return new ResponseEntity<>(authService.signup(signUpDTO),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletRequest request, HttpServletResponse response){
        String[] tokens = authService.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());

        Cookie cookie = new Cookie("refreshToken", tokens[1]);
        cookie.setHttpOnly(true);
        cookie.setSecure(deployEnv.equals("production"));
        response.addCookie(cookie);
        return new ResponseEntity<>(new LoginResponseDTO(tokens[0]), HttpStatus.OK);
    }

    @PostMapping("/logout")
    ResponseEntity<ApiResponse> logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("refreshToken", null);
        cookie.setHttpOnly(true);
        cookie.setSecure(deployEnv.equals("production"));
        cookie.setPath("/");
        cookie.setMaxAge(0); // Expire immediately
        response.addCookie(cookie);

        return ResponseEntity.ok(new ApiResponse("Logout successful"));
    }


    @PostMapping("/onboardNewDriver/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<DriverDTO> onboardNewDriver(@PathVariable Long userId, @RequestBody OnBoardDriverDTO onBoardDriverDTO){
        return new ResponseEntity<>(authService.onboardNewDriver(userId, onBoardDriverDTO.getVehicleId()), HttpStatus.CREATED);
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponseDTO> refresh(HttpServletRequest request) {
        String refreshToken= Arrays.stream(request.getCookies())
                .filter(cookie -> "refreshToken".equals(cookie.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElseThrow(() -> new AuthorizationServiceException("Refresh Token not found inside the Cookie."));

        LoginResponseDTO loginResponseDTO = authService.refreshToken(refreshToken);
        return ResponseEntity.ok(loginResponseDTO);
    }

}
