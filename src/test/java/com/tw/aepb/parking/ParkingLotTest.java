package com.tw.aepb.parking;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void should_park_on_when_parking_have_1_space() {
        // given
        ParkingLotManager manager = new ParkingLotManager();
        manager.addParkingLot(new ParkingLot(1));

        Car car = new Car("AH76N");

        // when
        Ticket ticket = manager.parkOn(car);

        // then
        Assert.assertNotNull(ticket);
    }


    @Test
    public void should_park_up_when_parking_have_1_car() {
        // given
        ParkingLotManager manager = new ParkingLotManager();
        manager.addParkingLot(new ParkingLot(1));


        Car carOn = new Car("AH76N");

        // when
        Ticket ticket = manager.parkOn(carOn);
        Car carUp = manager.parkUp(ticket);

        // then
        Assert.assertEquals(carOn.getCarNumber(), carUp.getCarNumber());
    }



    @Test
    public void should_park_up_when_parking_have_many_space() {
        // given
        ParkingLotManager manager = new ParkingLotManager();
        manager.addParkingLot(new ParkingLot(500));
        manager.addParkingLot(new ParkingLot(500));
        manager.addParkingLot(new ParkingLot(500));
        manager.addParkingLot(new ParkingLot(500));
        manager.addParkingLot(new ParkingLot(500));

        // when
        Car carOn1 = new Car("AH76N");
        Ticket ticket1 = manager.parkOn(carOn1);
        Car carUp1 = manager.parkUp(ticket1);

        Car carOn2 = new Car("AH78N");
        Ticket ticket2 = manager.parkOn(carOn2);
        Car carUp2 = manager.parkUp(ticket2);

        // then
        Assert.assertEquals(carOn1.getCarNumber(), carUp1.getCarNumber());
        Assert.assertEquals(carUp2.getCarNumber(), carUp2.getCarNumber());
    }


    // 测试暂时没写完，代码逻辑基本都实现了
}
