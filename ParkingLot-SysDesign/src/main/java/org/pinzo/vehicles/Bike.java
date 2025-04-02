package org.pinzo.vehicles;

public class Bike extends Vehicle {
    private VehicleType type;
    private String plateNumber;

    public Bike(String plateNumber) {
        this.type = VehicleType.BIKE;
        this.plateNumber = plateNumber;
    }

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
