package com.emmanuelperotto.chainofresponsibility;

public class Product {
    private final String name;
    private final String description;
    private final int quantityInStock;

    public Product(String name, String description, int quantityInStock) {
        this.name = name;
        this.description = description;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }
}
