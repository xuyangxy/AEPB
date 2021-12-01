package com.tw.aepb.coin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class AirCoinTest {

    @Test
    void should_equals_when_coin_1_equals_coin_1() {
        // given
        Coin airCoin = new AirCoin(1.0);
        Coin airCoinNew = new AirCoin(1.0);

        // when && then
        Assertions.assertEquals(airCoin, airCoinNew);
    }

    @Test
    void should_equals_when_coin_1_1_equals_coin_1_1() {
        // given
        Coin airCoin = new AirCoin(1.1);
        Coin airCoinNew = new AirCoin(1.1);

        // when && then
        Assertions.assertEquals(airCoin, airCoinNew);
    }

    @Test
    void should_not_equals_when_coin_1_equals_coin_2() {
        // given
        Coin airCoin = new AirCoin(1.0);
        Coin airCoinNew = new AirCoin(2.0);

        // when && then
        Assertions.assertNotEquals(airCoin, airCoinNew);
    }

    @Test
    void should_throw_exception_when_coin_less_than_0() {
        try {
            // given
            Coin airCoin = new AirCoin(-1.0);
        } catch (Exception e) {
            Assertions.assertEquals("amount error", e.getMessage());
            return;
        }

        // when && then
        Assertions.fail();
    }


    @Test
    void should_throw_exception_when_coin_greater_than_500_0000() {
        try {
            // given
            Coin airCoin = new AirCoin(5000000.1);
        } catch (Exception e) {
            Assertions.assertEquals("amount error", e.getMessage());
            return;
        }

        // when && then
        Assertions.fail();
    }

    @Test
    void should_throw_exception_when_decimal_place_greater_than_4_digits() {
        try {
            // given
            Coin airCoin = new AirCoin(0.1122);
        } catch (Exception e) {
            Assertions.assertEquals("amount error", e.getMessage());
            return;
        }

        // when && then
        Assertions.fail();
    }
}
