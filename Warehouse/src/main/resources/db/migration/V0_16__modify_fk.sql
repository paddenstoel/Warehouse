alter table warehouse.tl_products_orders
    drop constraint tl_products_orders_order_id_fkey;

alter table warehouse.tl_products_orders
    add constraint tl_products_orders_order_id_fkey
        foreign key (order_id) references warehouse.tr_orders
            on delete cascade;

