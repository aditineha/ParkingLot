package model;


public class Ticket {
  private Vehicle vehicle;
  private ParkingSpace parkingSpace;
  private long entryTime;
  private long exitTime;

  public Ticket(Vehicle vehicle, ParkingSpace space) {
      this.vehicle = vehicle;
      this.parkingSpace = space;
      this.entryTime = System.currentTimeMillis();
      this.exitTime = -1;
  }

  public ParkingSpace getParkingSpace() {
      return parkingSpace;
  }

  public void markExit() {
      this.exitTime = System.currentTimeMillis();
  }

  public long getDuration() {
      if (exitTime == -1) {
          return System.currentTimeMillis() - entryTime;
      } else {
          return exitTime - entryTime;
      }
  }
}

