package model;

public class SportsCar extends Vehicle {
    public SportsCar(String registrationNumber, String color, String model) {
        super(registrationNumber, color, VehicleType.SPORTS_CAR, model);
    }
}
