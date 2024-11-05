package strategy;

import model.VehicleType;

public interface CostStrategy {
    double calculateCost(VehicleType type, long hours);
}
