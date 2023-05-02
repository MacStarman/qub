use descriptions;
SET FOREIGN_KEY_CHECKS = 0;

--Useful in dev environment
TRUNCATE descriptions;

INSERT INTO descriptions (id, hotel_link, hotel_location, long_description, short_description, thumbnail) VALUES ('hotel1', 'http://dublinhotel.com', 'Dublin', 'Long Description', 'Short Description', 'http://thumbnail.com'); 