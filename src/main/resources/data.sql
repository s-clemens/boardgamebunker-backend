/*
Spring runt dit SQL-bestand automatisch. Spring zoekt namelijk naar een bestand dat data.sql heet (in deze folder) en
voert de SQL commando's voor je uit. Dit is een van de manier om de database te vullen. Om dit te laten werken, is het
volgende aan application.properties toegevoegd:

spring.datasource.initialization-mode=always

Zoals gezegd, dit is een van de manieren. De huidige opzet avn deze applicatie heeft een vast aantal user-rollen. Deze
kunnen niet door eindgebruikers, moderators of admins toegevoegd worden. Alleen de programmeur kan user-rollen
toevoegen. Daarom is er ook geen Service & repo voor de user-rollen geprogrammeerd. De enige manier om dan iets in de
database te krijgen is via SQL statements in dit bestand.

 */
INSERT INTO role(name) VALUES('ROLE_USER');
INSERT INTO role(name) VALUES('ROLE_MODERATOR');
INSERT INTO role(name) VALUES('ROLE_ADMIN');

INSERT INTO producttype(name) VALUES('BOARD_GAME');
INSERT INTO producttype(name) VALUES('CONSUMABLES');

INSERT INTO consumabletype(name) VALUES('FOOD');
INSERT INTO consumabletype(name) VALUES('DRINKS');

INSERT INTO boardgametype(name) VALUES('THIRTY_MINUTES');
INSERT INTO boardgametype(name) VALUES('ONE_HOUR');
INSERT INTO boardgametype(name) VALUES('TWO_HOURS');

INSERT INTO playroom(roomNr, maxGuests) VALUES('ONE', 3);
INSERT INTO playroom(roomNr, maxGuests) VALUES('TWO', 6);
INSERT INTO playroom(roomNr, maxGuests) VALUES('THREE', 9);
INSERT INTO playroom(roomNr, maxGuests) VALUES('FOUR', 12);

-- Het volgende werkt maar idealiter is een id nullable bij product.
INSERT INTO consumable(consumabletype_id, ingredients) VALUES(2, 'melk');
INSERT INTO boardgame(totalStock, minPlayers, maxPlayers, description) VALUES(3,1,4,'test');
INSERT INTO store_product(product_name, product_price, image_cover, producttype_id) VALUES ('Monopoly', 4.99, null, 2);
-- INSERT INTO product_consumable(store_product, consumable) VALUES(1,1);

INSERT INTO boardgame(totalStock, minPlayers, maxPlayers, description) VALUES(2,1,4,'test description')
INSERT INTO store_product(product_name, product_price, image_cover, producttype_id) VALUES ('Mens erger je niet', 5.66, null, 2);

INSERT INTO timeslot(day, timeslot) VALUES('06-26-2020', 'EARLY_AFTERNOON');



