INSERT INTO Location (id,city) VALUES (1,'Bangalore');
INSERT INTO Location (id,city) VALUES (2,'Delhi');
INSERT INTO Location (id,city) VALUES (3,'Mumbai');
INSERT INTO Location (id,city) VALUES (4,'Chennai');
INSERT INTO Location (id,city) VALUES (5,'Kolkata');


INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('AVENGERS', 128);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('BAAHUBALI', 180);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('INCEPTION', 148);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('INTERSTELLAR', 169);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('THE DARK KNIGHT', 152);

INSERT INTO movie_location (movie_id, location_id) VALUES (1, 1); -- AVENGERS - Bangalore
INSERT INTO movie_location (movie_id, location_id) VALUES (1, 2); -- AVENGERS - Delhi
INSERT INTO movie_location (movie_id, location_id) VALUES (2, 1); -- BAAHUBALI - Bangalore
INSERT INTO movie_location (movie_id, location_id) VALUES (2, 3); -- BAAHUBALI - Mumbai
INSERT INTO movie_location (movie_id, location_id) VALUES (3, 4); -- INCEPTION - Chennai
INSERT INTO movie_location (movie_id, location_id) VALUES (4, 5); -- INTERSTELLAR - Kolkata
INSERT INTO movie_location (movie_id, location_id) VALUES (5, 1); -- THE DARK KNIGHT - Bangalore
INSERT INTO movie_location (movie_id, location_id) VALUES (5, 2); -- THE DARK KNIGHT - Delhi

INSERT INTO Screen (screen_id) VALUES (1);
INSERT INTO Screen (screen_id) VALUES (2);

-- Insert Seats
INSERT INTO Seat (row, seat_category) VALUES (1, 'SILVER');
INSERT INTO Seat (row, seat_category) VALUES (2, 'SILVER');
INSERT INTO Seat (row, seat_category) VALUES (3, 'GOLD');
INSERT INTO Seat (row, seat_category) VALUES (4, 'GOLD');
INSERT INTO Seat (row, seat_category) VALUES (5, 'PLATINUM');
INSERT INTO Seat (row, seat_category) VALUES (6, 'PLATINUM');

-- Insert Screen_Seats Linking
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (1, 1);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (1, 2);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (1, 3);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (1, 4);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (2, 5);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (2, 6);

-- Insert Shows
INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (1, 1, 1000);
INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (2, 1, 1400);
INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (1, 2, 1800);
INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (2, 2, 2000);

-- Insert Theatres
INSERT INTO Theatre (address, city) VALUES ('MG Road, Bangalore', 'Bangalore');
INSERT INTO Theatre (address, city) VALUES ('Connaught Place, Delhi', 'Delhi');

-- Link Screens to Theatres
INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (1, 1);
INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (2, 2);

-- Link Shows to Theatres
INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (1, 1);
INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (1, 2);
INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (2, 3);
INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (2, 4);