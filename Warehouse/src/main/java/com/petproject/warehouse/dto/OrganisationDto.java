package com.petproject.warehouse.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class OrganisationDto {

    private UUID id;

    private String organisationName;

    private String country;

    private String phoneNumber;

    private String mainOfficeAddress;
}
