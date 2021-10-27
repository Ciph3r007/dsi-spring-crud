package com.dsitraining.crud.product;

public class Product {
    private static int counter;
    private int id;
    private String name;
    private Integer price;
    private Integer quantity;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product() {
    }

    public Product(String name, Integer price, Integer quantity) {
        ++counter;
        this.id = counter;
        this.name = name;
        this.price = price;
        this.setQuantity(quantity);
    }

    public void addId() {
        if (id != 0)
            throw new IllegalStateException("Id already set and can't be changed!");
        counter++;
        id = counter;
    }
}
