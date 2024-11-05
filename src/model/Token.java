package model;

import strategy.CostStrategy;

public class Token {
    private String tokenId;
    private Vehicle vehicle;
    private long entryTimestamp;
    private CostStrategy costStrategy;

    public Token(String tokenId, Vehicle vehicle, long entryTimestamp, CostStrategy costStrategy) {
        this.tokenId = tokenId;
        this.vehicle = vehicle;
        this.entryTimestamp = entryTimestamp;
        this.costStrategy = costStrategy;
    }

    public String getTokenId() {
        return tokenId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public long getEntryTimestamp() {
        return entryTimestamp;
    }

    public double calculateCost(long exitTimestamp) {
        long durationInHours = (exitTimestamp - entryTimestamp) / (1000 * 60 * 60);
        durationInHours = Math.max(durationInHours, 1); // Minimum charge of 1 hour
        return costStrategy.calculateCost(vehicle.getType(), durationInHours);
    }
}

