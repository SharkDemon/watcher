package com.simco.watcher.model;

public enum VehicleMake {

    CHEVROLET("Chevrolet"),
    FORD("Ford"),
    MAZDA("Mazda"),
    TOYOTA("Toyota");

    private final String displayName;

    VehicleMake(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
