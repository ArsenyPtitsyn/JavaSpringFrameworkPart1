CREATE TABLE shop.tbl_buyers
(
    id_buyer bigint NOT NULL DEFAULT nextval('shop.tbl_buyers_id_buyer_seq'::regclass),
    fld_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tbl_buyers_pkey PRIMARY KEY (id_buyer)
)

TABLESPACE pg_default;

ALTER TABLE shop.tbl_buyers
    OWNER to postgres;



CREATE TABLE shop.tbl_products
(
    fld_title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    fld_cost integer NOT NULL,
    id_product bigint NOT NULL DEFAULT nextval('shop.tbl_products_id_product_seq'::regclass),
    CONSTRAINT tbl_products_pkey PRIMARY KEY (id_product)
)

TABLESPACE pg_default;

ALTER TABLE shop.tbl_products
    OWNER to postgres;



CREATE TABLE shop.tbl_orders
(
    id_order bigint NOT NULL DEFAULT nextval('shop.tbl_orders_id_order_seq'::regclass),
    fld_date date NOT NULL,
    fld_time time without time zone NOT NULL,
    id_buyer bigint NOT NULL,
    CONSTRAINT tbl_orders_pkey PRIMARY KEY (id_order),
    CONSTRAINT tbl_orders_id_buyer_fkey FOREIGN KEY (id_buyer)
        REFERENCES shop.tbl_buyers (id_buyer) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE shop.tbl_orders
    OWNER to postgres;



CREATE TABLE shop.tbl_order_details
(
    id_order bigint NOT NULL,
    id_product bigint NOT NULL,
    fld_number_of_items smallint NOT NULL,
    CONSTRAINT tbl_order_details_pkey PRIMARY KEY (id_order, id_product),
    CONSTRAINT tbl_order_details_id_order_fkey FOREIGN KEY (id_order)
        REFERENCES shop.tbl_orders (id_order) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT tbl_order_details_id_product_fkey FOREIGN KEY (id_product)
        REFERENCES shop.tbl_products (id_product) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE shop.tbl_order_details
    OWNER to postgres;