package org.pinzo;

import org.pinzo.vehicles.Bike;
import org.pinzo.vehicles.Car;
import org.pinzo.vehicles.Truck;
import org.pinzo.vehicles.VehicleType;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Tang Parking Lot");

        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("ABCD");
        Truck truck = new Truck("EFGH");
        Bike bike = new Bike("IKLM");

        System.out.println("Checking if have space for a car: " + parkingLot.hasEmptySpots(VehicleType.CAR));
        parkingLot.park(car);
        parkingLot.park(truck);
        parkingLot.park(bike);

        System.out.println("Checking if return a car successfully: " + parkingLot.returnVehicle(car));

    }
}