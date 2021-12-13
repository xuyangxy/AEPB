package com.tw.aepb.parkingboy;

public interface ParkingLotBoy {

    Ticket parkOn(Car car);

    Car parkUp(Ticket ticket);

}
