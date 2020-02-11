package com.example.appwaterssaller;

public class Order {
    Product product;
    int Number;

    public Order(Product product, int number) {
        this.product = product;
        Number = number;
    }

    public Product getProduct() {
        return product;
    }

    public int getNumber() {
        return Number;
    }
}
