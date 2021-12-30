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
       ('SOFT'),
       ('NO_INFO');

INSERT INTO books (author, title, cover_id, number_of_pages, price)
VALUES ('Sandra Brown', 'The Switch', (SELECT id FROM covers WHERE cover = 'SOFT'), 512, 5.25),
       ('Sherryl Woods', 'Home in Carolina', (SELECT id FROM covers WHERE cover = 'SOFT'), 384, 5.10),
       ('J. D. Robb', 'Glory in Death', (SELECT id FROM covers WHERE cover = 'SOFT'), 320, 5.98),
       ('Nicholas Sparks', 'The Last Song', (SELECT id FROM covers WHERE cover = 'SOFT'), 480, 8.79),
       ('Jayne Ann Krentz', 'Untouchable', (SELECT id FROM covers WHERE cover = 'SOFT'), 416, 8.40),
       ('Nora Roberts', 'Hot Rocks', (SELECT id FROM covers WHERE cover = 'SOFT'), 320, 8.99),
       ('Jeaniene Frost', 'This Side of the Grave', (SELECT id FROM covers WHERE cover = 'SOFT'), 384, 8.57),
       ('Carolyn Brown', 'Christmas at Home', (SELECT id FROM covers WHERE cover = 'SOFT'), 384, 6.74),
       ('Robert Orlando', 'The Divine Plan', (SELECT id FROM covers WHERE cover = 'HARD'), 288, 21.42),
       ('Colleen Hoover', 'Maybe Someday', (SELECT id FROM covers WHERE cover = 'SOFT'), 384, 11.27),
       ('Shelley Shepard Gray', 'An Amish Family Christmas', (SELECT id FROM covers WHERE cover = 'SOFT'), 368, 3.99),
       ('Amanda Bouchet', 'Starbreaker', (SELECT id FROM covers WHERE cover = 'SOFT'), 448, 5.98),
       ('Stephen King', 'Billy Summers', (SELECT id FROM covers WHERE cover = 'HARD'), 528, 15.00),
       ('J. K. Rowling', 'The Christmas Pig', (SELECT id FROM covers WHERE cover = 'HARD'), 288, 18.31),
       ('Rebecca Stead', 'Goodbye Stranger', (SELECT id FROM covers WHERE cover = 'HARD'), 304, 15.33),
       ('Julia Quinn', 'The Viscount Who Loved Me', (SELECT id FROM covers WHERE cover = 'SOFT'), 400, 9.44),
       ('George Orwell', '1984', (SELECT id FROM covers WHERE cover = 'SOFT'), 304, 13.49),
       ('Stephen King', 'The Institute', (SELECT id FROM covers WHERE cover = 'HARD'), 576, 13.93),
       ('Max Brallier', 'The Last Kids on Earth', (SELECT id FROM covers WHERE cover = 'HARD'), 240, 8.34);

INSERT INTO roles (role)
VALUES ('CUSTOMER'),
       ('MANAGER'),
       ('ADMIN');

INSERT INTO users (first_name, last_name, role_id, email, password)
VALUES ('Muammar', 'Gaddafi', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'muamar@mail.lby', '12345'),
       ('Osama', 'bin Ladenen', (SELECT id FROM roles WHERE role = 'MANAGER'), 'samij_raziskivaemij@mail.pak', '100500'),
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

INSERT INTO orders (status_id, quantity, book_id, user_id, total_price)
VALUES ((SELECT id FROM statuses WHERE status = 'PENDING'), 2,
        (SELECT id FROM books WHERE title = 'Glory in Death' AND author = 'J. D. Robb' AND books.deleted = false),
        (SELECT id FROM users WHERE email = 'muamar@mail.lby' AND users.deleted = false),
        (SELECT price FROM books WHERE title = 'Glory in Death' AND author = 'J. D. Robb' AND books.deleted = false) * 2),

       ((SELECT id FROM statuses WHERE status = 'DELIVERED'), 1,
        (SELECT id FROM books WHERE title = 'The Last Kids on Earth' AND author = 'Max Brallier' AND books.deleted = false),
        (SELECT id FROM users WHERE email = 'usatiy_nany@mail.by' AND users.deleted = false), 87.99);