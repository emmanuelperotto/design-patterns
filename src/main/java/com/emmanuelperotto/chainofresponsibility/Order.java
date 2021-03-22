package com.emmanuelperotto.chainofresponsibility;

import java.util.ArrayList;

public class Order {
    private final ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
