package com.dsitraining.crud;

import com.dsitraining.crud.product.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

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
}
