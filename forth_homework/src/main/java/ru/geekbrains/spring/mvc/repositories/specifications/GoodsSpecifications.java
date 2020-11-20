package ru.geekbrains.spring.mvc.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.spring.mvc.model.Good;

public class GoodsSpecifications {
    public static Specification<Good> priceGEThan(int minPrice) {
        return (Specification<Good>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Good> priceLEThan(int maxPrice) {
        return (Specification<Good>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }
}
