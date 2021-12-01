package com.tw.aepb.coin;

import java.util.Objects;

public class AirCoin implements Coin {

    private final Amount amount;

    public AirCoin(Double amount) {
        if (amount == null || amount < 0 || amount > 5_000_000 || Util.getNumberDecimalDigits(amount) > 3) {
            throw new IllegalArgumentException("amount error");
        }
        this.amount = new Amount(amount);
    }

    @Override
    public boolean compare(Coin coin) {
        return this.equals(coin);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirCoin airCoin = (AirCoin) o;
        return Objects.equals(amount, airCoin.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }


}
