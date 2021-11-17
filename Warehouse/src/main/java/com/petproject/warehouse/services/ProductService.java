package com.petproject.warehouse.services;

import com.petproject.warehouse.dao.ProductRepository;
import com.petproject.warehouse.dao.entities.Product;
import com.petproject.warehouse.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDto mapToProductDto(Product productEntity) {
        ProductDto dto = new ProductDto();
        dto.setId(productEntity.getId());
        dto.setName(productEntity.getName());
        dto.setProductUnit(productEntity.getProductUnit());
        dto.setPrice(productEntity.getPrice());
        dto.setVolume(productEntity.getVolume());
        return dto;
    }

    public Product mapToProductEntity(ProductDto dto) {
        Product productEntity = new Product();
        productEntity.setId(dto.getId());
        productEntity.setProductUnit(dto.getProductUnit());
        productEntity.setPrice(dto.getPrice());
        productEntity.setVolume(dto.getVolume());
        productEntity.setName(dto.getName());
        return productEntity;
    }
}
