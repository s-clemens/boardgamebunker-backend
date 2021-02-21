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

INSERT INTO timeslot(day, timeslot) VALUES('06-26-2020', 'EARLY_AFTERNOON');



