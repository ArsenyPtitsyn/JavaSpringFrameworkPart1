package ru.geekbrains.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.spring.mvc.model.Product;
import ru.geekbrains.spring.mvc.repository.ProductRepository;

import java.util.List;

public class ProductsService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
    }

    public void saveOrUpdateProduct(Product product) {
        productRepository.addOrUpdateProduct(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findProductById(id);
    }
}
