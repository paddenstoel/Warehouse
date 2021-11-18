package com.petproject.warehouse.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tr_organisations")
@Getter
@Setter
@NoArgsConstructor
public class Organisation {

    public Organisation(String organisationName, String country, String phoneNumber, String mainOfficeAddress) {
        this.organisationName = organisationName;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.mainOfficeAddress = mainOfficeAddress;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "organisation_name")
    private String organisationName;

    @Column(name = "country")
    private String country;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "main_office_address")
    private String mainOfficeAddress;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_id")
    private List<Supplier> suppliers;
}
