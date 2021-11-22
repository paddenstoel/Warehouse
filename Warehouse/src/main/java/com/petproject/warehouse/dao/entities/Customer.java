package com.petproject.warehouse.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tr_customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "customer_contact_number")
    private String customerContactNumber;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "birth_day_date")
    private Date birthDayDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private List<Order> orders;

    public Customer(String lastName, String firstName, String customerContactNumber, String customerAddress) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.customerContactNumber = customerContactNumber;
        this.customerAddress = customerAddress;
    }
}
