package service;

import model.*;
import strategy.CostStrategy;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int floors;
    private Map<Integer, Floor> floorMap;
    private Map<String, Token> tokenMap;
    private int tokenCounter;
    private CostStrategy costStrategy;

    public ParkingLot(int floors, int spacesPerFloor, CostStrategy costStrategy) {
        this.floors = floors;
        floorMap = new HashMap<>();
        tokenMap = new HashMap<>();
        tokenCounter = 1;
        this.costStrategy = costStrategy;

        for (int i = 1; i <= floors; i++) {
            floorMap.put(i, new Floor(i, spacesPerFloor));
        }
    }

    public Token addVehicle(Vehicle vehicle) {
        for (Floor floor : floorMap.values()) {
            if (floor.addVehicle(vehicle)) {
                String tokenId = "TOKEN" + tokenCounter++;
                Token token = new Token(tokenId, vehicle, System.currentTimeMillis(), costStrategy);
                tokenMap.put(tokenId, token);
                System.out.println(vehicle.getColor() + " " + vehicle.getVehicleModel() + " with registration number " + vehicle.getRegistrationNumber() + " parked successfully! Token ID: " + tokenId);
                return token;
            }
        }
        System.out.println("Parking is full!\n");
        return null;
    }

    public boolean removeVehicle(String identifier) {
        if (tokenMap.containsKey(identifier)) {
            Token token = tokenMap.get(identifier);
            Vehicle vehicle = token.getVehicle();
            if (removeVehicleByRegistrationNumber(vehicle.getRegistrationNumber())) {
                tokenMap.remove(identifier);
                long exitTimestamp = System.currentTimeMillis();
                double cost = token.calculateCost(exitTimestamp);
                System.out.println("Vehicle removed successfully! Parking cost: ₹" + cost);
                return true;
            }
        } else {
            if (removeVehicleByRegistrationNumber(identifier)) {
                tokenMap.values().removeIf(token -> token.getVehicle().getRegistrationNumber().equals(identifier));
                System.out.println("Vehicle removed successfully!");
                return true;
            }
        }
        System.out.println("Vehicle not found!");
        return false;
    }

    private boolean removeVehicleByRegistrationNumber(String registrationNumber) {
        for (Floor floor : floorMap.values()) {
            if (floor.removeVehicle(registrationNumber)) {
                return true;
            }
        }
        return false;
    }

    public void checkAvailability(int floorNumber, VehicleType type) {
        Floor floor = floorMap.get(floorNumber);
        if (floor != null) {
            floor.checkAvailability(type);
        } else {
            System.out.println("Invalid floor number!\n");
        }
    }

    public void displayStatus() {
        for (Floor floor : floorMap.values()) {
            floor.displayStatus();
        }
    }
}

