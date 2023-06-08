create table person (
person_id SERIAL not null primary key,
age int,
name varchar(255)
)



CREATE TABLE owner (
owner_id SERIAL NOT NULL primary key,
surname VARCHAR(32) NOT NULL,
phone VARCHAR(32) NOT NULL,
email VARCHAR(32) NOT NULL,
)

CREATE TABLE pet (
pet_id SERIAL NOT NULL,
name VARCHAR(32) NOT NULL,
breed VARCHAR(32) NOT NULL,
owner_id INT references owner(owner_id)
)