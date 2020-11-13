package ru.geekbrains.hibernate.buyers_and_products;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_order_details")
public class OrderDetails {

    @EmbeddedId
    private Order order;

    @EmbeddedId
    private Product product;

    @Column(name = "fld_number_of_items")
    private byte numberOfItems;

    public OrderDetails() {
    }

    public OrderDetails(Order order, Product product, byte numberOfItems) {
        this.order = order;
        this.product = product;
        this.numberOfItems = numberOfItems;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public byte getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(byte numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
}
