package com.petproject.warehouse.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/organisations")
public class OrganisationController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> get() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable String id) {
        return new ResponseEntity<>("Hello " + id, HttpStatus.OK);
    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//
//    @RequestMapping(value = "/", method = RequestMethod.DELETE)
}
