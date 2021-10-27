package com.dsitraining.crud;

import com.dsitraining.crud.product.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    private final CrudService<Product> productService;

    public ProductController(CrudService<Product> productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String showIndex(Model model) {
        model.addAttribute("products", productService.getList());
        model.addAttribute("addProductRoute", Routes.ADD_PRODUCT);
        return "index";
    }

    @GetMapping("/products/{id}")
    public String showProductDetails(@PathVariable int id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);

        return "product-details";
    }

    @GetMapping(Routes.ADD_PRODUCT)
    public String getCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping(Routes.ADD_PRODUCT)
    public String submitCreateProductForm(@ModelAttribute Product product) {
        productService.add(product);

        return "redirect:/";
    }

    @GetMapping("/products/{id}/update")
    public String getUpdateProductForm(@PathVariable int id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "product-form";
    }

    @PostMapping("/products/{id}/update")
    public String submitUpdateProductForm(@PathVariable int id, @ModelAttribute Product product) {
        productService.update(product, id);

        return "redirect:/";
    }

    @GetMapping("/products/{id}/delete")
    public String deleteProduct(@PathVariable int id) {
        productService.delete(id);

        return "redirect:/";
    }
}
