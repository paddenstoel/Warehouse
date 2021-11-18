package com.petproject.warehouse.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tr_suppliers")
@Getter
@Setter
@NoArgsConstructor
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_id")
    private Organisation organisation;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private List<Product> products;

    public Supplier(String contactPersonName, String city, String country, String phoneNumber) {
        this.contactPersonName = contactPersonName;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }
}
