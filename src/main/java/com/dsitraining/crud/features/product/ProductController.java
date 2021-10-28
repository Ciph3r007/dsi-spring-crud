package com.dsitraining.crud.features.product;

import com.dsitraining.crud.CrudService;
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

    @GetMapping(Routes.INDEX)
    public String showIndex(Model model) {
        model.addAttribute("products", productService.getList());
        model.addAttribute("addProductRoute", Routes.ADD_PRODUCT);
        model.addAttribute("updateProductRoute", Routes.UPDATE_PRODUCT);
        model.addAttribute("deleteProductRoute", Routes.DELETE_PRODUCT);
        model.addAttribute("viewProductRoute", Routes.VIEW_PRODUCT);
        return "index";
    }

    @GetMapping(Routes.VIEW_PRODUCT)
    public String showProductDetails(@PathVariable int id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        model.addAttribute("indexRoute", Routes.INDEX);

        return "product-details";
    }

    @GetMapping(Routes.ADD_PRODUCT)
    public String getCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("indexRoute", Routes.INDEX);
        return "product-form";
    }

    @PostMapping(Routes.ADD_PRODUCT)
    public String submitCreateProductForm(@ModelAttribute Product product) {
        productService.add(product);

        return "redirect:/";
    }

    @GetMapping(Routes.UPDATE_PRODUCT)
    public String getUpdateProductForm(@PathVariable int id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        model.addAttribute("indexRoute", Routes.INDEX);
        return "product-form";
    }

    @PostMapping(Routes.UPDATE_PRODUCT)
    public String submitUpdateProductForm(@PathVariable int id, @ModelAttribute Product product) {
        productService.update(product, id);

        return "redirect:/";
    }

    @GetMapping(Routes.DELETE_PRODUCT)
    public String deleteProduct(@PathVariable int id) {
        productService.delete(id);

        return "redirect:/";
    }
}
