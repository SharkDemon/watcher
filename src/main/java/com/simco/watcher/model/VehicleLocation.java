package com.simco.watcher.model;

public enum VehicleLocation {

    GARAGE("Garage"),
    DRIVEWAY("Driveway"),
    STREET("Street");

    private final String displayName;

    VehicleLocation(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
