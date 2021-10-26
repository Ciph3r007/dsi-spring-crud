package com.dsitraining.crud;

import com.dsitraining.crud.product.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    List<Product> products = Arrays.asList(
            new Product("Razer Deathadder Chroma", 59, 2),
            new Product("PlayStation 5", 999, 1),
            new Product("RTX 3090", 1299, 5)
    );

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

    private Product getProductById(int id) {
        for (var product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }
}
