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

INSERT INTO books (image, author, title, cover_id, pages, isbn, price)
VALUES ('images/sandraBrown_theSwitch.jpg', 'Sandra Brown', 'The Switch', (SELECT id FROM covers WHERE cover = 'SOFT'), 512, '978-1-53-871268-9', 5.25),
       ('images/sherrylWoods_homeInCarolina.jpg', 'Sherryl Woods', 'Home in Carolina', (SELECT id FROM covers WHERE cover = 'SOFT'), 384, '978-0-77-831902-3', 5.10),
       ('images/jDRobb_gloryInDeath.jpg', 'J. D. Robb', 'Glory in Death', (SELECT id FROM covers WHERE cover = 'SOFT'), 320, '978-0-42-515098-6', 5.98),
       ('images/nicholasSparks_theLastSong.jpg', 'Nicholas Sparks', 'The Last Song', (SELECT id FROM covers WHERE cover = 'SOFT'), 480, '978-0-44-657096-1', 8.99),
       ('images/jayneAnnKrentz_untouchable.jpg', 'Jayne Ann Krentz', 'Untouchable', (SELECT id FROM covers WHERE cover = 'SOFT'), 416, '978-0-39-958531-9', 5.98),
       ('images/noraRoberts_hotRocks.jpg', 'Nora Roberts', 'Hot Rocks', (SELECT id FROM covers WHERE cover = 'SOFT'), 320, '978-0-51-514799-5', 8.99),
       ('images/jeanieneFrost_thisSideOfTheGrave.jpg', 'Jeaniene Frost', 'This Side of the Grave', (SELECT id FROM covers WHERE cover = 'SOFT'), 384, '978-0-06-178318-0', 11.49),
       ('images/carolynBrown_christmasAtHome.jpg', 'Carolyn Brown', 'Christmas at Home', (SELECT id FROM covers WHERE cover = 'SOFT'), 384, '978-1-72-822967-6', 6.74),
       ('images/robertOrlando_theDivinePlan.jpg', 'Robert Orlando', 'The Divine Plan', (SELECT id FROM covers WHERE cover = 'HARD'), 288, '978-1-61-017154-0', 21.52),
       ('images/colleenHoover_maybeSomeday.jpg', 'Colleen Hoover', 'Maybe Someday', (SELECT id FROM covers WHERE cover = 'SOFT'), 384, '978-1-47-675316-4', 10.19),
       ('images/shelleyShepardGray_anAmishFamilyChristmas.jpg', 'Shelley Shepard Gray', 'An Amish Family Christmas', (SELECT id FROM covers WHERE cover = 'SOFT'), 368, '978-0-06-274327-5', 3.99),
       ('images/amandaBouchet_starbreaker.jpg', 'Amanda Bouchet', 'Starbreaker', (SELECT id FROM covers WHERE cover = 'SOFT'), 448, '978-1-49-266716-2', 7.99),
       ('images/stephenKing_billySummers.jpg', 'Stephen King', 'Billy Summers', (SELECT id FROM covers WHERE cover = 'HARD'), 528, '978-1-98-217361-6', 15.00),
       ('images/jKRowling_theChristmasPig.jpg', 'J. K. Rowling', 'The Christmas Pig', (SELECT id FROM covers WHERE cover = 'HARD'), 288, '978-1-33-879023-8', 14.99),
       ('images/rebeccaStead_goodbyeStranger.jpg', 'Rebecca Stead', 'Goodbye Stranger', (SELECT id FROM covers WHERE cover = 'HARD'), 304, '978-0-38-574317-4', 15.33),
       ('images/juliaQuinn_theViscountWhoLovedMe.jpg', 'Julia Quinn', 'The Viscount Who Loved Me', (SELECT id FROM covers WHERE cover = 'SOFT'), 400, '978-0-06-235364-1', 11.49),
       ('images/georgeOrwell_1984.jpg', 'George Orwell', '1984', (SELECT id FROM covers WHERE cover = 'SOFT'), 304, '978-0-45-226293-5', 11.63),
       ('images/stephenKing_theInstitute.jpg', 'Stephen King', 'The Institute', (SELECT id FROM covers WHERE cover = 'HARD'), 576, '978-1-98-211058-1', 13.93),
       ('images/maxBrallier_theLastKidsOnEarth.jpg', 'Max Brallier', 'The Last Kids on Earth', (SELECT id FROM covers WHERE cover = 'HARD'), 240, '978-0-67-001661-7', 8.34);

INSERT INTO roles (role)
VALUES ('CUSTOMER'),
       ('MANAGER'),
       ('ADMIN');

INSERT INTO users (avatar, first_name, last_name, role_id, email, password)
VALUES ('images/noAvatar.png', 'Admin', 'Test', (SELECT id FROM roles WHERE role = 'ADMIN'), 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997'),
       ('images/noAvatar.png', 'Manager', 'Test', (SELECT id FROM roles WHERE role = 'MANAGER'), 'manager', '1a8565a9dc72048ba03b4156be3e569f22771f23'),
       ('images/noAvatar.png', 'User', 'Test', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'user', '12dea96fec20593566ab75692c9949596833adc9'),
       ('images/noAvatar.png', 'Vladimir', 'Putin', (SELECT id FROM roles WHERE role = 'ADMIN'), 'zloi_karlik@mail.ru', 'd033e22ae348aeb5660fc2140aec35850c4da997'),
       ('images/noAvatar.png', 'Bashar', 'al-Assad', (SELECT id FROM roles WHERE role = 'MANAGER'), 'malenkij_gnom@mail.syr', '1a8565a9dc72048ba03b4156be3e569f22771f23'),
       ('images/noAvatar.png', 'Alesandro', 'Shoushenko', (SELECT id FROM roles WHERE role = 'MANAGER'), 'usatiy_nany@mail.by', '1a8565a9dc72048ba03b4156be3e569f22771f23'),
       ('images/noAvatar.png', 'Osama', 'bin Ladenen', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'samij_raziskivaemij@mail.pak', '12dea96fec20593566ab75692c9949596833adc9'),
       ('images/noAvatar.png', 'Muammar', 'Gaddafi', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'muamar@mail.lby', '12dea96fec20593566ab75692c9949596833adc9'),
       ('images/noAvatar.png', 'Saddam', 'Hussein', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'saddam_popolam@mail.irq', '12dea96fec20593566ab75692c9949596833adc9'),
       ('images/noAvatar.png', 'Idi', 'Amin', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'malchik_chernokizhij@mail.ug', '12dea96fec20593566ab75692c9949596833adc9'),
       ('images/noAvatar.png', 'Joseph', 'Stalin', (SELECT id FROM roles WHERE role = 'CUSTOMER'), 'ya_samiy_krutoj@mail.ussr', '12dea96fec20593566ab75692c9949596833adc9');

INSERT INTO statuses (status)
VALUES ('PENDING'),
       ('DELIVERING'),
       ('DELIVERED'),
       ('CANCELLED');

INSERT INTO orders (status_id, date, user_id, total_price)
VALUES ((SELECT id FROM statuses WHERE status = 'PENDING'), '2020-08-12 12:16:44',
        (SELECT id FROM users WHERE email = 'muamar@mail.lby' AND users.deleted = false), 155),
       ((SELECT id FROM statuses WHERE status = 'CANCELLED'), '2022-07-22 12:02:44',
        (SELECT id FROM users WHERE email = 'manager' AND users.deleted = false), 111),
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
        (SELECT price FROM books WHERE isbn = '978-0-67-001661-7'), 1),
       ((SELECT id FROM orders WHERE date = '2022-07-22 12:02:44'),
        (SELECT id FROM books WHERE isbn = '978-0-45-226293-5'),
        (SELECT price FROM books WHERE isbn = '978-0-45-226293-5'), 10);
