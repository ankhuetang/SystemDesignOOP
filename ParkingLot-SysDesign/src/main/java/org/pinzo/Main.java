package org.pinzo;

import org.pinzo.vehicles.Bike;
import org.pinzo.vehicles.Car;
import org.pinzo.vehicles.Truck;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Tang Parking Lot");
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("ABCD");
        Truck truck = new Truck("EFGH");
        Bike bike = new Bike("IKLM");
        Car car2 = new Car("NOPQ");

        // Creating threads for parking vehicles concurrently
        Thread thread1 = new Thread(() -> {
            System.out.println("Car park status: " + parkingLot.park(car));
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Truck park status: " + parkingLot.park(truck));
            System.out.println("Bike park status: " + parkingLot.park(bike));
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("Car2 park status: " + parkingLot.park(car2));
        });

        // Start all threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Checking if return a car successfully: " + parkingLot.returnVehicle(car));
    }
}