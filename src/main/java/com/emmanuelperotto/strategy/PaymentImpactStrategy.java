package com.emmanuelperotto.strategy;

import java.math.BigDecimal;

public interface PaymentImpactStrategy {
    PaymentImpact calculateImpact(Order order, User user);
}
