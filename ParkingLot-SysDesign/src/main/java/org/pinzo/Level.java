package org.pinzo;

import org.pinzo.vehicles.Vehicle;
import org.pinzo.vehicles.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<Spot> car_spots;
    private List<Spot> truck_spots;
    private List<Spot> bike_spots;

    public Level() {
        this.car_spots = new ArrayList<>();
        this.truck_spots = new ArrayList<>();
        this.bike_spots = new ArrayList<>();
        for (int i=0; i<10;i++) {
            this.car_spots.add(new Spot(VehicleType.CAR));
            this.bike_spots.add(new Spot(VehicleType.BIKE));
            this.truck_spots.add(new Spot(VehicleType.TRUCK));
        }
    }

    public boolean park(Vehicle vehicle) {
        for (Spot spot : this.getSpotsBasedOnType(vehicle.getType())) {
            if (spot.isAvailable()) {
                spot.park(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean returnVehicle(Vehicle vehicle) {
        for (Spot spot : this.getSpotsBasedOnType(vehicle.getType())) {
            if (spot.getPlateNumber().equals(vehicle.getPlateNumber())) {
                spot.returnVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public  List<Spot> getSpotsBasedOnType(VehicleType type) {
        if (type == VehicleType.CAR) {
            return this.car_spots;
        } else if (type == VehicleType.BIKE) {
            return this.bike_spots;
        } else {
            return this.truck_spots;
        }
    }

    public List<Spot> getBike_spots() {
        return bike_spots;
    }

    public void setBike_spots(List<Spot> bike_spots) {
        this.bike_spots = bike_spots;
    }

    public List<Spot> getCar_spots() {
        return car_spots;
    }

    public void setCar_spots(List<Spot> car_spots) {
        this.car_spots = car_spots;
    }

    public List<Spot> getTruck_spots() {
        return truck_spots;
    }

    public void setTruck_spots(List<Spot> truck_spots) {
        this.truck_spots = truck_spots;
    }
}
