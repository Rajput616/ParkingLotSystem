package model;

public abstract class Vehicle {
    private final String registrationNumber;
    private final String color;
    private final VehicleType type;
    private final String vehicleModel;

    public Vehicle(String registrationNumber, String color, VehicleType type, String vehicleModel) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.type = type;
        this.vehicleModel = vehicleModel;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public VehicleType getType() {
        return type;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }
}


