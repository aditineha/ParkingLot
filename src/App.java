import model.ParkingSpaceType;
import model.Ticket;
import model.Vehicle;
import service.ParkingLot;

public class App {
    public static void main(String[] args) throws Exception {
        // Create a parking lot with 5 spaces
        ParkingLot parkingLot = new ParkingLot(5);

        // Add some vehicles to the parking lot
        Vehicle vehicle1 = new Vehicle("ABC123", ParkingSpaceType.REGULAR);
        Vehicle vehicle2 = new Vehicle("XYZ789", ParkingSpaceType.REGULAR);

        System.out.println("Available spaces before entry: " + parkingLot.getAvailableSpaces());

        // Enter the vehicles into the parking lot
        Ticket ticket1 = parkingLot.enterParkingLot(vehicle1);
        Ticket ticket2 = parkingLot.enterParkingLot(vehicle2);

        // Check available spaces after adding vehicles
        System.out.println("Available spaces after entry: " + parkingLot.getAvailableSpaces());

        // Exit the vehicles from the parking lot
        double fee1 = parkingLot.exitParkingLot(vehicle1.getLicensePlate());
        double fee2 = parkingLot.exitParkingLot(vehicle2.getLicensePlate());

        // Check available spaces after exiting vehicles
        System.out.println("Available spaces after exit: " + parkingLot.getAvailableSpaces());

        // Display fees for each vehicle
        System.out.println("Fee for vehicle ABC123: $" + fee1);
        System.out.println("Fee for vehicle XYZ789: $" + fee2);    
   }
}


