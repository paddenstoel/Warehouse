package com.petproject.warehouse.services;

import com.petproject.warehouse.dao.SupplierRepository;
import com.petproject.warehouse.dao.entities.Customer;
import com.petproject.warehouse.dao.entities.Supplier;
import com.petproject.warehouse.dto.CustomerDto;
import com.petproject.warehouse.dto.SupplierDto;
import javassist.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Log4j2
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierDto> findSuppliersByCityLike(String city) {
        log.info("Method findSuppliersByCityLike was called with string city = {} parameter", city);
        List<Supplier> suppliers = supplierRepository.findByCityLike(city);
        return suppliers.stream()
                .map(this::mapToSupplierDto)
                .collect(Collectors.toList());
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

    private List<SupplierDto> mapListToSupplierDto(List<Supplier> supplierList) {
        List<SupplierDto> dtoList = new ArrayList<>();
        for (Supplier s : supplierList) {
            dtoList.add(mapToSupplierDto(s));
        }
        return dtoList;
    }

    public SupplierDto findById(UUID id) throws NotFoundException {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new NotFoundException("No Supplier with id: " + id));
        return mapToSupplierDto(supplier);
    }

    public List<SupplierDto> findAll() {
        Iterable<Supplier> iterable = supplierRepository.findAll();
        List<Supplier> list = new ArrayList<>();
        for (Supplier s : iterable) {
            list.add(s);
        }
        return mapListToSupplierDto(list);
    }

    public UUID create(SupplierDto dto) {
        Supplier supplier = new Supplier(dto.getContactPersonName(), dto.getCity(), dto.getCountry(), dto.getPhoneNumber());
        return supplierRepository.save(supplier).getId();
    }

    public UUID update(SupplierDto supplierDto) {
        Supplier supplier = supplierRepository.findById(supplierDto.getId())
                .orElseThrow(() -> new IllegalStateException("No Supplier with id: " + supplierDto.getId()));
        return supplierRepository.save(supplier).getId();
    }

    public void delete(UUID id) throws NotFoundException {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new NotFoundException("No Supplier with id: " + id));
        supplierRepository.deleteById(id);
    }
}

