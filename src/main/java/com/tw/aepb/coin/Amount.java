package com.tw.aepb.coin;

import java.util.Objects;

public class Amount {

    private final Double quantity;

    public Amount(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Objects.equals(quantity, amount.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
