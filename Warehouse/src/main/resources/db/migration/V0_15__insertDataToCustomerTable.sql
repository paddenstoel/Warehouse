insert into warehouse.tr_customers (id, last_name, first_name, customer_contact_number, customer_address,
                                    birth_day_date)
values (uuid_generate_v4(), 'Wonka', 'Willy', '+4545454545', '813 Howard Street Oswego NY 13126',
        '1988-10-18'),
       (uuid_generate_v4(), 'Heisenberg', 'Ed', '+654789521',
        '4565 Coventry Court City Gulfport State/Province abbr MS State/Province full Mississippi Zip Code/Postal code 39501',
        now()::date),
       (uuid_generate_v4(), 'Zillibobka', 'Zilly', '+88989858', null, '1965-02-10')