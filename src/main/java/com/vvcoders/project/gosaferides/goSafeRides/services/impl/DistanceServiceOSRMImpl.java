package com.vvcoders.project.gosaferides.goSafeRides.services.impl;

import com.vvcoders.project.gosaferides.goSafeRides.services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {


    private static final String OSRM_API_BASE_URL = "http://router.project-osrm.org/route/v1/driving/";

    @Override
    public double calculateDistance(Point src, Point dest) {

        try{
            OSRMResponseDTO responseDto=  RestClient.builder()
                    .baseUrl(OSRM_API_BASE_URL)
                    .build()
                    .get()
                    .uri(src.getX()+","+src.getY()+";"+dest.getX()+","+dest.getY())
                    .retrieve()
                    .body(OSRMResponseDTO.class);
            return responseDto.getRoutes().get(0).getDistance()/1000.0;
        } catch (Exception exception){
            throw new RuntimeException("Error getting data from OSRM "+ exception.getMessage());
        }

    }

}

    @Data
    class OSRMResponseDTO{
        private List<OSRMRoute> routes;
    }

    @Data
    class OSRMRoute {
        private Double distance;
    }
