drop table if exists warehouse.tr_customers;

create TABLE warehouse.tr_customers
(
    id                      uuid         not null primary key unique default uuid_generate_v4(),
    last_name               varchar(255) not null,
    first_name              varchar(255) not null,
    customer_contact_number varchar(255) not null,
    customer_address        text
);