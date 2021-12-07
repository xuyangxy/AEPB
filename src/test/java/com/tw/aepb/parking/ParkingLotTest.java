package com.tw.aepb.parking;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    // happy path

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


    // sad path
    @Test
    public void should_throw_exception_when_parking_lot_full() {
        // given
        ParkingLotManager manager = new ParkingLotManager();
        manager.addParkingLot(new ParkingLot(1));

        // when
        manager.parkOn(new Car("AH76N"));

        // then
        try {
            manager.parkOn(new Car("AH78N"));
        } catch (Exception e) {
            Assert.assertEquals("error, all parkingLot full", e.getMessage());
            return;
        }
        Assert.fail();
    }

    @Test
    public void should_throw_exception_when_parking_lot_all_full() {
        // given
        ParkingLotManager manager = new ParkingLotManager();
        manager.addParkingLot(new ParkingLot(500));
        manager.addParkingLot(new ParkingLot(500));
        manager.addParkingLot(new ParkingLot(500));
        manager.addParkingLot(new ParkingLot(500));
        manager.addParkingLot(new ParkingLot(500));

        // when
        for (int i = 0; i < 2500; i++) {
            manager.parkOn(new Car("AH" + i + "N"));
        }

        // then
        try {
            manager.parkOn(new Car("AHH78N"));
        } catch (Exception e) {
            Assert.assertEquals("error, all parkingLot full", e.getMessage());
            return;
        }
        Assert.fail();
    }


    // exception
    @Test
    public void should_throw_exception_when_repeat_park_up() {
        // given
        ParkingLotManager manager = new ParkingLotManager();
        manager.addParkingLot(new ParkingLot(500));

        // when
        Car car = new Car("AH78N");
        Ticket ticket = manager.parkOn(car);

        // then
        try {
            manager.parkUp(ticket);
            manager.parkUp(ticket);
        } catch (Exception e) {
            Assert.assertEquals("error, ticket car not exist", e.getMessage());
            return;
        }
        Assert.fail();
    }


    @Test
    public void should_throw_exception_when_car_not_exist() {
        // given
        ParkingLotManager manager = new ParkingLotManager();
        manager.addParkingLot(new ParkingLot(500));

        // when
        Ticket ticket = new Ticket(0, 1, "As2dsd");

        // then
        try {
            manager.parkUp(ticket);
        } catch (Exception e) {
            Assert.assertEquals("error, ticket car not exist", e.getMessage());
            return;
        }
        Assert.fail();
    }


    @Test
    public void should_throw_exception_when_car_double_park_on() {
        // given
        ParkingLotManager manager = new ParkingLotManager();
        manager.addParkingLot(new ParkingLot(500));

        // when
        Car car = new Car("As2dsd");

        // then
        try {
            manager.parkOn(car);
            manager.parkOn(car);
        } catch (Exception e) {
            Assert.assertEquals("error, the car already exists", e.getMessage());
            return;
        }
        Assert.fail();
    }


    @Test
    public void should_throw_exception_when_park_on_100_park_out_100() {
        // given
        ParkingLotManager manager = new ParkingLotManager();
        manager.addParkingLot(new ParkingLot(10));

        // when && then
        for (int i = 0; i < 100; i++) {
            Ticket ticket = manager.parkOn(new Car("AH" + i + "N"));
            manager.parkUp(ticket);
        }
    }

}
