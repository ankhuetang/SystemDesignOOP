package org.pinzo;

import org.pinzo.vehicles.Vehicle;
import org.pinzo.vehicles.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Level> levels;

    public ParkingLot() {
        this.levels = new ArrayList<>();
        for (int i=0; i<3; i++) {
            this.levels.add(new Level());
        }
    }

    public boolean hasEmptySpots(VehicleType type) {
        for (Level level : levels) {
            for (Spot spot : level.getSpotsBasedOnType(type)) {
                if (spot.isAvailable()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean park(Vehicle vehicle) {
        for (Level level : levels) {
            for (Spot spot : level.getSpotsBasedOnType(vehicle.getType())) {
                if (spot.isAvailable()) {
                    spot.setAvailable(false);
                    spot.setPlateNumber(vehicle.getPlateNumber());
                    return true;
                }
            }
        }
        return false;
    }

    public boolean returnVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            for (Spot spot : level.getSpotsBasedOnType(vehicle.getType())) {
                if (vehicle.getPlateNumber().equals(spot.getPlateNumber())) {
                    spot.setAvailable(true);
                    spot.setPlateNumber("");
                    return true;
                }
            }
        }
        return false;
    }
}
