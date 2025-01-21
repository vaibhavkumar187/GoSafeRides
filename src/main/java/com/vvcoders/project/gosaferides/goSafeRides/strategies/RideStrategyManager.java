package com.vvcoders.project.gosaferides.goSafeRides.strategies;

import com.vvcoders.project.gosaferides.goSafeRides.strategies.impl.DriverMatchingHighestRatedStrategy;
import com.vvcoders.project.gosaferides.goSafeRides.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.vvcoders.project.gosaferides.goSafeRides.strategies.impl.RideFareDefaultFareCalculationStrategy;
import com.vvcoders.project.gosaferides.goSafeRides.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    private final DriverMatchingHighestRatedStrategy driverMatchingHighestRatedStrategy;
    private final DriverMatchingNearestDriverStrategy driverMatchingNearestDriverStrategy;
    private final RideFareDefaultFareCalculationStrategy rideFareDefaultFareCalculationStrategy;
    private final RideFareSurgePricingFareCalculationStrategy rideFareSurgePricingFareCalculationStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){
        if(riderRating >= 4.5){
            return driverMatchingHighestRatedStrategy;
        }else{
            return driverMatchingNearestDriverStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy(){

        LocalTime surgeStartTime = LocalTime.of(18, 0);
        LocalTime surgeEndTime = LocalTime.of(21, 30);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if(isSurgeTime){
            return rideFareSurgePricingFareCalculationStrategy;
        }else{
            return rideFareDefaultFareCalculationStrategy;
        }
    }

}
