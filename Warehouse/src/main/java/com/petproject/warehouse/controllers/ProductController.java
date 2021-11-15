package com.petproject.warehouse.controllers;

import com.petproject.warehouse.services.ProductService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> get() {
        log.info("Method get of Product controller is working");
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable String id) {
        log.info("Method get of Product controller is working");
        return new ResponseEntity<>("Hello " + id, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody Test test) {
        log.info("Method post of Product controller is working");
        return new ResponseEntity<>(test.getTest(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PutMapping("/")
    public @ResponseBody
    String update(@RequestParam(value = "something") String something) {
        log.info("Method put of Product controller is working");
        return "ok";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable String id) {
        log.info("Method delete of Product controller is working");
        boolean isRemoved = true;
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @Getter
    @Setter
    private static class Test {
        private String test;

    }
}
