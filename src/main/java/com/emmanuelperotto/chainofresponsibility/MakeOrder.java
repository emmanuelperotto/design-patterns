package com.emmanuelperotto.chainofresponsibility;

public class MakeOrder {
    public static void make(Order order) {
        var handlerChain = new ValidateProductPresenceHandler(
                new ValidateProductQuantityHandler(null)
        );

        handlerChain.handle(order);
    }
}
