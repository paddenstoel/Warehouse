package com.petproject.warehouse.services;

import com.petproject.warehouse.dao.SupplierRepository;
import com.petproject.warehouse.dao.entities.Supplier;
import com.petproject.warehouse.dto.SupplierDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> findSuppliersByCityLike(String city) {
        log.info("Method findSuppliersByCityLike was called with string city = {} parameter", city);
        return supplierRepository.findByCityLike(city);
    }

    public SupplierDto mapToSupplierDto(Supplier supplierEntity) {
        SupplierDto dto = new SupplierDto();
        dto.setId(supplierEntity.getId());
        dto.setCity(supplierEntity.getCity());
        dto.setCountry(supplierEntity.getCountry());
        dto.setContactPersonName(supplierEntity.getContactPersonName());
        dto.setPhoneNumber(supplierEntity.getPhoneNumber());
        return dto;
    }

    public Supplier mapToSupplierEntity(SupplierDto dto) {
        Supplier supplierEntity = new Supplier();
        supplierEntity.setId(dto.getId());
        supplierEntity.setCity(dto.getCity());
        supplierEntity.setCountry(dto.getCountry());
        supplierEntity.setContactPersonName(dto.getContactPersonName());
        supplierEntity.setPhoneNumber(dto.getPhoneNumber());
        return supplierEntity;
    }
}

