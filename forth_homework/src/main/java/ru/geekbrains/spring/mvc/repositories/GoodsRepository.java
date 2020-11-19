package ru.geekbrains.spring.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.mvc.model.Good;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Good, Long>, JpaSpecificationExecutor<Good> {
    Good findOneByTitle(String title);
    List<Good> findAllByPriceGreaterThan(int minPrice);
}
