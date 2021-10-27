package com.dsitraining.crud;

import com.dsitraining.crud.product.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService implements CrudService<Product> {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getList() {
        return productRepository.getProducts();
    }

    public void add(Product product) {
        if (product.getPrice() < 100)
            return;
        productRepository.add(product);
    }

    public void update(Product product, int id) {
        productRepository.update(product, id);
    }

    public void delete(int id) {
        productRepository.delete(id);
    }

    public Product getById(int id) {
        return productRepository.getById(id);
    }
}
