package com.petproject.warehouse.dao.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tr_suppliers")
@Getter
@Setter
public class Supplier {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "contact_person_name")
    private String contactPersonName;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "organisation_id")
    private Organisation organisation;

    @OneToMany
    @JoinColumn(name = "supplier_id")
    private List<Product> products;
}
