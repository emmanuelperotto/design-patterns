package com.emmanuelperotto.strategy;

import java.math.BigDecimal;

public class CreditCardPayment implements PaymentImpactStrategy {
    @Override
    public PaymentImpact calculateImpact(Order order, User user) {
        var availableCredit = user.getAvailableCredit();
        var value = order.getValue();

        if (availableCredit.compareTo(value) < 0) {
            throw new PaymentException("User doesn't have enough credit available");
        }

        return new PaymentImpact(BigDecimal.ZERO, value, BigDecimal.ZERO);
    }
}
