drop table if exists warehouse.tr_products;

create TABLE warehouse.tr_products
(
    id           uuid         not null primary key unique default uuid_generate_v4(),
    name         varchar(255) not null,
    price        decimal      not null,
    product_unit varchar(255) not null,
    volume       integer,
    supplier_id  uuid,
    foreign key (supplier_id) references warehouse.tr_suppliers (id)
);
