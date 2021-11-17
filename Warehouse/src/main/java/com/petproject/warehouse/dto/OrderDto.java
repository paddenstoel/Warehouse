package com.petproject.warehouse.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private UUID id;

    private int quantity;

    private Date orderDate;
}
