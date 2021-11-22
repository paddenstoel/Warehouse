package com.petproject.warehouse.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "dd MMMM yyyy", locale = "ru")
    private Date birthDayDate;

}
