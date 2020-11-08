package com.simco.watcher.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Observation {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    private UUID id;

    // when the observation was made
    private LocalDateTime timestamp;

    // observing which home
    private UUID selectedHomeId;
    private Home home;

    // observed details about home
    private GarageStatus garageStatus;
    private HomeLightsStatus extLightsStatus;
    private HomeLightsStatus intLightsStatus;
    private HomeForSaleStatus forSaleStatus;
    private ContractorStatus contractorStatus;

    // need to contain vehicles info
    private UUID[] vehiclesPresentIds;
    private List<Vehicle> vehicles;

    public String getDateDisplayValue() {
        return null == timestamp ? "" : DATE_FORMATTER.format(timestamp);
    }

    public String getTimeDisplayValue() {
        return null == timestamp ? "" : TIME_FORMATTER.format(timestamp);
    }

    public String getVehiclesPresentDisplayValue() {
        String s = "None";
        if (null != vehicles && 0 < vehicles.size()) {
            s = vehicles.get(0).getPlateNumber();
            if (1 < vehicles.size())
                for (int j = 1; j < vehicles.size(); j++)
                    s += ", " + vehicles.get(j).getPlateNumber();
        }
        return s;
    }

}
