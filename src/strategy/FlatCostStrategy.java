package strategy;

import model.VehicleType;

public class FlatCostStrategy implements CostStrategy {
    @Override
    public double calculateCost(VehicleType type, long hours) {
        return switch (type) {
            case CAR -> hours * 20;
            case SPORTS_CAR -> hours * 30;
            case TRUCK -> hours * 40;
            case BUS -> hours * 50;
            default -> 0;
        };
    }
}