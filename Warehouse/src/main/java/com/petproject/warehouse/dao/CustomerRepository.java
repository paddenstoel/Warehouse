package com.petproject.warehouse.dao;

import com.petproject.warehouse.dao.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {

    //TODO получить всех у кого начинается имя с буквы
    List<Customer> findByFirstNameStartingWith(String firstName);

    //TODO получить всех у кого пустой адрес
    List<Customer> findByCustomerAddressIsNull();

    //TODO получить всех у кого фамилия длинее 5 символов
    List<Customer> findByLastNameGreaterThan(String lastName);

    @Query(
            value = "select * from warehouse.tr_customers c where date_part('day', c.birth_day_date) = date_part('day', current_date) AND date_part('month', c.birth_day_date) = date_part('month', current_date)",
            nativeQuery = true)
    List<Customer> findCustomersByBirthDayDate();
}