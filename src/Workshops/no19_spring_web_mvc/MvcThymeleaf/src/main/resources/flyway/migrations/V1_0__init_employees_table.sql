CREATE TABLE employee
(
    employee_id SERIAL NOT NULL,
    name VARCHAR(20) NOT NULL,
    surname VARCHAR(20) NOT NULL,
    salary NUMERIC(7,2) NOT NULL,
    PRIMARY KEY(employee_id)
);