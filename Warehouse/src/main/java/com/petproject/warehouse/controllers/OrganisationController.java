package com.petproject.warehouse.controllers;

import com.petproject.warehouse.dto.OrganisationDto;
import com.petproject.warehouse.services.OrganisationService;
import javassist.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@Log4j2
@RequestMapping("/organisations")
public class OrganisationController {

    private final OrganisationService organisationService;

    @Autowired
    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @RequestMapping("/lombok")
    public String index() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable UUID id) throws NotFoundException {
        log.info("Method getById of Organisation controller is working");
        log.debug("Get Organisation with id: {}", id);
        return new ResponseEntity<>(organisationService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        log.debug("Getting all Organisations");
        log.info("Method getAll of Organisation controller is working");
        return new ResponseEntity<>(organisationService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@PathVariable OrganisationDto organisationDto) {
        log.info("Method create of Organisation controller is working");
        log.debug("Create new Organisation: {}", organisationDto);
        organisationService.create(organisationDto);
        return new ResponseEntity<>(organisationDto.getId(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody
    UUID update(@RequestBody OrganisationDto organisationDto) {
        log.info("Method update of Organisation controller is working");
        log.debug("Update Organisation: {}", organisationDto);
        return organisationService.update(organisationDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable UUID id) throws NotFoundException {
        log.info("Method delete of Organisation controller is working");
        log.debug("Delete Organisation with id: {}", id);
        organisationService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
