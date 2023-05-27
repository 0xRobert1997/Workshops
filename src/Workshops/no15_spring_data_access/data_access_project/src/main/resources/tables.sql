CREATE TABLE customer (
id SERIAL,
user_name VARCHAR(255) UNIQUE NOT NULL,
email VARCHAR(255) UNIQUE NOT NULL,
name VARCHAR(255) NOT NULL,
surname VARCHAR(255) NOT NULL,
date_of_birth DATE NOT NULL,
telephone_number VARCHAR(64) NOT NULL,
primary key (ID)
);

CREATE TABLE producer (
id SERIAL primary KEY,
producer_name VARCHAR(255) UNIQUE NOT NULL,
address VARCHAR(255)
)

CREATE TABLE product (
id serial primary key,
product_code VARCHAR(255) UNIQUE NOT NULL,
product_name VARCHAR(255) NOT NULL,
product_price INT NOT NULL,
adults_only boolean NOT NULL,
description text,
producer_id INT references PRODUCER(ID)
)

CREATE TABLE purchase (
id serial primary key,
customer_id INT references CUSTOMER(ID),
product_id INT references product(id),
quantity INT NOT NULL,
date_time timestamp with time zone NOT NULL
)

CREATE TABLE opinion (
id serial primary key,
customer_id INT references CUSTOMER(ID),
product_id INT references PRODUCT(ID),
stars INT check (stars between 1 and 5) NOT NULL,
comment text NOT NULL,
date_time timestamp with time zone NOT NULL
)

ALTER SEQUENCE customer_id_seq RESTART WITH 1;
ALTER SEQUENCE customer_id_seq RESTART WITH 1;
ALTER SEQUENCE customer_id_seq RESTART WITH 1;
ALTER SEQUENCE customer_id_seq RESTART WITH 1;
ALTER SEQUENCE customer_id_seq RESTART WITH 1;

alter table customer alter column telephone_number type varchar(64)
