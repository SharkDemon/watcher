package com.simco.watcher.model;

public enum ContractorStatus {

    NO_SIGN("No Sign"),
    CONTRACTOR_SIGN("Contractor Sign");

    private final String displayName;

    ContractorStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
