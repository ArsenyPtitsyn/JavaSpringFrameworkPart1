package ru.geekbrains.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.mvc.exceptions.GoodNotFoundException;
import ru.geekbrains.spring.mvc.model.Good;
import ru.geekbrains.spring.mvc.repositories.GoodsRepository;

import java.util.List;

@Service
public class GoodsService {
    private GoodsRepository goodsRepository;

    @Autowired
    public void setGoodsRepository(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public List<Good> getAll() {return goodsRepository.findAll();}

    public Good saveOrUpdate(Good good) {
        return goodsRepository.save(good);
    }

    public Good findById(Long id) {
        return goodsRepository.findById(id).orElseThrow(() -> new GoodNotFoundException("Can't found good with id = " + id));
    }

    public Good findByTitle(String title) {
        return goodsRepository.findOneByTitle(title);
    }

    public List<Good> findByMinPrice(int minPrice) {
        return goodsRepository.findAllByPriceGreaterThan(minPrice);
    }

    public Page<Good> findByPage(int pageNumber, int pageSize) {
        return goodsRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public List<Good> findAll() {
        return goodsRepository.findAll(Sort.by("price").ascending());
    }

    public Page<Good> findAll(Specification<Good> spec, Integer page) {
        if (page < 1L) {
            page = 1;
        }
        return goodsRepository.findAll(spec, PageRequest.of(page - 1, 5));
    }
}
