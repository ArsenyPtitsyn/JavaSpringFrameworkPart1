package ru.geekbrains.hibernate.buyers_and_products;

import javax.persistence.*;

@Entity
@Table(name = "tbl_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fld_title")
    private String title;

    @Column(name = "fld_cost")
    private float price;

    @Override
    public String toString() {
        return String.format("Product title: %s, product price: %f", title, price);
    }

    public Product() {
    }

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
