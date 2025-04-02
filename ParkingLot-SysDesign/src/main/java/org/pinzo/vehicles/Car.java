package org.pinzo.vehicles;

public class Car extends Vehicle {
    private VehicleType type;
    private String plateNumber;

    public Car(String plateNumber) {
        this.type = VehicleType.CAR;
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
