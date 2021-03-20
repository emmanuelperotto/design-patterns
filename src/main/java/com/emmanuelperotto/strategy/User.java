package com.emmanuelperotto.strategy;

import java.math.BigDecimal;

public class User {
    private PaymentImpactStrategy strategy;
    private BigDecimal balance;
    private BigDecimal availableCredit;
    private BigDecimal creditLimit;

    public User(BigDecimal balance, BigDecimal availableCredit, BigDecimal creditLimit) {
        this.balance = balance;
        this.availableCredit = availableCredit;
        this.creditLimit = creditLimit;
    }

    public void setStrategy(PaymentImpactStrategy strategy) {
        this.strategy = strategy;
    }

    public void payOrder(Order order) {
        var impact = strategy.calculateImpact(order, this);

        this.balance = this.balance.subtract(impact.getBalanceImpact());
        this.availableCredit = this.availableCredit.subtract(impact.getAvailableCreditImpact());
        this.creditLimit = this.creditLimit.subtract(impact.getCreditLimitImpact());
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getAvailableCredit() {
        return availableCredit;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }
}
