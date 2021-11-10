drop table if exists warehouse.tr_orders;

create TABLE warehouse.tr_orders
(
    id          uuid    not null primary key unique default uuid_generate_v4(),
    quantity    integer not null,
    order_date  date    not null,
    customer_id uuid,
    foreign key (customer_id) references warehouse.tr_customers (id)

);