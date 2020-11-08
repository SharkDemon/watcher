package com.simco.watcher.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Vehicle {

    private UUID id;

    private VehicleColor color;
    private String make;
    private String model;
    private State plateState;
    private String plateNumber;

}
