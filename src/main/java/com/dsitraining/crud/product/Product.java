package com.dsitraining.crud.product;

public class Product {
    private static int counter;
    private int id;
    private String name;
    private int price;
    public int quantity;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Product(String name, int price, int quantity) {
        ++counter;
        this.id = counter;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
