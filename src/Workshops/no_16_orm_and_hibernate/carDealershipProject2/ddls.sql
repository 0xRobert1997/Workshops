DROP TABLE IF EXISTS service_mechanic CASCADE;
DROP TABLE IF EXISTS service_part CASCADE;
DROP TABLE IF EXISTS service_request CASCADE;
DROP TABLE IF EXISTS invoice CASCADE;
DROP TABLE IF EXISTS mechanic CASCADE;
DROP TABLE IF EXISTS part CASCADE;
DROP TABLE IF EXISTS service CASCADE;
DROP TABLE IF EXISTS car_to_service CASCADE;
DROP TABLE IF EXISTS car CASCADE;
DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS address CASCADE;
DROP TABLE IF EXISTS salesman CASCADE;


CREATE TABLE salesman (
	salesman_id SERIAL primary key,
    name        VARCHAR(32) NOT NULL,
    surname     VARCHAR(32) NOT NULL,
    pesel       VARCHAR(32) NOT NULL unique
);

CREATE TABLE address (
	address_id SERIAL primary key,
    country     VARCHAR(32) NOT NULL,
    city        VARCHAR(32) NOT NULL,
    postal_code VARCHAR(32) NOT NULL,
    address     VARCHAR(32) NOT NULL
);

CREATE TABLE customer (
	customer_id SERIAL primary key,
    name      VARCHAR(32) NOT NULL,
    surname   VARCHAR(32) NOT NULL,
    telephone VARCHAR(32) NOT NULL,
    email     VARCHAR(32) NOT NULL unique,
	address_id INT NOT NULL,
    CONSTRAINT fk_customer_address
        FOREIGN KEY (address_id)
            REFERENCES address(address_id)
);

CREATE TABLE car (
	car_id SERIAL primary key,
    vin     VARCHAR(20) NOT NULL UNIQUE,
    brand   VARCHAR(20) NOT NULL,
    model   VARCHAR(20) NOT NULL,
    year    SMALLINT NOT NULL,
    color   VARCHAR(32) NOT NULL,
    price   NUMERIC(7,2) NOT NULL
);

CREATE TABLE service (
    service_id   SERIAL primary key,
    service_code VARCHAR(32) NOT NULL UNIQUE,
    description  VARCHAR(64) NOT NULL,
    price        NUMERIC(7,2) NOT NULL
);


CREATE TABLE part (
    part_id         serial primary key,
    serial_number   VARCHAR(32) NOT NULL UNIQUE,
    description     VARCHAR(64) NOT NULL,
    price           NUMERIC(7,2) NOT NULL
);

CREATE TABLE mechanic (
	mechanic_id SERIAL primary key,
    name        VARCHAR(32) NOT NULL,
    surname     VARCHAR(32) NOT NULL,
    pesel       VARCHAR(32) NOT NULL unique
);

CREATE TABLE car_to_service (
	car_to_service_id SERIAL primary key,
    vin     VARCHAR(20) NOT NULL UNIQUE,
    brand   VARCHAR(20) NOT NULL,
    model   VARCHAR(20) NOT NULL,
    year    SMALLINT NOT NULL,
    color   VARCHAR(32) NOT NULL
);

CREATE TABLE invoice (
    invoice_id        SERIAL NOT NULL PRIMARY KEY,
    invoice_number    VARCHAR(64) NOT NULL UNIQUE,
    date_time         TIMESTAMP WITH TIME ZONE NOT NULL,
    care_id           INT NOT NULL references car(car_id),
    customer_id       INT NOT NULL references customer(customer_id),
    salesman_id       INT NOT NULL references salesman(salesman_id)
);

CREATE TABLE service_request (
    service_request_id  SERIAL NOT NULL PRIMARY KEY,
    invoice_number      VARCHAR(64) NOT NULL UNIQUE,
    received_date_time  TIMESTAMP WITH TIME ZONE NOT NULL,
    completed_date_time TIMESTAMP WITH TIME ZONE,
    customer_comment    TEXT,
    car_id              INT NOT NULL references car(car_id),
    customer_id         INT NOT NULL references customer(customer_id)
);

CREATE TABLE service_part (
    service_part_id SERIAL  NOT NULL PRIMARY KEY,
    quantity                INT NOT NULL,
    service_request_id      INT NOT NULL references service_request(service_request_id),
    part_id                 INT NOT NULL references part(part_id)
);

CREATE TABLE service_mechanic (
    service_mechanic_id SERIAL NOT NULL PRIMARY KEY,
    hours INT NOT NULL,
    comment VARCHAR(64) NOT NULL,
    service_request_id INT NOT NULL references service_request(service_request_id),
    mechanic_id INT NOT NULL references mechanic(mechanic_id),
    service_id INT NOT NULL references service(service_id)
);
