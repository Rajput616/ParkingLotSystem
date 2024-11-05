package model;


public class Truck extends Vehicle {
    public Truck(String registrationNumber, String color, String model) {
        super(registrationNumber, color, VehicleType.TRUCK, model);
    }
}