package com.simco.watcher.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Home {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private UUID id;

    private String number;
    private String street;
    // usually the following 3 fields are same, since these are all homes in
    // the same neighborhood, but capturing for map-making
    private String city;
    private State state;
    private String zip;
    // home details
    private Doorbell doorbell;
    private SecurityCamera securityCamera;

    // for display in the "list Homes" view only
    private String signage;
    private LocalDateTime mostRecentObservationTimestamp;

    public String getNumberStreet() {
        return String.format("%s %s", number, street);
    }

    public String getCityStateZip() {
        return String.format("%s, %s %s", city, state.getAbbreviation(), zip);
    }

    public String getMostRecentObservationDateDisplayValue() {
        return (null == mostRecentObservationTimestamp) ? "" : "as of " + DATE_FORMATTER.format(mostRecentObservationTimestamp);
    }

}
