package com.simco.watcher.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Home {

    private UUID id;

    private String number;
    private String street;
    // usually the following 3 fields are same, since these are all homes in
    // the same neighborhood, but capturing for map-making
    private String city;
    private String state;
    private String zip;

    public String getNumberStreet() {
        return String.format("%s %s", number, street);
    }

    public String getCityStateZip() {
        return String.format("%s, %s %s", city, state, zip);
    }

}
