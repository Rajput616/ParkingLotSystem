package service;

import model.Vehicle;

class VehicleSpace {
    private int spaceNumber;
    private boolean isAvailable;
    private Vehicle vehicle;

    public VehicleSpace(int spaceNumber) {
        this.spaceNumber = spaceNumber;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void occupySpace(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    public void freeSpace() {
        this.vehicle = null;
        this.isAvailable = true;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

