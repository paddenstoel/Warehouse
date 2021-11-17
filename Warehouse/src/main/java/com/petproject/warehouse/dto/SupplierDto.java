package com.petproject.warehouse.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class SupplierDto {

    private UUID id;

    private String contactPersonName;

    private String city;

    private String country;

    private String phoneNumber;
}
