BEGIN;

DROP TABLE IF EXISTS goods CASCADE;
CREATE TABLE goods (id bigserial PRIMARY KEY, title VARCHAR(255), price integer);
INSERT INTO goods (title, price) VALUES
('Coat', 15000),
('Fur coat', 200000),
('Shirt', 3000),
('Sweater', 8000),
('Skirt', 3500),
('Men''s socks', 350),
('Women''s socks', 320),
('knee socks', 1500),
('Shorts', 1700),
('Jacket', 7000);

DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES
('Alexander'),
('Evgeniy'),
('Ekaterina'),
('Valentin');

DROP TABLE IF EXISTS goods_customers CASCADE;
CREATE TABLE goods_customers (good_id bigint, customer_id bigint, FOREIGN KEY (good_id) REFERENCES goods (id),
FOREIGN KEY (customer_id) REFERENCES customers (id));
INSERT INTO goods_customers (good_id, customer_id) VALUES
(1, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(1, 2),
(2, 2),
(3, 2),
(2, 3),
(7, 3),
(8, 3),
(9, 3),
(10, 3),
(2, 4),
(8, 4),
(9, 4),
(10, 4);

COMMIT;
