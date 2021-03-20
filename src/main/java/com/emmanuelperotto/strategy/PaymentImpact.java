package com.emmanuelperotto.strategy;

import java.math.BigDecimal;

public class PaymentImpact {
    private final BigDecimal creditLimitImpact;
    private final BigDecimal availableCreditImpact;
    private final BigDecimal balanceImpact;


    public PaymentImpact(BigDecimal creditLimitImpact, BigDecimal availableCreditImpact, BigDecimal balanceImpact) {
        this.creditLimitImpact = creditLimitImpact;
        this.availableCreditImpact = availableCreditImpact;
        this.balanceImpact = balanceImpact;
    }

    public BigDecimal getCreditLimitImpact() {
        return creditLimitImpact;
    }

    public BigDecimal getAvailableCreditImpact() {
        return availableCreditImpact;
    }

    public BigDecimal getBalanceImpact() {
        return balanceImpact;
    }
}
