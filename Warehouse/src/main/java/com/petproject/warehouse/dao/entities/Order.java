package com.petproject.warehouse.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tr_orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "order_date")
    private Date orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private List<Product> products;

    public Order(int quantity, Date orderDate) {
        this.quantity = quantity;
        this.orderDate = orderDate;
    }
}