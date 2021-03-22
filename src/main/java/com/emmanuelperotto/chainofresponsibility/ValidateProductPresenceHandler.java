package com.emmanuelperotto.chainofresponsibility;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ValidateProductPresenceHandler extends OrderHandler {
    private final Logger LOGGER = Logger.getLogger(ValidateProductPresenceHandler.class.toString());

    public ValidateProductPresenceHandler(OrderHandler next) {
        super(next);
    }

    @Override
    public void handle(Order order) {
        if (order.getProducts().size() <= 0) {
            throw new OrderException("Order can't have 0 products or less");
        }

        LOGGER.log(Level.INFO, "Order has at least 1 product. Calling next handler...");
        this.handleNext(order);
    }
}
