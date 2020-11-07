package com.simco.watcher.model;

public enum HomeLightsStatus {

    OFF("Off"),
    ON("On");

    private final String displayName;

    HomeLightsStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
