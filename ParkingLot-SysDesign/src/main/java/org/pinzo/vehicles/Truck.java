package org.pinzo.vehicles;

public class Truck extends Vehicle {
    private VehicleType type;
    private String plateNumber;

    public Truck(String plateNumber) {
        this.type = VehicleType.TRUCK;
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
