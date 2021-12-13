package com.tw.aepb.parkingboy;

import java.util.Date;

public class Ticket {

    private final int parkingLotSerialNumber;

    private final int parkSpaceNumber;

    private final String carNumber;

    private final Date startParkTime;

    public Ticket(int parkingLotSerialNumber, int parkSpaceNumber, String carNumber) {
        this.carNumber = carNumber;
        this.parkingLotSerialNumber = parkingLotSerialNumber;
        this.parkSpaceNumber = parkSpaceNumber;
        this.startParkTime = new Date();
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

    public Date getStartParkTime() {
        return startParkTime;
    }
}
