package ru.geekbrains.hibernate.shop;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long id;

    @Column(name = "fld_name")
    private String name;

    @ManyToMany
    @JoinTable(
        name = "tbl_orders",
        joinColumns = @JoinColumn(name = "id_customer"),
        inverseJoinColumns =@JoinColumn(name = "id_good")
    )
    private List<Good> goods;

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Customer: %s", name);
    }
}
