package service;


import java.util.*;

import model.ParkingSpace;
import model.ParkingSpaceType;
import model.Ticket;
import model.Vehicle;

public class ParkingLot {
    private List<ParkingSpace> parkingSpaces;
    private Map<String, Ticket> activeTickets; // Maps license plate to the active ticket
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSpaces = new ArrayList<>();
        this.activeTickets = new HashMap<>();
        
        // Initialize parking spaces (for simplicity, all regular spaces)
        for (int i = 0; i < capacity; i++) {
            parkingSpaces.add(new ParkingSpace(i, ParkingSpaceType.REGULAR));
        }
    }

    public Ticket enterParkingLot(Vehicle vehicle) {
        // Find a vacant space
        for (ParkingSpace space : parkingSpaces) {
            if (!space.isOccupied() && space.getType() == vehicle.getSize()) {
                space.occupy(vehicle);
                Ticket ticket = new Ticket(vehicle, space);
                activeTickets.put(vehicle.getLicensePlate(), ticket);
                return ticket;
            }
        }
        throw new IllegalStateException("No available parking spaces");
    }

    public double exitParkingLot(String licensePlate) {
        if (!activeTickets.containsKey(licensePlate)) {
            throw new IllegalArgumentException("No active ticket for this license plate");
        }

        Ticket ticket = activeTickets.get(licensePlate);
        ticket.markExit();
        
        ParkingSpace space = ticket.getParkingSpace();
        space.vacate();
        
        double fee = calculateFee(ticket);
        
        activeTickets.remove(licensePlate);
        return fee;
    }

    private double calculateFee(Ticket ticket) {
        long duration = ticket.getDuration();
        double hourlyRate = 2.0; // $2 per hour
        return (duration / 3600000) * hourlyRate; // duration in milliseconds
    }

    public int getAvailableSpaces() {
        int available = 0;
        for (ParkingSpace space : parkingSpaces) {
            if (!space.isOccupied()) {
                available++;
            }
        }
        return available;
    }
}
