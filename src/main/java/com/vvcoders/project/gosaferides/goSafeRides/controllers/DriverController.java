package com.vvcoders.project.gosaferides.goSafeRides.controllers;

import com.vvcoders.project.gosaferides.goSafeRides.dto.*;
import com.vvcoders.project.gosaferides.goSafeRides.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverController {

    public final DriverService driverService;

    @PostMapping("/acceptRide/{rideRequestId}")
    public ResponseEntity<RideDTO>acceptRide(@PathVariable Long rideRequestId){
        return ResponseEntity.ok(driverService.acceptRide(rideRequestId));
    }

    @PostMapping("/startRide/{rideId}")
    public ResponseEntity<RideDTO>startRide(@RequestBody StartRideDTO startRideDTO, @PathVariable Long rideId){
        return ResponseEntity.ok(driverService.startRide(rideId, startRideDTO.getOtp()));
    }

    @PostMapping("/endRide/{rideId}")
    public ResponseEntity<RideDTO>endRide(@PathVariable Long rideId){
        return ResponseEntity.ok(driverService.endRide(rideId));
    }

    @PostMapping("/cancelRide/{rideId}")
    public ResponseEntity<RideDTO> cancelRide(@PathVariable Long rideId){
        return ResponseEntity.ok(driverService.cancelRide(rideId));
    }

    @PostMapping("/rateRider")
    public ResponseEntity<RiderDTO> rateRider(@RequestBody RatingDTO ratingDTO){
        return ResponseEntity.ok(driverService.rateRider(ratingDTO.getRideId(), ratingDTO.getRating()));
    }

    @GetMapping("/getMyProfile")
    public ResponseEntity<DriverDTO> getMyProfile(){
        return ResponseEntity.ok(driverService.getMyProfile());
    }

    @GetMapping("/getMyRides")
    public ResponseEntity<Page<RideDTO>> getAllMyRides(@RequestParam(defaultValue = "0") Integer pageOffSet,
                                                       @RequestParam(defaultValue = "10", required = false)Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageOffSet, pageSize, Sort.by(Sort.Direction.DESC,  "createdTime", "id"));
        return ResponseEntity.ok(driverService.getAllMyRides(pageRequest));
    }

}