package com.petproject.warehouse.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    private UUID id;

    private String name;

    private double price;

    private String productUnit;

    private int volume;
}
