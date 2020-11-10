package ru.geekbrains.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.spring.mvc.model.Product;
import ru.geekbrains.spring.mvc.service.ProductsService;

import java.util.List;

// root:  http://localhost:8189/app/products

@Controller
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String showAllStudents(Model model) {
        List<Product> products = productsService.getAllProducts();
        model.addAttribute("products", products);
        return "all_products";
    }
}
