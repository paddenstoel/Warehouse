drop table if exists warehouse.tr_organisations;

create TABLE warehouse.tr_organisations
(
    id                  uuid         not null primary key unique default uuid_generate_v4(),
    organisation_name   varchar(255) not null,
    country             varchar(255) not null,
    phone_number        varchar(255) not null,
    main_office_address text         not null
);