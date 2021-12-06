package com.tw.aepb.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingLotManager {

    private final List<ParkingLot> parkingLots;


    public ParkingLotManager() {
        this.parkingLots = new ArrayList<>();
    }


    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }


    public Ticket parkOn(Car car) {
        Integer parkingLotNumber = this.getHasNotEmptyParkingLotNumber();
        if (parkingLotNumber == null) {
            throw new RuntimeException("error, all parkingLot full");
        }
        int number = parkingLots.get(parkingLotNumber).parkOn(car);
        return new Ticket(parkingLotNumber, number, car.getCarNumber());
    }



    private Integer getHasNotEmptyParkingLotNumber() {
        if (parkingLots.isEmpty()) {
            throw new RuntimeException("error, current no have management parkingLot");
        }
        for (int index = 0; index < parkingLots.size(); index++) {
            ParkingLot parkingLot = parkingLots.get(index);
            if (parkingLot.notEmpty()) {
                return index;
            }
        }
        return null;
    }


    public Car parkUp(Ticket ticket) {
        ParkingLot parkingLot = parkingLots.get(ticket.getParkingLotSerialNumber());
        if (Objects.isNull(parkingLot)) {
            throw new RuntimeException("error, parkingLot not exist");
        }
        return parkingLot.parkUp(ticket);
    }
}
