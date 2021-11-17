package com.petproject.warehouse.services;

import com.petproject.warehouse.dao.OrganisationRepository;
import com.petproject.warehouse.dao.entities.Organisation;
import com.petproject.warehouse.dto.OrganisationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

}
