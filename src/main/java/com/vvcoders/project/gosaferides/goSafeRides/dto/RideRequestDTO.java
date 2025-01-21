package com.vvcoders.project.gosaferides.goSafeRides.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.PaymentMethod;
import com.vvcoders.project.gosaferides.goSafeRides.entities.enums.RideRequestStatus;
import com.vvcoders.project.gosaferides.goSafeRides.utils.PointDeserializer;
import com.vvcoders.project.gosaferides.goSafeRides.utils.PointSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDTO {

    private Long id;

    @JsonSerialize(using = PointSerializer.class)
    @JsonDeserialize(using = PointDeserializer.class)
    private Point pickupLocation;

    @JsonSerialize(using = PointSerializer.class)
    @JsonDeserialize(using = PointDeserializer.class)
    private Point dropOffLocation;

    private LocalDateTime requestedTime;

    private RiderDTO rider;

    private PaymentMethod paymentMethod;

    private RideRequestStatus rideRequestStatus;

    private Double rideFare;
}
