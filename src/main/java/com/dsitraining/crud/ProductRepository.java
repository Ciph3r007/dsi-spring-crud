package com.dsitraining.crud;

import com.dsitraining.crud.product.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private int counter = 0;
    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
        add(new Product("Razer Deathadder Chroma", 59, 2));
        add(new Product("PlayStation 5", 999, 1));
        add(new Product("RTX 3090", 1299, 5));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void add(Product product) {
        product.setId(++counter);
        products.add(product);
    }

    public void update(Product product, int id) {
        int index = this.getIndexById(id);
        product.setId(id);
        products.set(index, product);
    }

    public void delete(int id) {
        Product product = getById(id);
        products.remove(product);
    }

    public int getIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }

    public Product getById(int id) {
        for (var product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }
}
