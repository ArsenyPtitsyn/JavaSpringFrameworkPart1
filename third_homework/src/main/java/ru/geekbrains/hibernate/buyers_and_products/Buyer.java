package ru.geekbrains.hibernate.buyers_and_products;

import javax.persistence.*;

@Entity
@Table(name = "tbl_buyers")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_buyer")
    private Long id;

    @Column(name = "fld_name")
    String name;

    public Buyer() {
    }

    public Buyer(String name) {
        this.name = name;
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
        return String.format("Buyer: %s", name);
    }
}
