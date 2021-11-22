package com.petproject.warehouse.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDto {

    private UUID id;

    private String lastName;

    private String firstName;

    private String customerContactNumber;

    private String customerAddress;

    private Date birthDayDate;

}
