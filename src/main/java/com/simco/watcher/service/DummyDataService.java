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
import com.simco.watcher.model.VehicleMake;

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
            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.BLUE).make(VehicleMake.CHEVROLET).model("Cavalier")
            .plateState(State.TX).plateNumber("ABC 123")
            .build(),

            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.BLACK).make(VehicleMake.CHEVROLET).model("Malibu")
            .plateState(State.TX).plateNumber("DDD 444")
            .build(),

            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.SILVER).make(VehicleMake.MAZDA).model("3")
            .plateState(State.TX).plateNumber("EFG 991")
            .build(),

            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.SILVER).make(VehicleMake.MAZDA).model("CX-5")
            .plateState(State.CA).plateNumber("CLIP 99")
            .build(),

            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.WHITE).make(VehicleMake.FORD).model("Fusion")
            .plateState(State.IN).plateNumber("HOOSIERS")
            .build(),

            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.RED).make(VehicleMake.FORD).model("Escort")
            .plateState(State.TX).plateNumber("JIFO 441")
            .build(),

            Vehicle.builder().id(UUID.randomUUID()).color(VehicleColor.BLACK).make(VehicleMake.FORD).model("Escape")
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
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[1].getId()).home(homes[1])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 28, 8, 30, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[1].getId()).home(homes[1])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 29, 10, 30, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[1].getId()).home(homes[1])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 30, 11, 45, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[1].getId()).home(homes[1])
            .timestamp(LocalDateTime.of(2020, Month.NOVEMBER, 5, 14, 11, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),

            // for homes[2]
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[2].getId()).home(homes[2])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 28, 18, 45, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.ON).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.CONTRACTOR_SIGN)
            .build(),
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[1].getId()).home(homes[1])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 30, 22, 30, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.ON).intLightsStatus(HomeLightsStatus.ON).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),

            // for homes[3]
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[3].getId()).home(homes[3])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 28, 8, 30, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[3].getId()).home(homes[3])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 29, 10, 30, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[3].getId()).home(homes[3])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 30, 11, 45, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[3].getId()).home(homes[3])
            .timestamp(LocalDateTime.of(2020, Month.NOVEMBER, 5, 14, 11, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),

            // for homes[4]
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[4].getId()).home(homes[4])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 25, 22, 30, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[4].getId()).home(homes[4])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 26, 11, 12, 0, 0))
            .garageStatus(GarageStatus.AJAR).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[4].getId()).home(homes[4])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 27, 14, 45, 0, 0))
            .garageStatus(GarageStatus.AJAR).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[4].getId()).home(homes[4])
            .timestamp(LocalDateTime.of(2020, Month.NOVEMBER, 3, 15, 15, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),

            // for homes[5]
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[5].getId()).home(homes[5])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 14, 16, 45, 0, 0))
            .garageStatus(GarageStatus.CLOSED).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),
            Observation.builder().id(UUID.randomUUID()).selectedHomeId(homes[5].getId()).home(homes[5])
            .timestamp(LocalDateTime.of(2020, Month.OCTOBER, 16, 13, 55, 0, 0))
            .garageStatus(GarageStatus.AJAR).extLightsStatus(HomeLightsStatus.OFF).intLightsStatus(HomeLightsStatus.OFF).forSaleStatus(HomeForSaleStatus.NO_SIGN).contractorStatus(ContractorStatus.NO_SIGN)
            .build(),

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
