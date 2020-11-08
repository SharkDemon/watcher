package com.simco.watcher.model;

public enum VehicleColor {

    // Colors chosen per https://www.carmax.com/articles/car-color-popularity

    BLACK("Black"),
    BLUE("Blue"),
    BROWN("Brown"),
    GOLD("Gold"),
    GRAY("Gray"),
    GREEN("Green"),
    ORANGE("Orange"),
    RED("Red"),
    SILVER("Silver"),
    TAN("Tan"),
    WHITE("White"),
    YELLOW("Yellow");

    private final String displayName;

    VehicleColor(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
