package com.simco.watcher.model;

public enum VehicleMake {

    ACURA("Acura"),
    AUDI("Audi"),
    BMW("BMW"),
    BUICK("Buick"),
    CADILLAC("Cadillac"),
    CHEVROLET("Chevrolet"),
    CHRYSLER("Chrysler"),
    DODGE("Dodge"),
    FERRARI("Ferrari"),
    FORD("Ford"),
    GMC("GMC"),
    HONDA("Honda"),
    HYUNDAI("Hyundai"),
    JAGUAR("Jaguar"),
    JEEP("Jeep"),
    KIA("Kia"),
    LINCOLN("Lincoln"),
    MAZDA("Mazda"),
    MERCEDES("Mercedes"),
    NISSAN("Nissan"),
    PONTIAC("Pontiac"),
    PORSCHE("Porsche"),
    RAM("Ram"),
    SUBARU("Subaru"),
    SUZUKI("Suzuki"),
    TESLA("Tesla"),
    TOYOTA("Toyota"),
    VOLKSWAGEN("Volkswagen"),
    VOLVO("Volvo");

    private final String displayName;

    VehicleMake(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
