package com.petproject.warehouse.services;

import com.petproject.warehouse.dao.OrganisationRepository;
import com.petproject.warehouse.dao.entities.Organisation;
import com.petproject.warehouse.dto.OrganisationDto;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class OrganisationService {

    private final OrganisationRepository organisationRepository;

    @Autowired
    public OrganisationService(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    public OrganisationDto mapToOrganisationDto(Organisation organisationEntity) {
        OrganisationDto dto = new OrganisationDto();
        dto.setId(organisationEntity.getId());
        dto.setOrganisationName(organisationEntity.getOrganisationName());
        dto.setCountry(organisationEntity.getCountry());
        dto.setPhoneNumber(organisationEntity.getPhoneNumber());
        dto.setMainOfficeAddress(organisationEntity.getMainOfficeAddress());
        return dto;
    }

    public Organisation mapToOrderEntity(OrganisationDto dto) {
        Organisation organisationEntity = new Organisation();
        organisationEntity.setId(dto.getId());
        organisationEntity.setOrganisationName(dto.getOrganisationName());
        organisationEntity.setCountry(dto.getCountry());
        organisationEntity.setPhoneNumber(dto.getPhoneNumber());
        organisationEntity.setMainOfficeAddress(dto.getMainOfficeAddress());
        return organisationEntity;
    }

    private List<OrganisationDto> mapListToOrganisationDto(List<Organisation> organisationList) {
        List<OrganisationDto> dtoList = new ArrayList<>();
        for (Organisation c : organisationList) {
            dtoList.add(mapToOrganisationDto(c));
        }
        return dtoList;
    }

    public OrganisationDto findById(UUID id) throws NotFoundException {
        Organisation organisation = organisationRepository.findById(id).orElseThrow(() -> new NotFoundException("No Organisation with id: " + id));
        return mapToOrganisationDto(organisation);
    }

    public List<OrganisationDto> findAll() {
        Iterable<Organisation> iterable = organisationRepository.findAll();
        List<Organisation> list = new ArrayList<>();
        for (Organisation o : iterable) {
            list.add(o);
        }
        return mapListToOrganisationDto(list);
    }

    public UUID create(OrganisationDto dto) {
        Organisation organisation = new Organisation(dto.getOrganisationName(), dto.getCountry(), dto.getPhoneNumber(), dto.getMainOfficeAddress());
        return organisationRepository.save(organisation).getId();
    }

    public UUID update(OrganisationDto organisationDto) {
        Organisation organisation = organisationRepository.findById(organisationDto.getId())
                .orElseThrow(() -> new IllegalStateException("No Organisation with id: " + organisationDto.getId()));
        return organisationRepository.save(organisation).getId();
    }

    public void delete(UUID id) throws NotFoundException {
        Organisation organisation = organisationRepository.findById(id).orElseThrow(() -> new NotFoundException("No Organisation with id: " + id));
        organisationRepository.deleteById(id);
    }

}
