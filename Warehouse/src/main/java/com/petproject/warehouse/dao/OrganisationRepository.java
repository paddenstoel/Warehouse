package com.petproject.warehouse.dao;

import com.petproject.warehouse.dao.entities.Organisation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganisationRepository extends CrudRepository<Organisation, UUID> {

}
