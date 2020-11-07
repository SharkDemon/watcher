package com.simco.watcher.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.simco.watcher.model.Doorbell;
import com.simco.watcher.model.Home;
import com.simco.watcher.model.Vehicle;
import com.simco.watcher.model.VehicleColor;

@Service
public class DummyDataService {

    private Home[] homes = {
            Home.builder().id(UUID.randomUUID()).number("6459").street("Riviera Dr").city("Irving").state("TX").zip("75039")
            .doorbell(Doorbell.NORMAL)
            .build(),

            Home.builder().id(UUID.randomUUID()).number("6465").street("Riviera Dr").city("Irving").state("TX").zip("75039")
            .doorbell(Doorbell.RING_VIDEO_PRO)
            .build(),

            Home.builder().id(UUID.randomUUID()).number("6469").street("Riviera Dr").city("Irving").state("TX").zip("75039")
            .doorbell(Doorbell.AUGUST_CAM_PRO)
            .build(),

            Home.builder().id(UUID.randomUUID()).number("6475").street("Riviera Dr").city("Irving").state("TX").zip("75039")
            .doorbell(Doorbell.RING_VIDEO)
            .build(),

            Home.builder().id(UUID.randomUUID()).number("6481").street("Riviera Dr").city("Irving").state("TX").zip("75039")
            .doorbell(Doorbell.RING_VIDEO)
            .build(),

            Home.builder().id(UUID.randomUUID()).number("6485").street("Riviera Dr").city("Irving").state("TX").zip("75039")
            .doorbell(Doorbell.NORMAL)
            .build(),
    };

    private Vehicle[] vehicles = {
            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.BLUE).make("Chevrolet").model("Cavalier")
            .plateState("TX").plateNumber("ABC 123").build(),
            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.BLACK).make("Chevrolet").model("Malibu")
            .plateState("TX").plateNumber("DDD 444").build(),
            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.SILVER).make("Mazda").model("3")
            .plateState("TX").plateNumber("EFG 991").build(),
    };

    public List<Home> getAllHomes() {
        return Arrays.asList(homes);
    }

    public List<Vehicle> getAllVehicles() {
        return Arrays.asList(vehicles);
    }

}
