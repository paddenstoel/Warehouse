package com.petproject.warehouse.services;

import com.petproject.warehouse.dao.ProductRepository;
import com.petproject.warehouse.dao.entities.Product;
import com.petproject.warehouse.dto.ProductDto;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    private List<ProductDto> mapListToProductDto(List<Product> productList) {
        List<ProductDto> dtoList = new ArrayList<>();
        for (Product p : productList) {
            dtoList.add(mapToProductDto(p));
        }
        return dtoList;
    }

    public ProductDto findById(UUID id) throws NotFoundException {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("No Product with id: " + id));
        return mapToProductDto(product);
    }

    public List<ProductDto> findAll() {
        Iterable<Product> iterable = productRepository.findAll();
        List<Product> list = new ArrayList<>();
        for (Product p : iterable) {
            list.add(p);
        }
        return mapListToProductDto(list);
    }

    public UUID create(ProductDto dto) {
        Product product = new Product(dto.getName(), dto.getPrice(), dto.getProductUnit(), dto.getVolume());
        return productRepository.save(product).getId();
    }

    public void delete(UUID id) throws NotFoundException {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("No Product with id: " + id));
        productRepository.deleteById(id);
    }
}
