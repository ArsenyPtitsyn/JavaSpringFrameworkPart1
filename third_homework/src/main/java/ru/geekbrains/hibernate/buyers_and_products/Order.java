package ru.geekbrains.hibernate.buyers_and_products;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "tbl_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fld_date")
    private Date date;

    @Column(name = "fld_time")
    private Time time;

    @ManyToOne
    @JoinColumn(name = "id_buyer")
    private Buyer buyer;

    public Order() {
    }

    public Order(Date date, Time time, Buyer buyer) {
        this.date = date;
        this.time = time;
        this.buyer = buyer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "Order id: " + id + ", order date: " + date
                + ", order time: " + time + ", order owner: " + buyer;
    }
}
