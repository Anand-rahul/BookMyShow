-- Corrected SQL Queries for Consistency

-- Insert Locations
INSERT INTO Location (id, city, icon, popular) VALUES (1, 'Bangalore', NULL, true);
INSERT INTO Location (id, city, icon, popular) VALUES (2, 'Delhi', NULL, true);
INSERT INTO Location (id, city, icon, popular) VALUES (3, 'Mumbai', NULL, true);
INSERT INTO Location (id, city, icon, popular) VALUES (4, 'Chennai', NULL, false);
INSERT INTO Location (id, city, icon, popular) VALUES (5, 'Kolkata', NULL, false);
INSERT INTO Location (id, city, icon, popular) VALUES (6, 'Hyderabad', NULL, false);
INSERT INTO Location (id, city, icon, popular) VALUES (7, 'Pune', NULL, false);
INSERT INTO Location (id, city, icon, popular) VALUES (8, 'Ahmedabad', NULL, false);
INSERT INTO Location (id, city, icon, popular) VALUES (9, 'Jaipur', NULL, false);
INSERT INTO Location (id, city, icon, popular) VALUES (10, 'Lucknow', NULL, false);
INSERT INTO Location (id, city, icon, popular) VALUES (11, 'Patna', NULL, false);
INSERT INTO Location (id, city, icon, popular) VALUES (12, 'Indore', NULL, false);
INSERT INTO Location (id, city, icon, popular) VALUES (13, 'Surat', NULL, false);
INSERT INTO Location (id, city, icon, popular) VALUES (14, 'Bhopal', NULL, false);
INSERT INTO Location (id, city, icon, popular) VALUES (15, 'Ranchi', NULL,false);
INSERT INTO Location (id, city, icon, popular) VALUES (16, 'Coimbatore', NULL,false);
INSERT INTO Location (id, city, icon, popular) VALUES (17, 'Vijayawada', NULL, false);
INSERT INTO Location (id, city, icon, popular) VALUES (18, 'Goa', NULL, false);
INSERT INTO Location (id, city, icon, popular) VALUES (19, 'Trivandrum', NULL,false);
INSERT INTO Location (id, city, icon, popular) VALUES (20, 'Dehradun', NULL, false);


-- Insert Movies
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('AVENGERS', 128);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('BAAHUBALI', 180);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('INCEPTION', 148);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('INTERSTELLAR', 169);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('THE-DARK-KNIGHT', 152);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('FAST-X', 140);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('MISSION IMPOSSIBLE', 150);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('SPIDERMAN', 130);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('JOKER', 122);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('TOP-GUN', 145);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('BLACK-ADAM', 135);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('DUNE', 155);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('TENET', 150);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('DOCTOR-STRANGE', 126);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('NO-TIME-TO-DIE', 163);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('JURASSIC-WORLD', 147);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('MATRIX-RESURRECTIONS', 148);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('THE-BATMAN', 175);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('SHAZAM', 132);
INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('BLACK-PANTHER', 134);

-- Insert Movie-Location Mapping
INSERT INTO movie_location (movie_id, location_id) VALUES (1, 1);
INSERT INTO movie_location (movie_id, location_id) VALUES (1, 2);
INSERT INTO movie_location (movie_id, location_id) VALUES (2, 3);
INSERT INTO movie_location (movie_id, location_id) VALUES (2, 4);
INSERT INTO movie_location (movie_id, location_id) VALUES (3, 5);
INSERT INTO movie_location (movie_id, location_id) VALUES (3, 6);
INSERT INTO movie_location (movie_id, location_id) VALUES (4, 7);
INSERT INTO movie_location (movie_id, location_id) VALUES (4, 8);
INSERT INTO movie_location (movie_id, location_id) VALUES (5, 9);
INSERT INTO movie_location (movie_id, location_id) VALUES (5, 10);
INSERT INTO movie_location (movie_id, location_id) VALUES (6, 11);
INSERT INTO movie_location (movie_id, location_id) VALUES (7, 12);
INSERT INTO movie_location (movie_id, location_id) VALUES (8, 13);
INSERT INTO movie_location (movie_id, location_id) VALUES (9, 14);
INSERT INTO movie_location (movie_id, location_id) VALUES (10, 15);
INSERT INTO movie_location (movie_id, location_id) VALUES (11, 16);
INSERT INTO movie_location (movie_id, location_id) VALUES (12, 17);
INSERT INTO movie_location (movie_id, location_id) VALUES (13, 18);
INSERT INTO movie_location (movie_id, location_id) VALUES (14, 19);
INSERT INTO movie_location (movie_id, location_id) VALUES (15, 20);

-- Insert Screens
INSERT INTO Screen (screen_id) VALUES (1);
INSERT INTO Screen (screen_id) VALUES (2);
INSERT INTO Screen (screen_id) VALUES (3);
INSERT INTO Screen (screen_id) VALUES (4);
INSERT INTO Screen (screen_id) VALUES (5);
INSERT INTO Screen (screen_id) VALUES (6);
INSERT INTO Screen (screen_id) VALUES (7);
INSERT INTO Screen (screen_id) VALUES (8);
INSERT INTO Screen (screen_id) VALUES (9);
INSERT INTO Screen (screen_id) VALUES (10);
INSERT INTO Screen (screen_id) VALUES (11);
INSERT INTO Screen (screen_id) VALUES (12);
INSERT INTO Screen (screen_id) VALUES (13);
INSERT INTO Screen (screen_id) VALUES (14);
INSERT INTO Screen (screen_id) VALUES (15);
INSERT INTO Screen (screen_id) VALUES (16);
INSERT INTO Screen (screen_id) VALUES (17);
INSERT INTO Screen (screen_id) VALUES (18);
INSERT INTO Screen (screen_id) VALUES (19);
INSERT INTO Screen (screen_id) VALUES (20);

-- Insert Seats
INSERT INTO Seat (row, seat_category) VALUES (1, 'SILVER');
INSERT INTO Seat (row, seat_category) VALUES (2, 'SILVER');
INSERT INTO Seat (row, seat_category) VALUES (3, 'GOLD');
INSERT INTO Seat (row, seat_category) VALUES (4, 'GOLD');
INSERT INTO Seat (row, seat_category) VALUES (5, 'PLATINUM');
INSERT INTO Seat (row, seat_category) VALUES (6, 'PLATINUM');
INSERT INTO Seat (row, seat_category) VALUES (7, 'SILVER');
INSERT INTO Seat (row, seat_category) VALUES (8, 'GOLD');
INSERT INTO Seat (row, seat_category) VALUES (9, 'PLATINUM');
INSERT INTO Seat (row, seat_category) VALUES (10, 'SILVER');
INSERT INTO Seat (row, seat_category) VALUES (11, 'SILVER');
INSERT INTO Seat (row, seat_category) VALUES (12, 'GOLD');
INSERT INTO Seat (row, seat_category) VALUES (13, 'PLATINUM');
INSERT INTO Seat (row, seat_category) VALUES (14, 'SILVER');
INSERT INTO Seat (row, seat_category) VALUES (15, 'GOLD');
INSERT INTO Seat (row, seat_category) VALUES (16, 'PLATINUM');
INSERT INTO Seat (row, seat_category) VALUES (17, 'SILVER');
INSERT INTO Seat (row, seat_category) VALUES (18, 'GOLD');
INSERT INTO Seat (row, seat_category) VALUES (19, 'PLATINUM');
INSERT INTO Seat (row, seat_category) VALUES (20, 'SILVER');


-- Link Screens to Seats
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (1, 1);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (1, 2);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (2, 3);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (2, 4);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (3, 5);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (3, 6);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (4, 7);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (4, 8);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (5, 9);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (5, 10);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (6, 11);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (6, 12);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (7, 13);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (7, 14);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (8, 15);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (8, 16);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (9, 17);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (9, 18);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (10, 19);
INSERT INTO Screen_Seats (screen_screen_id, seats_seat_id) VALUES (10, 20);

-- Insert Shows
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (1, 1, 1000);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (2, 2, 1200);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (3, 3, 1400);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (4, 4, 1600);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (5, 5, 1800);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (6, 6, 2000);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (7, 7, 2200);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (8, 8, 1000);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (9, 9, 1200);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (10, 10, 1400);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (11, 11, 1500);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (12, 12, 1700);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (13, 13, 1900);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (14, 14, 1100);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (15, 15, 1300);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (16, 16, 1500);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (17, 17, 1600);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (18, 18, 1800);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (19, 19, 1900);
 INSERT INTO Show (movie_movie_id, screen_screen_id, show_start_time) VALUES (20, 20, 2000);

 -- Insert Theatres
 INSERT INTO Theatre (address, city) VALUES ('MG Road, Bangalore', 'Bangalore');
 INSERT INTO Theatre (address, city) VALUES ('Connaught Place, Delhi', 'Delhi');
 INSERT INTO Theatre (address, city) VALUES ('Jantar Mantar, Delhi', 'Delhi');
 INSERT INTO Theatre (address, city) VALUES ('Salt Lake, Kolkata', 'Kolkata');
 INSERT INTO Theatre (address, city) VALUES ('T Nagar, Chennai', 'Chennai');
 INSERT INTO Theatre (address, city) VALUES ('BKC, Mumbai', 'Mumbai');
 INSERT INTO Theatre (address, city) VALUES ('Kothrud, Pune', 'Pune');
 INSERT INTO Theatre (address, city) VALUES ('Gandhinagar, Ahmedabad', 'Ahmedabad');
 INSERT INTO Theatre (address, city) VALUES ('Mansarovar, Jaipur', 'Jaipur');
 INSERT INTO Theatre (address, city) VALUES ('Hazratganj, Lucknow', 'Lucknow');
 INSERT INTO Theatre (address, city) VALUES ('Fraser Road, Patna', 'Patna');
 INSERT INTO Theatre (address, city) VALUES ('Vijay Nagar, Indore', 'Indore');
 INSERT INTO Theatre (address, city) VALUES ('Athwa Gate, Surat', 'Surat');
 INSERT INTO Theatre (address, city) VALUES ('Arera Colony, Bhopal', 'Bhopal');
 INSERT INTO Theatre (address, city) VALUES ('Main Road, Ranchi', 'Ranchi');
 INSERT INTO Theatre (address, city) VALUES ('RS Puram, Coimbatore', 'Coimbatore');
 INSERT INTO Theatre (address, city) VALUES ('MG Road, Vijayawada', 'Vijayawada');
 INSERT INTO Theatre (address, city) VALUES ('Panaji, Goa', 'Goa');
 INSERT INTO Theatre (address, city) VALUES ('Palayam, Trivandrum', 'Trivandrum');
 INSERT INTO Theatre (address, city) VALUES ('Rajpur Road, Dehradun', 'Dehradun');

 -- Link Screens to Theatres
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (1, 1);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (2, 2);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (3, 3);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (4, 4);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (5, 5);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (6, 6);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (7, 7);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (8, 8);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (9, 9);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (10, 10);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (11, 11);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (12, 12);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (13, 13);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (14, 14);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (15, 15);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (16, 16);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (17, 17);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (18, 18);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (19, 19);
 INSERT INTO Theatre_Screens (theatre_theatre_id, screens_screen_id) VALUES (20, 20);

 -- Link Shows to Theatres
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (1, 1);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (2, 2);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (3, 3);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (4, 4);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (5, 5);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (6, 6);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (7, 7);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (8, 8);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (9, 9);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (10, 10);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (11, 11);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (12, 12);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (13, 13);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (14, 14);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (15, 15);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (16, 16);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (17, 17);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (18, 18);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (19, 19);
 INSERT INTO Theatre_Shows (theatre_theatre_id, shows_show_id) VALUES (20, 20);