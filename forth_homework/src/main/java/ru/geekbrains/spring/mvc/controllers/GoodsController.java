package ru.geekbrains.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.mvc.model.Good;
import ru.geekbrains.spring.mvc.repositories.specifications.GoodsSpecifications;
import ru.geekbrains.spring.mvc.services.GoodsService;

import java.util.List;

// root: http://localhost:8189/app/goods

@Controller
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping
    public String showAllGoods(Model model,
                                  @RequestParam(name = "p", defaultValue = "1") Integer pageNumber,
                                  @RequestParam(name = "min_price", required = false) Integer minPrice,
                                  @RequestParam(name = "max_price", required = false) Integer maxPrice) {
        Specification<Good> spec = Specification.where(null);
        if (minPrice != null) {
            spec = spec.and(GoodsSpecifications.priceGEThan(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(GoodsSpecifications.priceLEThan(maxPrice));
        }

        List<Good> goods = goodsService.findAll(spec, pageNumber).getContent();
        model.addAttribute("goods", goods);
        return "all_goods";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add_good_form";
    }

    @PostMapping("/add")
    public String saveNewGood(@ModelAttribute Good newGood) {
        goodsService.saveOrUpdate(newGood);
        return "redirect:/goods/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("good", goodsService.findById(id));
        return "edit_good_form";
    }

    @PostMapping("/edit")
    public String modifyGood(@ModelAttribute Good modifiedGood) {
        goodsService.saveOrUpdate(modifiedGood);
        return "redirect:/goods/";
    }

    @GetMapping("/info_by_title")
    @ResponseBody
    public Good infoByName(@RequestParam String title) {
        return goodsService.findByTitle(title);
    }

    @GetMapping("/find_by_min_price")
    @ResponseBody
    public List<Good> findGoodsByMinPrice(@RequestParam int price) {
        return goodsService.findByMinPrice(price);
    }
}