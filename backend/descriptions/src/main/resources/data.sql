use descriptions;
SET FOREIGN_KEY_CHECKS = 0;

--Useful in dev environment
TRUNCATE descriptions;

INSERT INTO descriptions (id, hotel_name, hotel_link, hotel_location, long_description, short_description, thumbnail) VALUES ('hotel1', 'Mespil Hotel', 'http://dublinhotel.com', 'Dublin', 'We charge you €200 a night for a basic hotel experience.', 'Budget hotel in the heart of Dublin City.', 'https://media-cdn.tripadvisor.com/media/photo-s/12/98/ee/42/mespil-hotel.jpg'); 
INSERT INTO descriptions (id, hotel_name,hotel_link, hotel_location, long_description, short_description, thumbnail) VALUES ('hotel2', 'Conference Hotel', 'http://frankfurt.com', 'Frankfurt', 'Perfect hotel for conferences in Frankfurt.', 'Conference Hotel in Frankfurt', 'https://www.conferencehotelgroup.com/cache/1861/420x315/228495_14091716430022215625.jpg');

INSERT INTO hotel_description_images(hotel_description_id, images) VALUES ('hotel1', 'https://www.mespilhotel.com/cmsGallery/imagerow/7839/resized/1200x1200/the_lounge_ab.jpg');
INSERT INTO hotel_description_images(hotel_description_id, images) VALUES ('hotel1', 'https://www.mespilhotel.com/cmsGallery/imagerow/7839/resized/1200x1200/gym_ds_door.jpg');
INSERT INTO hotel_description_images(hotel_description_id, images) VALUES ('hotel1', 'https://www.mespilhotel.com/cmsGallery/photo/3854/resized/1200x1200/lobby_seating_the_mespil_hotel.jpg');


INSERT INTO hotel_description_facilities(hotel_description_id, facilities) VALUES ('hotel1', '24 hr reception');
INSERT INTO hotel_description_facilities(hotel_description_id, facilities) VALUES ('hotel1', 'GYM');
INSERT INTO hotel_description_facilities(hotel_description_id, facilities) VALUES ('hotel1', 'Sauna');
INSERT INTO hotel_description_facilities(hotel_description_id, facilities) VALUES ('hotel1', 'Free Wifi');
INSERT INTO hotel_description_facilities(hotel_description_id, facilities) VALUES ('hotel1', 'Restaurant');


INSERT INTO hotel_description_popular_attractions(hotel_description_id, popular_attractions) VALUES ('hotel1', 'The Spire');
INSERT INTO hotel_description_popular_attractions(hotel_description_id, popular_attractions) VALUES ('hotel1', 'Guinness Storehouse');
INSERT INTO hotel_description_popular_attractions(hotel_description_id, popular_attractions) VALUES ('hotel1', 'Dublin Zoo');
INSERT INTO hotel_description_popular_attractions(hotel_description_id, popular_attractions) VALUES ('hotel1', 'Kilmainham Gaol Museum');


INSERT INTO hotel_description_public_transport (hotel_description_id, public_transport) VALUES ('hotel1', 'Train');
INSERT INTO hotel_description_public_transport (hotel_description_id, public_transport) VALUES ('hotel1', 'Bus');