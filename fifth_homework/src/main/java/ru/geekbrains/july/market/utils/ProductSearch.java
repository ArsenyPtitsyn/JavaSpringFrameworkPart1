package ru.geekbrains.july.market.utils;

import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.july.market.entities.Product;
import ru.geekbrains.july.market.repositories.specifications.ProductSpecifications;

import java.util.Map;

@Getter
public class ProductSearch {
    private Specification<Product> spec;
    private StringBuilder searchDefinition;

    public ProductSearch(Map<String, String> map) {
        this.spec = Specification.where(null);
        this.searchDefinition = new StringBuilder();
        if (map.containsKey("search_string") && !map.get("search_string").isEmpty()) {
            String searchString = map.get("search_string");
            spec = spec.and(ProductSpecifications.searchProduct(searchString));
            searchDefinition.append("&search_string=").append(searchString);
        }
    }
}