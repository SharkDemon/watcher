package com.simco.watcher.model;

public enum GarageStatus {

    NONE("None"),
    CLOSED("Closed"),
    AJAR("Ajar"),
    OPEN("Open");

    private final String displayName;

    GarageStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
