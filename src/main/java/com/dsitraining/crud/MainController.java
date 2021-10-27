package com.dsitraining.crud;

import com.dsitraining.crud.product.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("Razer Deathadder Chroma", 59.0, 2),
            new Product("PlayStation 5", 999.0, 1),
            new Product("RTX 3090", 1299.0, 5)
    ));

    @GetMapping("")
    public String showIndex(Model model) {
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/product/{id}")
    public String showProductDetails(@PathVariable int id, Model model) {
        Product product = getProductById(id);
        model.addAttribute("product", product);

        return "product-details";
    }

    @GetMapping("/add-product")
    public String getCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/add-product")
    public String submitCreateProductForm(@ModelAttribute Product product, Model model) {
        products.add(product);
        model.addAttribute("products", products);

        return "index";
    }


    private Product getProductById(int id) {
        for (var product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }
}
