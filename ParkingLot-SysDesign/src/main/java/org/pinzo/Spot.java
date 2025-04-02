package org.pinzo;

import org.pinzo.vehicles.VehicleType;

public class Spot {
    private boolean available;
    private VehicleType type;
    private String plateNumber;

    public Spot(VehicleType type) {
        this.available = true;
        this.type = type;
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
