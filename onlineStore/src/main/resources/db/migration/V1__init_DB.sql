-- Удаление существующих таблиц и последовательностей
DROP TABLE IF EXISTS products_categories CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP SEQUENCE IF EXISTS bucket_seq;
DROP SEQUENCE IF EXISTS category_seq;
DROP SEQUENCE IF EXISTS order_details_seq;
DROP SEQUENCE IF EXISTS order_seq;
DROP SEQUENCE IF EXISTS product_seq;
DROP SEQUENCE IF EXISTS user_seq;

-- Создание новой последовательности
CREATE SEQUENCE bucket_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE category_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE order_details_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE order_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE product_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;

-- Создание таблиц
CREATE TABLE buckets (
                         id BIGINT NOT NULL,
                         user_id BIGINT UNIQUE,
                         PRIMARY KEY (id)
);

CREATE TABLE buckets_products (
                                  bucket_id BIGINT NOT NULL,
                                  product_id BIGINT NOT NULL
);

CREATE TABLE categories (
                            id BIGINT NOT NULL,
                            title VARCHAR(255),
                            PRIMARY KEY (id)
);

CREATE TABLE orders (
                        sum NUMERIC(38,2),
                        created TIMESTAMP(6),
                        id BIGINT NOT NULL,
                        updated TIMESTAMP(6),
                        user_id BIGINT,
                        address VARCHAR(255),
                        status VARCHAR(255) CHECK (status IN ('NEW', 'APPROVED', 'CANCELLED', 'PAID', 'CLOSED')),
                        PRIMARY KEY (id)
);

CREATE TABLE orders_details (
                                amount NUMERIC(38,2),
                                price NUMERIC(38,2),
                                details_id BIGINT NOT NULL UNIQUE,
                                id BIGINT NOT NULL,
                                order_id BIGINT,
                                product_id BIGINT,
                                PRIMARY KEY (id)
);

CREATE TABLE products (
                          price NUMERIC(38,2),
                          id BIGINT NOT NULL,
                          title VARCHAR(255),
                          PRIMARY KEY (id)
);

CREATE TABLE products_categories (
                                     category_id BIGINT NOT NULL,
                                     product_id BIGINT NOT NULL
);

CREATE TABLE users (
                       archive BOOLEAN NOT NULL,
                       bucket_id BIGINT UNIQUE,
                       id BIGINT NOT NULL,
                       email VARCHAR(255),
                       name VARCHAR(255),
                       password VARCHAR(255),
                       role VARCHAR(255) CHECK (role IN ('CLIENT', 'MANAGER', 'ADMIN')),
                       PRIMARY KEY (id)
);

-- Добавление внешних ключей
ALTER TABLE IF EXISTS buckets ADD CONSTRAINT buckets_fk_user FOREIGN KEY (user_id) REFERENCES users;
ALTER TABLE IF EXISTS buckets_products ADD CONSTRAINT buckets_fk_product FOREIGN KEY (product_id) REFERENCES products;
ALTER TABLE IF EXISTS buckets_products ADD CONSTRAINT bucket_fk_bucket FOREIGN KEY (bucket_id) REFERENCES buckets;
ALTER TABLE IF EXISTS orders ADD CONSTRAINT order_fk_user FOREIGN KEY (user_id) REFERENCES users;
ALTER TABLE IF EXISTS orders_details ADD CONSTRAINT order_fk_orders FOREIGN KEY (order_id) REFERENCES orders;
ALTER TABLE IF EXISTS orders_details ADD CONSTRAINT order_fk_product FOREIGN KEY (product_id) REFERENCES products;
ALTER TABLE IF EXISTS orders_details ADD CONSTRAINT order_fk_order_detail FOREIGN KEY (details_id) REFERENCES orders_details;
ALTER TABLE IF EXISTS products_categories ADD CONSTRAINT product_fk_category FOREIGN KEY (category_id) REFERENCES categories;
ALTER TABLE IF EXISTS products_categories ADD CONSTRAINT product_fk_product FOREIGN KEY (product_id) REFERENCES products;
ALTER TABLE IF EXISTS users ADD CONSTRAINT user_fk_bucket FOREIGN KEY (bucket_id) REFERENCES buckets;