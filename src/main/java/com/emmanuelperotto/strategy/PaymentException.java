package com.emmanuelperotto.strategy;

public class PaymentException extends RuntimeException {
    public PaymentException(String message) {
        super(message);
    }
}
