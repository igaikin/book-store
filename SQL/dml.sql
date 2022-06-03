/*
TRUNCATE statuses CASCADE;
TRUNCATE orders CASCADE;
TRUNCATE covers CASCADE;
TRUNCATE books CASCADE;
TRUNCATE roles CASCADE;
TRUNCATE users CASCADE;
 */
INSERT INTO covers (cover)
VALUES ('HARD'),
       ('SOFT');

INSERT INTO books (author, title, cover_id, pages, isbn, price)
VALUES ('Sandra Brown', 'The Switch', (SELECT id FROM covers WHERE cover = 'SOFT'), 512, '978-1-53-871268-9', 5.25),
       ('Sherryl Woods', 'Home in Carolina', (SELECT id FROM covers WHERE cover = 'SOFT'), 384, '978-0-77-831902-3',
        5.10),
       ('J. D. Robb', 'Glory in Death', (SELECT id FROM covers WHERE cover = 'SOFT'), 320, '978-0-42-515098-6', 5.98),
       ('Nicholas Sparks', 'The Last Song', (SELECT id FROM covers WHERE cover = 'SOFT'), 480, '978-0-44-657096-1',
        8.99),
       ('Jayne Ann Krentz', 'Untouchable', (SELECT id FROM covers WHERE cover = 'SOFT'), 416, '978-0-39-958531-9',
        5.98),
       ('Nora Roberts', 'Hot Rocks', (SELECT id FROM covers WHERE cover = 'SOFT'), 320, '978-0-51-514799-5', 8.99),
       ('Jeaniene Frost', 'This Side of the Grave', (SELECT id FROM covers WHERE cover = 'SOFT'), 384,
        '978-0-06-178318-0', 11.49),
       ('Carolyn Brown', 'Christmas at Home', (SELECT id FROM covers WHERE cover = 'SOFT'), 384, '978-1-72-822967-6',
        6.74),
       ('Robert Orlando', 'The Divine Plan', (SELECT id FROM covers WHERE cover = 'HARD'), 288, '978-1-61-017154-0',
        21.52),
       ('Colleen Hoover', 'Maybe Someday', (SELECT id FROM covers WHERE cover = 'SOFT'), 384, '978-1-47-675316-4',
        10.19),
       ('Shelley Shepard Gray', 'An Amish Family Christmas', (SELECT id FROM covers WHERE cover = 'SOFT'), 368,
        '978-0-06-274327-5', 3.99),
       ('Amanda Bouchet', 'Starbreaker', (SELECT id FROM covers WHERE cover = 'SOFT'), 448, '978-1-49-266716-2', 7.99),
       ('Stephen King', 'Billy Summers', (SELECT id FROM covers WHERE cover = 'HARD'), 528, '978-1-98-217361-6', 15.00),
       ('J. K. Rowling', 'The Christmas Pig', (SELECT id FROM covers WHERE cover = 'HARD'), 288, '978-1-33-879023-8',
        14.99),
       ('Rebecca Stead', 'Goodbye Stranger', (SELECT id FROM covers WHERE cover = 'HARD'), 304, '978-0-38-574317-4',
        15.33),
       ('Julia Quinn', 'The Viscount Who Loved Me', (SELECT id FROM covers WHERE cover = 'SOFT'), 400,
        '978-0-06-235364-1',
        11.49),
       ('George Orwell', '1984', (SELECT id FROM covers WHERE cover = 'SOFT'), 304, '978-0-45-226293-5', 11.63),
       ('Stephen King', 'The Institute', (SELECT id FROM covers WHERE cover = 'HARD'), 576, '978-1-98-211058-1', 13.93),
       ('Max Brallier', 'The Last Kids on Earth', (SELECT id FROM covers WHERE cover = 'HARD'), 240,
        '978-0-67-001661-7',
        8.34);

INSERT INTO roles (role)
VALUES ('CUSTOMER'),
       ('MANAGER'),
       ('ADMIN');

INSERT INTO users (first_name, last_name, role_id, email, password)
VALUES ('Vladimir', 'Putin', (SELECT id FROM roles WHERE role = 'ADMIN'), 'zloi_karlik@mail.ru',
        'd033e22ae348aeb5660fc2140aec35850c4da997'),
       ('Bashar', 'al-Assad', (SELECT id FROM roles WHERE role = 'MANAGER'), 'malenkij_gnom@mail.syr',
        '1a8565a9dc72048ba03b4156be3e569f22771f23'),
       ('Alesandro', 'Shoushenko', (SELECT id FROM roles WHERE role = 'MANAGER'), 'usatiy_nany@mail.by',
        '1a8565a9dc72048ba03b4156be3e569f22771f23'),
       ('Osama', 'bin Ladenen', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'samij_raziskivaemij@mail.pak',
        '12dea96fec20593566ab75692c9949596833adc9'),
       ('Muammar', 'Gaddafi', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'muamar@mail.lby',
        '12dea96fec20593566ab75692c9949596833adc9'),
       ('Saddam', 'Hussein', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'saddam_popolam@mail.irq',
        '12dea96fec20593566ab75692c9949596833adc9'),
       ('Idi', 'Amin', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'malchik_chernokizhij@mail.ug',
        '12dea96fec20593566ab75692c9949596833adc9'),
       ('Joseph', 'Stalin', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'ya_samiy_krutoj@mail.ussr',
        '12dea96fec20593566ab75692c9949596833adc9');

INSERT INTO statuses (status)
VALUES ('PENDING'),
       ('DELIVERING'),
       ('DELIVERED'),
       ('CANCELLED');

INSERT INTO orders (status_id, date, user_id, total_price)
VALUES ((SELECT id FROM statuses WHERE status = 'PENDING'), '2020-08-12 12:16:44',
        (SELECT id FROM users WHERE email = 'muamar@mail.lby' AND users.deleted = false), 155),
       ((SELECT id FROM statuses WHERE status = 'DELIVERED'), '2021-07-15 08:35:33',
        (SELECT id FROM users WHERE email = 'usatiy_nany@mail.by' AND users.deleted = false), 632);

INSERT INTO order_items (order_id, book_id, price, quantity)
VALUES ((SELECT id FROM orders WHERE date = '2020-08-12 12:16:44'),
        (SELECT id FROM books WHERE isbn = '978-1-53-871268-9'),
        (SELECT price FROM books WHERE isbn = '978-1-53-871268-9'), 2),
       ((SELECT id FROM orders WHERE date = '2021-07-15 08:35:33'),
        (SELECT id FROM books WHERE isbn = '978-1-53-871268-9'),
        (SELECT price FROM books WHERE isbn = '978-1-53-871268-9'), 1),
       ((SELECT id FROM orders WHERE date = '2021-07-15 08:35:33'),
        (SELECT id FROM books WHERE isbn = '978-1-33-879023-8'),
        (SELECT price FROM books WHERE isbn = '978-1-33-879023-8'), 3),
       ((SELECT id FROM orders WHERE date = '2021-07-15 08:35:33'),
        (SELECT id FROM books WHERE isbn = '978-0-67-001661-7'),
        (SELECT price FROM books WHERE isbn = '978-0-67-001661-7'), 1);
