package com.emmanuelperotto.strategy;

import java.math.BigDecimal;

public class Order {
    private final BigDecimal value;

    public Order(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
