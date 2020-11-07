package com.simco.watcher.model;

public enum Doorbell {

    NORMAL("Normal"),
    RING_VIDEO("Ring Video"),
    RING_VIDEO_PRO("Ring Video Pro"),
    AUGUST_CAM_PRO("August Cam Pro");

    private final String displayName;

    Doorbell(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
