package com.vvcoders.project.gosaferides.goSafeRides.dto;

import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.PaymentMethod;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideDTO {

    private Long id;

    private Point pickupLocation;

    private Point dropOffLocation;

    private LocalDateTime creationTime;

    private RiderDTO rider;

    private DriverDTO driver;

    private PaymentMethod paymentMethod;

    private RideStatus rideRequestStatus;

    private Double rideFare;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

}
