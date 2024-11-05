package main;

import model.*;
import service.ParkingLot;
import strategy.FlatCostStrategy;

public class Main {
    public static void main(String[] args) {
        //Added 2 floors and 2 spaces of each vehicle type on each floor to not make it complicated
        ParkingLot parkingLot = new ParkingLot(2, 2, new FlatCostStrategy());

        // Creating vehicles
        Vehicle car1 = new Truck("YYY", "Red", "BMW");
        Vehicle car2 = new Car("QQQ", "Blue", "Bugatti");

        // Adding vehicles and generating tokens while adding it
        Token token1 = parkingLot.addVehicle(car1);
        Token token2 = parkingLot.addVehicle(car2);
        Token token3 = parkingLot.addVehicle(new Car("Tarzan", "Red", "Hello"));
        Token token4 = parkingLot.addVehicle(new Car("Toyota", "Red", "Corolla"));
        Token token5 = parkingLot.addVehicle(new Car("Bentley", "Red", "Continental"));

        // Displaying parking lot status
        parkingLot.displayStatus();

        //Making thread wait for 20 seconds for making it look realtime
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Checking availability on 2nd floor
        parkingLot.checkAvailability(2, VehicleType.BUS);

        // Trying to remove a vehicle using a token
        parkingLot.removeVehicle(token1.getTokenId());
        parkingLot.displayStatus();

        // Trying to remove a vehicle using registration number
        parkingLot.removeVehicle("BMW");
        parkingLot.displayStatus();
    }
}

