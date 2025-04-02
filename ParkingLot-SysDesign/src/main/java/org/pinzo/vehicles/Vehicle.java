package org.pinzo.vehicles;

public abstract class Vehicle {
    private VehicleType type;
    private String plateNumber;

    public VehicleType getType() {
        return type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
