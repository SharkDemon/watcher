package com.simco.watcher.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.simco.watcher.model.Doorbell;
import com.simco.watcher.model.Home;
import com.simco.watcher.model.SecurityCamera;
import com.simco.watcher.model.State;
import com.simco.watcher.model.Vehicle;
import com.simco.watcher.model.VehicleColor;

@Service
public class DummyDataService {

    private Home[] homes = {
            Home.builder().id(UUID.randomUUID()).number("6459").street("Riviera Dr").city("Irving").state(State.TX).zip("75039")
            .doorbell(Doorbell.NORMAL).securityCamera(SecurityCamera.ABSENT)
            .build(),

            Home.builder().id(UUID.randomUUID()).number("6465").street("Riviera Dr").city("Irving").state(State.TX).zip("75039")
            .doorbell(Doorbell.RING_VIDEO_PRO).securityCamera(SecurityCamera.PRESENT)
            .build(),

            Home.builder().id(UUID.randomUUID()).number("6469").street("Riviera Dr").city("Irving").state(State.TX).zip("75039")
            .doorbell(Doorbell.AUGUST_CAM_PRO).securityCamera(SecurityCamera.ABSENT)
            .build(),

            Home.builder().id(UUID.randomUUID()).number("6475").street("Riviera Dr").city("Irving").state(State.TX).zip("75039")
            .doorbell(Doorbell.RING_VIDEO).securityCamera(SecurityCamera.PRESENT)
            .build(),

            Home.builder().id(UUID.randomUUID()).number("6481").street("Riviera Dr").city("Irving").state(State.TX).zip("75039")
            .doorbell(Doorbell.RING_VIDEO).securityCamera(SecurityCamera.PRESENT)
            .build(),

            Home.builder().id(UUID.randomUUID()).number("6485").street("Riviera Dr").city("Irving").state(State.TX).zip("75039")
            .doorbell(Doorbell.NORMAL).securityCamera(SecurityCamera.ABSENT)
            .build(),
    };

    private Vehicle[] vehicles = {
            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.BLUE).make("Chevrolet").model("Cavalier")
            .plateState(State.TX).plateNumber("ABC 123")
            .build(),

            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.BLACK).make("Chevrolet").model("Malibu")
            .plateState(State.TX).plateNumber("DDD 444")
            .build(),

            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.SILVER).make("Mazda").model("3")
            .plateState(State.TX).plateNumber("EFG 991")
            .build(),

            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.SILVER).make("Mazda").model("CX-5")
            .plateState(State.CA).plateNumber("CLIP 99")
            .build(),

            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.WHITE).make("Ford").model("Fusion")
            .plateState(State.IN).plateNumber("HOOSIERS")
            .build(),

            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.RED).make("Ford").model("Escort")
            .plateState(State.TX).plateNumber("JIFO 441")
            .build(),

            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.BLACK).make("Ford").model("Escape")
            .plateState(State.TX).plateNumber("LKM 8644")
            .build(),
    };

    public List<Home> getAllHomes() {
        return Arrays.asList(homes);
    }

    public List<Vehicle> getAllVehicles() {
        return Arrays.asList(vehicles);
    }

}
