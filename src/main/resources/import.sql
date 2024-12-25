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
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('AVENGERS', 128);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('BAAHUBALI', 180);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('INCEPTION', 148);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('INTERSTELLAR', 169);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('THE-DARK-KNIGHT', 152);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('FAST-X', 140);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('MISSION IMPOSSIBLE', 150);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('SPIDERMAN', 130);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('JOKER', 122);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('TOP-GUN', 145);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('BLACK-ADAM', 135);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('DUNE', 155);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('TENET', 150);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('DOCTOR-STRANGE', 126);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('NO-TIME-TO-DIE', 163);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('JURASSIC-WORLD', 147);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('MATRIX-RESURRECTIONS', 148);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('THE-BATMAN', 175);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('SHAZAM', 132);
--INSERT INTO Movie (movie_name, movie_duration_in_minutes) VALUES ('BLACK-PANTHER', 134);

INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('AVENGERS', 128, 'https://imgc.allpostersimages.com/img/posters/trends-international-24x36-marvel-avengers-endgame-one-sheet_u-l-q1s2cks0.jpg?artHeight=550&artPerspective=y&artWidth=550&background=ffffff', 8.4, '2.3M', 'Action, Sci-Fi', 'Earths mightiest heroes...', ARRAY ['Robert Downey Jr.', 'Chris Evans', 'Scarlett Johansson']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('BAAHUBALI', 180, 'https://posters.movieposterdb.com/15_08/2015/2631186/l_2631186_c8f6b550.jpg', 8.0, '1.5M', 'Action, Drama', 'The epic story of Mahishmati...', ARRAY [ 'Prabhas', 'Rana Daggubati', 'Anushka Shetty']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('INCEPTION', 148, 'https://www.movieposters.com/cdn/shop/products/7dfddd911b8040729896c5be83f8e139_6e2f4149-8cb4-414c-a33b-9e0065c55af3_480x.progressive.jpg?v=1573585216', 8.8, '3.2M', 'Sci-Fi, Thriller', 'A thief who enters peoples dreams...', ARRAY ['Leonardo DiCaprio', 'Joseph Gordon-Levitt', 'Ellen Page']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('INTERSTELLAR', 169, 'https://posters.movieposterdb.com/14_09/2014/816692/l_816692_593eaeff.jpg', 8.6, '2.9M', 'Adventure, Sci-Fi', 'A journey beyond the stars...', ARRAY ['Matthew McConaughey', 'Anne Hathaway', 'Jessica Chastain']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('THE-DARK-KNIGHT', 152, 'https://posters.movieposterdb.com/08_06/2008/468569/s_468569_fe24b125.jpg', 9.0, '3.8M', 'Action, Crime', 'Batman battles the Joker...', ARRAY ['Christian Bale', 'Heath Ledger', 'Aaron Eckhart']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('FAST-X', 140, 'https://posters.movieposterdb.com/23_06/2023/5433140/s_fast-x-movie-poster_ab07f49f.jpg', 7.0, '1.1M', 'Action, Thriller', 'The Fast saga continues...', ARRAY ['Vin Diesel', 'Jason Statham', 'Michelle Rodriguez']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('MISSION IMPOSSIBLE', 150, 'https://posters.movieposterdb.com/15_04/2015/2381249/s_2381249_776d8196.jpg', 7.8, '1.8M', 'Action, Adventure', 'Ethan Hunt on another mission...', ARRAY ['Tom Cruise', 'Simon Pegg', 'Ving Rhames']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('SPIDERMAN', 130, 'https://posters.movieposterdb.com/22_11/2000/258979/s_spider-man-movie-poster_aa92f2d0.jpg', 7.9, '1.9M', 'Action, Fantasy', 'A boy becomes a spider superhero...', ARRAY ['Tobey Maguire', 'Kirsten Dunst', 'James Franco']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('JOKER', 122, 'https://posters.movieposterdb.com/22_05/2019/7286456/s_7286456_b64564c5.jpg', 8.4, '3.5M', 'Crime, Drama', 'The origin story of the Joker...', ARRAY ['Joaquin Phoenix', 'Robert De Niro', 'Zazie Beetz']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('TOP-GUN', 145, 'https://posters.movieposterdb.com/22_05/2020/1745960/s_1745960_cc176006.jpg', 7.5, '1.6M', 'Action, Drama', 'The story of an elite fighter pilot...', ARRAY ['Tom Cruise', 'Val Kilmer', 'Kelly McGillis']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('BLACK-ADAM', 135, 'https://posters.movieposterdb.com/22_09/2022/6443346/s_6443346_7b78199e.jpeg', 6.5, '0.8M', 'Action, Fantasy', 'Black Adam emerges as an antihero...', ARRAY ['Dwayne Johnson', 'Pierce Brosnan', 'Noah Centineo']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('DUNE', 155, 'https://posters.movieposterdb.com/21_08/2021/1160419/s_1160419_565d3d10.jpg', 8.2, '2.1M', 'Adventure, Sci-Fi', 'The story of Paul Atreides...', ARRAY ['Timothée Chalamet', 'Rebecca Ferguson', 'Oscar Isaac']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('TENET', 150, 'https://posters.movieposterdb.com/20_09/2020/6723592/s_6723592_46561c38.jpg', 7.5, '1.7M', 'Action, Sci-Fi', 'A time-bending espionage mission...', ARRAY ['John David Washington', 'Robert Pattinson', 'Elizabeth Debicki']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('DOCTOR-STRANGE', 126, 'https://posters.movieposterdb.com/20_08/2013/1211837/s_1211837_b473cc46.jpg', 7.5, '2.0M', 'Action, Fantasy', 'A neurosurgeon turned sorcerer...', ARRAY ['Benedict Cumberbatch', 'Tilda Swinton', 'Chiwetel Ejiofor']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('NO-TIME-TO-DIE', 163, 'https://posters.movieposterdb.com/09_05/2006/899070/s_899070_fe57f700.jpg', 7.3, '1.2M', 'Action, Adventure', 'James Bond faces his past...', ARRAY ['Daniel Craig', 'Rami Malek', 'Léa Seydoux']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('JURASSIC-WORLD', 147, 'https://img.moviepostershop.com/jurassic-park-movie-poster-1992-1010141477.jpg', 7.0, '2.5M', 'Action, Sci-Fi', 'Dinosaurs roam the Earth again...', ARRAY ['Chris Pratt', 'Bryce Dallas Howard', 'Vincent D Onofrio']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('MATRIX-RESURRECTIONS', 148, 'https://posters.movieposterdb.com/22_10/1993/106062/s_matrix-movie-poster_24ff14fa.jpg', 6.6, '0.9M', 'Action, Sci-Fi', 'The Matrix returns...', ARRAY ['Keanu Reeves', 'Carrie-Anne Moss', 'Yahya Abdul-Mateen II']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('THE-BATMAN', 175, 'https://posters.movieposterdb.com/14_10/1989/96895/s_96895_78c0479e.jpg', 8.3, '2.7M', 'Action, Crime', 'A young Batman investigates...', ARRAY ['Robert Pattinson', 'Zoë Kravitz', 'Paul Dano']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('SHAZAM', 132, 'https://posters.movieposterdb.com/20_01/2019/448115/s_448115_dfc6c3a2.jpg', 7.1, '1.4M', 'Action, Comedy', 'A boy gains superhero powers...', ARRAY ['Zachary Levi', 'Mark Strong', 'Asher Angel']);
INSERT INTO Movie (    movie_name,    movie_duration_in_minutes,    poster_url,    rating,    votes,    genre,    description,    casts)VALUES('BLACK-PANTHER', 134, 'https://posters.movieposterdb.com/22_06/2018/1825683/s_1825683_d608586c.jpg', 7.8, '2.3M', 'Action, Adventure', 'A prince becomes a superhero...', ARRAY ['Chadwick Boseman', 'Michael B. Jordan', 'Lupita Nyongo']);


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