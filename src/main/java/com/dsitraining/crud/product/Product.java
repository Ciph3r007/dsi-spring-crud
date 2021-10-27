package com.dsitraining.crud.product;

public class Product {
    private static int counter;
    private int id;
    private String name;
    private Double price;
    private Integer quantity;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product() {
        ++counter;
        this.id = counter;
    }

    public Product(String name, Double price, Integer quantity) {
        this();
        this.name = name;
        this.price = price;
        this.setQuantity(quantity);
    }

    @Override
    public String toString() {
        return this.name + this.price;
    }
}
