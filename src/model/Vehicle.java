package model;

public class Vehicle {
    private String licensePlate;
    private ParkingSpaceType size;

    public Vehicle(String licensePlate, ParkingSpaceType size) {
        this.licensePlate = licensePlate;
        this.size = size;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public ParkingSpaceType getSize() {
        return size;
    }
}
