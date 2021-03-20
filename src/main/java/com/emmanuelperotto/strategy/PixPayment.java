package com.emmanuelperotto.strategy;

import java.math.BigDecimal;

public class PixPayment implements PaymentImpactStrategy {

    @Override
    public PaymentImpact calculateImpact(Order order, User user) {
        var balance = user.getBalance();
        var value = order.getValue();

        if (balance.compareTo(value) < 0) {
            throw new PaymentException("User doesn't have enough balance available");
        }

        return new PaymentImpact(BigDecimal.ZERO, BigDecimal.ZERO, value);
    }
}
