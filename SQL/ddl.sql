--CREATE DATABASE bookstore;
/*
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS statuses;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS covers;
*/
CREATE TABLE IF NOT EXISTS covers
(
    id    BIGSERIAL PRIMARY KEY,
    cover VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS books
(
    id              BIGSERIAL PRIMARY KEY,
    author          VARCHAR(100)                NOT NULL,
    title           VARCHAR(100)                NOT NULL,
    cover_id        BIGSERIAL REFERENCES covers NOT NULL,
    number_of_pages INT,
    price           DECIMAL(8, 2),
    isbn            BIGSERIAL UNIQUE            NOT NULL,
    deleted         BOOLEAN                     NOT NULL DEFAULT false
);

CREATE TABLE IF NOT EXISTS roles
(
    id   BIGSERIAL PRIMARY KEY,
    role VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    role_id    BIGSERIAL REFERENCES roles NOT NULL,
    email      VARCHAR(50) UNIQUE         NOT NULL,
    password   VARCHAR(50)                NOT NULL,
    deleted    BOOLEAN                    NOT NULL DEFAULT false
);

CREATE TABLE IF NOT EXISTS statuses
(
    id     BIGSERIAL PRIMARY KEY,
    status VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS orders
(
    id              BIGSERIAL PRIMARY KEY,
    status_id       BIGSERIAL REFERENCES statuses     NOT NULL,
    date            TIMESTAMP                         NOT NULL,
    order_item      BIGSERIAL                         NOT NULL,
    user_id         BIGSERIAL REFERENCES users        NOT NULL,
    total_price     DECIMAL(8, 2)                     NOT NULL,
    deleted         BOOLEAN                           NOT NULL DEFAULT false
);

CREATE TABLE IF NOT EXISTS order_items
(
    id       BIGSERIAL PRIMARY KEY,
    book_id  BIGSERIAL REFERENCES books  NOT NULL,
    price    DECIMAL(8, 2)               NOT NULL,
    quantity INT                         NOT NULL,
    order_id BIGSERIAL REFERENCES orders NOT NULL
);
