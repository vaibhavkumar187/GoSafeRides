package com.vvcoders.project.gosaferides.goSafeRides.services.impl;

import com.vvcoders.project.gosaferides.goSafeRides.dto.DriverDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.SignUpDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.UserDTO;
import com.vvcoders.project.gosaferides.goSafeRides.entities.User;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.Role;
import com.vvcoders.project.gosaferides.goSafeRides.repositories.UserRepository;
import com.vvcoders.project.gosaferides.goSafeRides.services.AuthService;
import com.vvcoders.project.gosaferides.goSafeRides.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDTO signup(SignUpDTO signUpDTO) {

        userRepository.findByEmail(signUpDTO.getEmail()).orElseThrow(()->
                new RuntimeException("Cannot signup, User already exists with email"+signUpDTO.getEmail())) ;

        User mappedUser= modelMapper.map(signUpDTO, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);
        UserDTO savedUserDTO= modelMapper.map(savedUser, UserDTO.class);

        //Created the Rider Profile as user is logging in for the first time
        riderService.createRider(savedUserDTO);

        //Created the Wallet for the User


        return savedUserDTO;


    }

    @Override
    public DriverDTO onboardNewDriver(Long userId) {
        return null;
    }
}
