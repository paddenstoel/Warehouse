drop table if exists warehouse.tr_suppliers;

create TABLE warehouse.tr_suppliers
(
    id                  uuid         not null primary key unique default uuid_generate_v4(),
    contact_person_name varchar(255) not null,
    city                varchar(255) not null,
    country             varchar(255) not null,
    phone_number        varchar(255) not null,
    organisation_id     uuid,
    foreign key (organisation_id) references warehouse.tr_organisations (id)

);