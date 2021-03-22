package com.emmanuelperotto.chainofresponsibility;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeOrderTest {
    private Product product;

    @BeforeEach
    void setup() {
        product = new Product("Garrafa térmica", "Ideal para academia", 10);
    }

    @Nested
    class ValidateProductPresence {

        @Test
        void withProducts() {
            var order = new Order();
            order.addProduct(product);

            assertDoesNotThrow(() -> {
                MakeOrder.make(order);
            });
        }

        @Test
        void withoutProducts() {
            var order = new Order();

            assertThrows(OrderException.class, () -> {
                MakeOrder.make(order);
            });
        }
    }

    @Nested
    class ValidateProductQuantity {

        @Test
        void validQuantity() {
            var order = new Order();
            var product = new Product("name", "desc", 10);
            order.addProduct(product);

            assertDoesNotThrow(() -> {
                MakeOrder.make(order);
            });
        }

        @Test
        void invalidQuantity() {
            var order = new Order();
            var product = new Product("name", "desc", 10);
            var product2 = new Product("name", "desc", 0);
            order.addProduct(product);
            order.addProduct(product2);

            assertThrows(OrderException.class, () -> {
                MakeOrder.make(order);
            });
        }
    }
}