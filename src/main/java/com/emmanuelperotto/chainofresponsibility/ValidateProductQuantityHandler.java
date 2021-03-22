package com.emmanuelperotto.chainofresponsibility;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ValidateProductQuantityHandler extends OrderHandler {
    private final Logger LOGGER = Logger.getLogger(this.getClass().toString());

    public ValidateProductQuantityHandler(OrderHandler next) {
        super(next);
    };

    @Override
    public void handle(Order order) {
        order.getProducts().forEach((product) -> {
            if (product.getQuantityInStock() <= 0) {
                throw new OrderException("Produto: " + product.getName() + " não disponível no estoque.");
            }
        });

        LOGGER.log(Level.INFO, "The given products are available in stock");
        this.handleNext(order);
    }
}
