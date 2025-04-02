package org.pinzo;

import org.pinzo.vehicles.Vehicle;
import org.pinzo.vehicles.VehicleType;

public class Spot {
    private boolean available;
    private VehicleType type;
    private String plateNumber;

    public Spot(VehicleType type) {
        this.available = true;
        this.type = type;
    }

    public boolean park(Vehicle vehicle) {
        if (isAvailable() && this.getType() == vehicle.getType()) {
            this.setPlateNumber(vehicle.getPlateNumber());
            return true;
        } else {
            throw new IllegalArgumentException("Invalid");
        }
    }

    public boolean returnVehicle(Vehicle vehicle) {
        if (!isAvailable() && this.getPlateNumber().equals(vehicle.getPlateNumber())) {
            this.setAvailable(true);
            this.setPlateNumber("");
            return true;
        }
        return false;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

}
