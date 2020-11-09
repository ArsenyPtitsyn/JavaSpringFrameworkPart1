package ru.geekbrains.spring.mvc.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.mvc.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;
    private Long maxID;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>();
        this.products.add(new Product(1L, "Spoon", 125.0f));
        this.products.add(new Product(2L, "Fork", 120.0f));
        this.products.add(new Product(3L, "Knife", 375.0f));
        this.maxID = 3L;
    }

    public List<Product>  findAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product findProductById(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id))
                return p;
        }
        throw new RuntimeException("There are no products with that ID!");
    }

    public void addOrUpdateProduct(Product product) {
        if (product.getId() == null) {
            maxID++;
            product.setId(maxID);
            products.add(product);
        } else {
            for (int i = 0; i < products.size(); i++) {
                if (product.getId().equals(products.get(i).getId()))
                    products.set(i, product);
            }
        }
        throw new RuntimeException("What???");
    }
}
