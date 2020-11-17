package ru.geekbrains.hibernate.shop;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_goods")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fld_good_title")
    private String title;

    @Column(name = "fld_cost")
    private float cost;

    @ManyToMany
    @JoinTable(
        name = "tbl_orders",
        joinColumns = @JoinColumn(name = "id_good"),
        inverseJoinColumns = @JoinColumn(name = "id_customer")
    )
    private List<Customer> customers;

    public Good() {
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
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

    public float getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("Good title: %s, product price: %f", title, cost);
    }
}
