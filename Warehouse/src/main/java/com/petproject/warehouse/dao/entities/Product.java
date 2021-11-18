package com.petproject.warehouse.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tr_products")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    public Product(String name, double price, String productUnit, int volume) {
        this.name = name;
        this.price = price;
        this.productUnit = productUnit;
        this.volume = volume;
    }

    @Column(name = "price")
    private double price;

    @Column(name = "product_unit")
    private String productUnit;

    @Column(name = "volume")
    private int volume;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            schema = "warehouse",
            name = "tl_products_orders",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;
}
