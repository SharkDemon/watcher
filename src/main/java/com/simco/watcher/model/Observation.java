package com.simco.watcher.model;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Observation {

    private UUID id;

    // when the observation was made
    private LocalDateTime timestamp;

    // observing which home
    private UUID selectedHomeId;
    private Home home;
    // observed details about home
    private GarageStatus garageStatus;
    private HomeLightsStatus lightsStatus;
    private HomeForSaleStatus forSaleStatus;
    private ContractorStatus contractorStatus;

    //
    private Set<Vehicle> vehicles;

}
