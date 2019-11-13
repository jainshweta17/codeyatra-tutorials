DROP TABLE people IF EXISTS;

CREATE TABLE product  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    product_name VARCHAR(2000),
    product_description VARCHAR(2000),
    pRice NUMBER(100)
);