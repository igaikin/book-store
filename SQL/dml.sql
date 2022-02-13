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

INSERT INTO books (author, title, cover_id, number_of_pages, isbn, price)
VALUES ('Sandra Brown', 'The Switch', (SELECT id FROM covers WHERE cover = 'SOFT'), 512, 9781538712689, 5.25),
       ('Sherryl Woods', 'Home in Carolina', (SELECT id FROM covers WHERE cover = 'SOFT'), 384, 9780778319023, 5.10),
       ('J. D. Robb', 'Glory in Death', (SELECT id FROM covers WHERE cover = 'SOFT'), 320, 9780425150986, 5.98),
       ('Nicholas Sparks', 'The Last Song', (SELECT id FROM covers WHERE cover = 'SOFT'), 480, 9780446570961, 8.99),
       ('Jayne Ann Krentz', 'Untouchable', (SELECT id FROM covers WHERE cover = 'SOFT'), 416, 9780399585319, 5.98),
       ('Nora Roberts', 'Hot Rocks', (SELECT id FROM covers WHERE cover = 'SOFT'), 320, 9780515147995, 8.99),
       ('Jeaniene Frost', 'This Side of the Grave', (SELECT id FROM covers WHERE cover = 'SOFT'), 384, 9780061783180,
        11.49),
       ('Carolyn Brown', 'Christmas at Home', (SELECT id FROM covers WHERE cover = 'SOFT'), 384, 9781728229676, 6.74),
       ('Robert Orlando', 'The Divine Plan', (SELECT id FROM covers WHERE cover = 'HARD'), 288, 9781610171540, 21.52),
       ('Colleen Hoover', 'Maybe Someday', (SELECT id FROM covers WHERE cover = 'SOFT'), 384, 9781476753164, 10.19),
       ('Shelley Shepard Gray', 'An Amish Family Christmas', (SELECT id FROM covers WHERE cover = 'SOFT'), 368,
        9780062743275, 3.99),
       ('Amanda Bouchet', 'Starbreaker', (SELECT id FROM covers WHERE cover = 'SOFT'), 448, 9781492667162, 7.99),
       ('Stephen King', 'Billy Summers', (SELECT id FROM covers WHERE cover = 'HARD'), 528, 9781982173616, 15.00),
       ('J. K. Rowling', 'The Christmas Pig', (SELECT id FROM covers WHERE cover = 'HARD'), 288, 9781338790238, 14.99),
       ('Rebecca Stead', 'Goodbye Stranger', (SELECT id FROM covers WHERE cover = 'HARD'), 304, 9780385743174, 15.33),
       ('Julia Quinn', 'The Viscount Who Loved Me', (SELECT id FROM covers WHERE cover = 'SOFT'), 400, 9780062353641,
        11.49),
       ('George Orwell', '1984', (SELECT id FROM covers WHERE cover = 'SOFT'), 304, 9780452262935, 11.63),
       ('Stephen King', 'The Institute', (SELECT id FROM covers WHERE cover = 'HARD'), 576, 9781982110581, 13.93),
       ('Max Brallier', 'The Last Kids on Earth', (SELECT id FROM covers WHERE cover = 'HARD'), 240, 9780670016617,
        8.34);

INSERT INTO roles (role)
VALUES ('CUSTOMER'),
       ('MANAGER'),
       ('ADMIN');

INSERT INTO users (first_name, last_name, role_id, email, password)
VALUES ('Muammar', 'Gaddafi', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'muamar@mail.lby', '12345'),
       ('Osama', 'bin Ladenen', (SELECT id FROM roles WHERE role = 'MANAGER'), 'samij_raziskivaemij@mail.pak',
        '100500'),
       ('Adolf', 'Hitler', (SELECT id FROM roles WHERE role = 'ADMIN'), 'pochti_zahvatil_europ@mail.de', 'First'),
       ('Saddam', 'Hussein', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'saddam_popolam@mail.irq', 'Second'),
       ('Bashar', 'al-Assad', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'malenkij_gnom@mail.syr', '44444444'),
       ('Idi', 'Amin', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'malchik_chernokizhij@mail.ug', '33333333'),
       ('Joseph', 'Stalin', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'ya_samiy_krutoj@mail.ussr', '22222222'),
       ('Alesandro', 'Shoushenko', (SELECT id FROM roles WHERE role = 'MANAGER'), 'usatiy_nany@mail.by', '11111111');

INSERT INTO statuses (status)
VALUES ('PENDING'),
       ('DELIVERING'),
       ('DELIVERED'),
       ('CANCELLED');

INSERT INTO orders (status_id, date, user_id, total_price)
VALUES ((SELECT id FROM statuses WHERE status = 'PENDING'), 'YYYY-MM-DD HH:MM:SS',
        (SELECT id FROM users WHERE email = 'muamar@mail.lby' AND users.deleted = false), ?),

       ((SELECT id FROM statuses WHERE status = 'DELIVERED'), 'YYYY-MM-DD HH:MM:SS',
        (SELECT id FROM users WHERE email = 'usatiy_nany@mail.by' AND users.deleted = false), ?);

INSERT INTO order_items (order_id, book_id, price, quantity)
VALUES (((SELECT order_id FROM),
         (SELECT id FROM books WHERE title = 'Glory in Death' AND author = 'J. D. Robb' AND books.deleted = false),
         (SELECT price FROM books WHERE title = 'Glory in Death' AND author = 'J. D. Robb' AND books.deleted = false), ?)),
       (((SELECT id FROM books WHERE title = 'The Last Kids on Earth' AND author = 'Max Brallier' AND books.deleted = false),
         (SELECT price FROM books WHERE title = 'The Last Kids on Earth' AND author = 'Max Brallier' AND books.deleted = false), ?));