package com.dsitraining.crud.features.product;

import com.dsitraining.crud.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements CrudService<Product> {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        add(new Product("Razer Deathadder Chroma", 59, 2));
        add(new Product("RTX 3090", 1299, 5));
        add(new Product("PlayStation 5", 999, 1));
    }

    public List<Product> getList() {
        return productRepository.findAll();
    }

    public void add(Product product) {
        productRepository.save(product);
    }

    public void update(Product productWithUpdate, int id) {
        var product = productRepository.getById(id);
        product.setName(productWithUpdate.getName());
        product.setPrice(productWithUpdate.getPrice());
        product.setQuantity(productWithUpdate.getQuantity());
        productRepository.save(product);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }

    public Product getById(int id) {
        return productRepository.getById(id);
    }
}
