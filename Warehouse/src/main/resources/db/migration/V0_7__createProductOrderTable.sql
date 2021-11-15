drop table if exists warehouse.tr_products_orders;

create TABLE warehouse.tl_products_orders
(
    product_id uuid not null,
    order_id   uuid not null,
    foreign key (order_id) references warehouse.tr_orders (id),
    foreign key (product_id) references warehouse.tr_products (id)
);