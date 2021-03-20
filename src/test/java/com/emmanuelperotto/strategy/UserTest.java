package com.emmanuelperotto.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

class UserTest {
    private BigDecimal balance = BigDecimal.ZERO;
    private BigDecimal creditLimit = BigDecimal.ZERO;
    private BigDecimal availableCredit = BigDecimal.ZERO;
    private Order order;

    @Nested
    class PayWithCreditCard {
        @BeforeEach
        void setup() {
            order = new Order(BigDecimal.valueOf(500));
            creditLimit = BigDecimal.valueOf(8_000);
            availableCredit = BigDecimal.valueOf(8_000);
        }

        @Test
        @DisplayName("Paying with credit card")
        void payWithCreditCard() {
            var user = new User(balance, availableCredit, creditLimit);
            user.setStrategy(new CreditCardPayment());
            user.payOrder(order);

            var expected = availableCredit.subtract(order.getValue());
            assertEquals(expected, user.getAvailableCredit());
            assertEquals(creditLimit, user.getCreditLimit());
            assertEquals(balance, user.getBalance().add(BigDecimal.valueOf(10)));
        }
    }

    @Nested
    class PayWithPix {
        @BeforeEach
        void setup() {
            order = new Order(BigDecimal.valueOf(500));
            balance = BigDecimal.valueOf(500);
        }

        @Test
        @DisplayName("Paying with pix")
        void payWithPix() {
            var user = new User(balance, availableCredit, creditLimit);
            user.setStrategy(new PixPayment());
            user.payOrder(order);

            var expected = balance.subtract(order.getValue());
            assertEquals(availableCredit, user.getAvailableCredit());
            assertEquals(creditLimit, user.getCreditLimit());
            assertEquals(expected, user.getBalance());
        }
    }
}
