package com.petproject.warehouse.services;

import com.petproject.warehouse.dao.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfig {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final OrganisationRepository organisationRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public ContextConfig(CustomerRepository customerRepository, OrderRepository orderRepository, OrganisationRepository organisationRepository, ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.organisationRepository = organisationRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @Bean
    public CustomerService customerServiceBean() {
        return new CustomerService(customerRepository);
    }

    @Bean
    public OrderService orderServiceBean() {
        return new OrderService(orderRepository);
    }

    @Bean
    public OrganisationService organisationServiceBean() {
        return new OrganisationService(organisationRepository);
    }

    @Bean
    public ProductService productServiceBean() {
        return new ProductService(productRepository);
    }

    @Bean
    public SupplierService supplierServiceBean() {
        return new SupplierService(supplierRepository);
    }

    @Bean
    public EMailSender eMailSender() {
        return new EMailSender();
    }

    @Bean
    public SmsSender smsSender() {
        return new SmsSender();
    }

}

