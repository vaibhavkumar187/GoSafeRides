package com.vvcoders.project.gosaferides.goSafeRides.services.impl;

import com.vvcoders.project.gosaferides.goSafeRides.dto.DriverDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.SignUpDTO;
import com.vvcoders.project.gosaferides.goSafeRides.dto.UserDTO;
import com.vvcoders.project.gosaferides.goSafeRides.entities.User;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.Role;
import com.vvcoders.project.gosaferides.goSafeRides.exceptions.RuntimeConflictException;
import com.vvcoders.project.gosaferides.goSafeRides.repositories.UserRepository;
import com.vvcoders.project.gosaferides.goSafeRides.services.AuthService;
import com.vvcoders.project.gosaferides.goSafeRides.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional //Either the complete method will execute or nothing will be added to DB.
    public UserDTO signup(SignUpDTO signUpDTO) {

        userRepository.findByEmail(signUpDTO.getEmail()).ifPresent((user)-> {
            throw new RuntimeConflictException("Cannot signup, User already exists with email "+user.getEmail());
        });

        User mappedUser= modelMapper.map(signUpDTO, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));

        User savedUser = userRepository.save(mappedUser);

        //Created the Rider Profile as user is logging in for the first time
        riderService.createRider(savedUser);

        //Created the Wallet for the User

        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public DriverDTO onboardNewDriver(Long userId) {
        return null;
    }
}
