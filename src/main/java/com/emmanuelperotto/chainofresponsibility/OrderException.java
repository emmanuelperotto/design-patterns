package com.emmanuelperotto.chainofresponsibility;

public class OrderException extends RuntimeException {
    public OrderException(String message) {
        super(message);
    }
}
