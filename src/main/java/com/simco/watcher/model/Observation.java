package com.simco.watcher.model;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Observation {

    // when the observation was made
    private LocalDateTime timestamp;

    // observing which home
    private Home home;
    // observed details about home
    private GarageStatus garageStatus;
    private HomeLightsStatus lightsStatus;
    private HomeForSaleStatus forSaleStatus;

    //
    private Set<Vehicle> vehicles;

}
