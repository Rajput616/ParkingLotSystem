package service;

import model.Vehicle;
import model.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Floor {
    private int floorNumber;
    private int totalSpaces;
    private Map<VehicleType, List<VehicleSpace>> parkingSpaces; // Map for vehicle spaces by type

    public Floor(int floorNumber, int totalSpaces) {
        this.floorNumber = floorNumber;
        this.totalSpaces = totalSpaces;
        parkingSpaces = new HashMap<>();

        for (VehicleType type : VehicleType.values()) {
            List<VehicleSpace> vehicleSpaces = new ArrayList<>();
            for (int i = 1; i <= totalSpaces; i++) {
                vehicleSpaces.add(new VehicleSpace(i)); // Initialize all spaces
            }
            parkingSpaces.put(type, vehicleSpaces);
        }
    }

    public boolean addVehicle(Vehicle vehicle) {
        List<VehicleSpace> vehicleSpaces = parkingSpaces.get(vehicle.getType());
        for (VehicleSpace space : vehicleSpaces) {
            if (space.isAvailable()) {
                space.occupySpace(vehicle); // Occupy the space with the vehicle
                return true;
            }
        }
        return false; // No available space for the vehicle type
    }

    public boolean removeVehicle(String registrationNumber) {
        for (List<VehicleSpace> vehicleSpaces : parkingSpaces.values()) {
            for (VehicleSpace space : vehicleSpaces) {
                Vehicle vehicle = space.getVehicle();
                if (vehicle != null && vehicle.getRegistrationNumber().equals(registrationNumber)) {
                    space.freeSpace(); // Free the space if the vehicle matches
                    return true;
                }
            }
        }
        return false; // Vehicle not found
    }

    public void checkAvailability(VehicleType type) {
        List<VehicleSpace> vehicleSpaces = parkingSpaces.get(type);
        int availableSpaces = 0;
        for (VehicleSpace space : vehicleSpaces) {
            if (space.isAvailable()) {
                availableSpaces++;
            }
        }
        System.out.println("Available spaces for " + type + ": " + availableSpaces);
    }

    public void displayStatus() {
        System.out.println("\nFloor " + floorNumber + " status:");
        for (VehicleType type : parkingSpaces.keySet()) {
            int occupiedSpaces = 0;
            for (VehicleSpace space : parkingSpaces.get(type)) {
                if (!space.isAvailable()) {
                    occupiedSpaces++;
                }
            }
            System.out.println(type + ": " + occupiedSpaces + "/" + totalSpaces);
        }
    }
}

