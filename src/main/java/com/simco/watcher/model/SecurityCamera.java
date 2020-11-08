package com.simco.watcher.model;

public enum SecurityCamera {

    ABSENT("Absent"),
    PRESENT("Present");

    private final String displayName;

    SecurityCamera(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
