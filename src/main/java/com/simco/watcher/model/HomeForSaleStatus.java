package com.simco.watcher.model;

public enum HomeForSaleStatus {

    NO_SIGN("No Sign"),
    FOR_SALE_SIGN("For Sale Sign");

    private final String displayName;

    HomeForSaleStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
