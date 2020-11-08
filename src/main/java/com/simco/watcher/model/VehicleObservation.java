package com.simco.watcher.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class VehicleObservation {

    private UUID id;
    // don't really need a timestamp in this object, as instances of
    // VehicleObservation class are tied to a (Home) Observation object
    private Vehicle vehicle;
    private VehicleLocation location;

}
