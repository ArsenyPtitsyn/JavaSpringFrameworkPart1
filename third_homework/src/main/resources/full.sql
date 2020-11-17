BEGIN;

DROP TABLE IF EXISTS shop.tbl_customers CASCADE;
CREATE TABLE tbl_customers (id_customer bigserial,
fld_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
CONSTRAINT tbl_customers_pkey PRIMARY KEY (id_customer));
INSERT INTO tbl_customers (fld_name) VALUES
('Vladimir'), ('Anna'), ('Ludmila'), ('Ekaterina');

DROP TABLE IF EXISTS tbl_goods CASCADE;
CREATE TABLE shop.tbl_goods (id_good bigserial,
fld_good_title character varying(255) COLLATE pg_catalog."default" NOT NULL,
fld_cost integer NOT NULL, CONSTRAINT tbl_goods_pkey PRIMARY KEY (id_good));
INSERT INTO tbl_goods (fld_good_title, fld_cost) VALUES
('shirt', 2570), ('socks', 380), ('trousers', 4525), ('short socks', 260),
('coat', 10350);

DROP TABLE IF EXISTS tbl_orders CASCADE;
CREATE TABLE shop.tbl_orders
(
    id_customer bigint NOT NULL,
    id_good bigint NOT NULL,
    fld_date date NOT NULL,
    fld_time time without time zone NOT NULL,
    fld_amount_of_goods smallint NOT NULL,
    CONSTRAINT tbl_orders_id_customer_fkey FOREIGN KEY (id_customer)
        REFERENCES shop.tbl_customers (id_customer) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT tbl_orders_id_good_fkey FOREIGN KEY (id_good)
        REFERENCES shop.tbl_goods (id_good) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);
INSERT INTO tbl_orders (id_customer, id_good, fld_date, fld_time,
fld_amount_of_goods) VALUES
(1, 2, '2020-03-15', '13:25:15', 5),
(1, 3, '2019-12-29', '15:15:15', 2),
(1, 4, '2020-10-17', '16:01:12', 8),
(2, 1, '2020-02-18', '17:43:17', 3),
(2, 5, '2020-05-11', '18:03:46', 1),
(2, 4, '2020-11-07', '19:32:21', 25),
(2, 3, '2020-01-05', '13:27:53', 3),
(3, 1, '2020-09-23', '19:39:18', 2),
(3, 2, '2020-07-31', '15:59:33', 1),
(3, 5, '2020-08-12', '14:53:25', 2),
(4, 1, '2020-06-25', '16:25:13', 5),
(4, 2, '2020-01-27', '17:48:24', 4),
(4, 3, '2020-05-04', '18:37:11', 4),
(4, 4, '2020-04-14', '09:15:24', 12);
