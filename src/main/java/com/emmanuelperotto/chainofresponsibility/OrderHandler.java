package com.emmanuelperotto.chainofresponsibility;


public abstract class OrderHandler {
    private final OrderHandler next;

    public OrderHandler(OrderHandler next) {
        this.next = next;
    }

    public abstract void handle(Order order);

    protected void handleNext(Order order) {
        if (this.next == null) {
            return;
        }

        this.next.handle(order);
    }
}
