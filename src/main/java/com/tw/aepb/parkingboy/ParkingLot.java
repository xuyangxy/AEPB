package com.tw.aepb.parkingboy;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ParkingLot {

    private final int size;

    private int currentMax = 0;

    private final Map<Integer, Car> parkingSpaceCars;
    private final LinkedList<Integer> emptyParkingSpaces;


    public ParkingLot(int size) {
        this.size = size;
        this.emptyParkingSpaces = new LinkedList<>();
        this.parkingSpaceCars = new HashMap<>();
    }


    public int parkOn(Car newCar) {
        if (parkingSpaceCars.size() > size) {
            throw new RuntimeException("error, current parkingLot full");
        }
        if (emptyParkingSpaces.isEmpty()) {
            parkingSpaceCars.put(++currentMax, newCar);
            return currentMax;
        }
        Collections.sort(emptyParkingSpaces);
        Integer number = emptyParkingSpaces.pop();
        parkingSpaceCars.put(number, newCar);
        return number;
    }


    public Car parkUp(Ticket ticket ) {
        int parkSpaceNumber = ticket.getParkSpaceNumber();
        Car car = parkingSpaceCars.get(parkSpaceNumber);
        if (car == null) {
            throw new RuntimeException("error, ticket car not exist");
        }

        if (!car.getCarNumber().equals(ticket.getCarNumber())) {
            throw new RuntimeException("error, ticket and cat not correspond");
        }
        parkingSpaceCars.remove(parkSpaceNumber);
        emptyParkingSpaces.add(parkSpaceNumber);
        return car;
    }


    public boolean notEmpty() {
        return parkingSpaceCars.size() < size;
    }

    public int getParkingSpaceNumber() {
        return size -  parkingSpaceCars.size();
    }
}
