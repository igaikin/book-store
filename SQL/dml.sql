SELECT * FROM books;

DELETE FROM books;

UPDATE books SET cover = 'SOFT' WHERE id=17;

INSERT INTO books (id, author, title, cover, number_of_pages, price)
VALUES (1, 'Sandra Brown', 'The Switch', 'SOFT', 512, 5.25),
       (2, 'Sherryl Woods', 'Home in Carolina', 'SOFT',384, 5.10),
       (3, 'J. D. Robb', 'Glory in Death', 'SOFT', 320, 5.98),
       (4, 'Nicholas Sparks', 'The Last Song', 'SOFT', 480, 8.79),
       (5, 'Jayne Ann Krentz', 'Untouchable', 'SOFT', 416, 8.40),
       (6, 'Nora Roberts', 'Hot Rocks', 'SOFT', 320, 8.99),
       (7, 'Jeaniene Frost', 'This Side of the Grave', 'SOFT', 384, 8.57),
       (8, 'Carolyn Brown', 'Christmas at Home', 'SOFT', 384, 6.74),
       (9, 'Robert Orlando', 'The Divine Plan', 'HARD', 288, 21.42),
       (10, 'Colleen Hoover', 'Maybe Someday', 'SOFT', 384, 11.27),
       (11, 'Shelley Shepard Gray', 'An Amish Family Christmas', 'SOFT', 368, 3.99),
       (12, 'Amanda Bouchet', 'Starbreaker', 'SOFT', 448, 5.98),
       (13, 'Stephen King', 'Billy Summers', 'HARD', 528, 15.00),
       (14, 'J K Rowling', 'The Christmas Pig', 'HARD', 288, 18.31),
       (15, 'Rebecca Stead', 'Goodbye Stranger', 'HARD', 304, 15.33),
       (16, 'Julia Quinn', 'The Viscount Who Loved Me', 'SOFT', 400, 9.44),
       (17, 'George Orwell', '1984', 'SOFT', 304, 13.49),
       (18, 'Stephen King', 'The Institute', 'HARD', 576, 13.93),
       (19, 'Max Brallier', 'The Last Kids on Earth', 'HARD', 240, 8.34);

INSERT INTO users (id, first_name, last_name, role, email, password)
VALUES ('1', 'Muammar', 'Gaddafi', 'CUSTOMER', 'muamar@mail.lby', '12345'),
       ('2', 'Osama', 'bin Ladenen', 'MANAGER', 'samij_raziskivaemij@mail.pak', '100500'),
       ('3', 'Adolf', 'Hitler', 'ADMIN', 'pochti_zahvatil_europ@mail.de', 'First'),
       ('4', 'Saddam', 'Hussein', 'CUSTOMER', 'saddam_popolam@mail.irq', 'Second'),
       ('5', 'Bashar', 'al-Assad', 'CUSTOMER', 'malenkij_gnom@mail.syr', '44444444'),
       ('6', 'Idi', 'Amin', 'CUSTOMER', 'malchik_chernokizhij@mail.ug', '33333333'),
       ('7', 'Joseph', 'Stalin', 'CUSTOMER', 'ya_samiy_krutoj@mail.ussr', '22222222'),
       ('8', 'Alesandro', 'Shoushenko', 'MANAGER', 'usatiy_nany@mail.by', '11111111');

INSERT INTO orders (id, status, quantity, total_price);