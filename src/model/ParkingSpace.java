package model;


public class ParkingSpace {
  private int id;
  private ParkingSpaceType type;
  private boolean isOccupied;
  private Vehicle vehicle;

  public ParkingSpace(int id, ParkingSpaceType type) {
      this.id = id;
      this.type = type;
      this.isOccupied = false;
      this.vehicle = null;
  }

  public void occupy(Vehicle vehicle) {
      this.isOccupied = true;
      this.vehicle = vehicle;
  }

  public void vacate() {
      this.isOccupied = false;
      this.vehicle = null;
  }

  public boolean isOccupied() {
      return isOccupied;
  }

  public ParkingSpaceType getType() {
      return type;
  }

  public Vehicle getVehicle() {
      return vehicle;
  }
}


