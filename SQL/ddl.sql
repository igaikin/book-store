--CREATE DATABASE bookstore;
--DROP TABLE books;
CREATE TABLE IF NOT EXISTS books
(
    id               BIGSERIAL PRIMARY KEY,
    author           VARCHAR(100) NOT NULL,
    title            VARCHAR(100) NOT NULL,
    cover            VARCHAR(10),
    number_of_pages  INT,
    price            DECIMAL NOT NULL,
    deleted          BOOLEAN NOT NULL DEFAULT false
);

--DROP TABLE orders;
CREATE TABLE IF NOT EXISTS orders
(
    id            BIGSERIAL PRIMARY KEY,
    status        VARCHAR(50) NOT NULL,
    quantity      INT,
    book_id       INT REFERENCES books,
    user_id       INT REFERENCES users,
    total_price   DECIMAL,
    deleted       BOOLEAN NOT NULL DEFAULT false
);

--DROP TABLE users;
CREATE TABLE IF NOT EXISTS users
(
    id              BIGSERIAL PRIMARY KEY,
    first_name      VARCHAR(50) NOT NULL,
    last_name       VARCHAR(50) NOT NULL,
    role            VARCHAR (50),
    email           VARCHAR(50),
    password        VARCHAR(50),
    deleted         BOOLEAN NOT NULL DEFAULT false
    );
