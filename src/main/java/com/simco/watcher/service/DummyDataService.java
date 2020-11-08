package com.simco.watcher.service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.simco.watcher.model.ContractorStatus;
import com.simco.watcher.model.Doorbell;
import com.simco.watcher.model.GarageStatus;
import com.simco.watcher.model.Home;
import com.simco.watcher.model.HomeForSaleStatus;
import com.simco.watcher.model.HomeLightsStatus;
import com.simco.watcher.model.Observation;
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

    public Observation[] observations = {
            // for homes[0]
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[0].getId()).home(homes[0])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 28, 8, 30, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[0].getId()).home(homes[0])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 29, 10, 30, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[0].getId()).home(homes[0])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 30, 11, 45, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[0].getId()).home(homes[0])
            .timestamp(LocalDateTime.of(2020, Month.NOVEMBER, 1, 18, 37, 0, 0))
            .garageStatus(GarageStatus.OPEN).extLightsStatus(HomeLightsStatus.ON).intLightsStatus(HomeLightsStatus.ON).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[0].getId()).home(homes[0])
            .timestamp(LocalDateTime.of(2020, Month.NOVEMBER, 4, 13, 45, 0, 0))
            .garageStatus(GarageStatus.OPEN).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),

            // for homes[1]

    };

    public List<Home> getAllHomes() {
        return new ArrayList<Home>(Arrays.asList(homes));
    }

    public List<Vehicle> getAllVehicles() {
        return new ArrayList<Vehicle>(Arrays.asList(vehicles));
    }

    public List<Observation> getAllObservations() {
        return new ArrayList<Observation>(Arrays.asList(observations));
    }

}
