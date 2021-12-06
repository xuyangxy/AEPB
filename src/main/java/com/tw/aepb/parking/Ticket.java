package com.tw.aepb.parking;

public class Ticket {

    private int parkingLotSerialNumber;

    private int parkSpaceNumber;

    private String carNumber;

    public Ticket(int parkingLotSerialNumber, int parkSpaceNumber, String carNumber) {
        this.carNumber = carNumber;
        this.parkingLotSerialNumber = parkingLotSerialNumber;
        this.parkSpaceNumber = parkSpaceNumber;
    }

    public int getParkingLotSerialNumber() {
        return parkingLotSerialNumber;
    }

    public int getParkSpaceNumber() {
        return parkSpaceNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }
}
