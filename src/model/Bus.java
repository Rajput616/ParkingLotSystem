package model;


public class Bus extends Vehicle {
    public Bus(String registrationNumber, String color, String model) {
        super(registrationNumber, color, VehicleType.BUS, model);
    }
}
