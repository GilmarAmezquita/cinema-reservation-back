INSERT INTO authority(name, description) VALUES ('ROLE_USER', 'Clientes');
INSERT INTO authority(name, description) VALUES ('ROLE_ADMIN', 'Empleado');
INSERT INTO authority(name, description) VALUES ('ROLE_ADMIN', 'Gerente');

INSERT INTO "user"(first_name, last_name, address, authority_id, email, password, active) 
VALUES ('Juan', 'Perez', 'Calle 123', 1, 'juan.perez@gmail.com', '$2a$10$3qQYQKXHAlmGt.EyUfmnyOUbdEVtJzWwy7C1VYKSXMSlCTqv.tHeW', true);
INSERT INTO "user"(first_name, last_name, address, authority_id, email, password, active)
VALUES ('Maria', 'Gomez', 'Calle 456', 2, 'maria.gomez@gmail.com', '$2a$10$3qQYQKXHAlmGt.EyUfmnyOUbdEVtJzWwy7C1VYKSXMSlCTqv.tHeW', true);

INSERT INTO movie(name, director, duration_min, premiere, url, active)
VALUES ('The Shawshank Redemption', 'Frank Darabont', 142, '1994-10-14', 'https://m.media-amazon.com/images/M/MV5BMTA1MjE0Nzk4MDleQTJeQWpwZ15BbWU4MDA0NjIxMjAx._V1_FMjpg_UX364_.jpg', true);
INSERT INTO movie(name, director, duration_min, premiere, url, active)
VALUES ('The Godfather', 'Francis Ford Coppola', 175, '1972-03-24', 'https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX364_.jpg', true);
INSERT INTO movie(name, director, duration_min, premiere, url, active)
VALUES ('The Dark Knight', 'Christopher Nolan', 152, '2008-07-18', 'https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_FMjpg_UY2048_.jpg', true);
INSERT INTO movie(name, director, duration_min, premiere, url, active)
VALUES ('The Lord of the Rings: The Return of the King', 'Peter Jackson', 201, '2003-12-17', 'https://m.media-amazon.com/images/M/MV5BNGJjODMxZGMtOTFlNC00MjI4LThiZWUtZTU3ZGIxYzcxMTBiXkEyXkFqcGdeQXVyODc0OTEyNDU@._V1_.jpg', true);
INSERT INTO movie(name, director, duration_min, premiere, url, active)
VALUES ('Pulp Fiction', 'Quentin Tarantino', 154, '1994-10-14', 'https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX364_.jpg', true);

INSERT INTO room(capacity, active) VALUES (20, true);
INSERT INTO room(capacity, active) VALUES (25, true);
INSERT INTO room(capacity, active) VALUES (24, true);

INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 1, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 2, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 3, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 4, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 5, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 6, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 7, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 8, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 1, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 2, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 3, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 4, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 5, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 6, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 7, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 8, 10000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 1, 15000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 2, 15000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 3, 15000, 1, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 4, 15000, 1, true);

INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 1, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 2, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 3, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 4, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 5, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 6, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 7, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 8, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 1, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 2, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 3, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 4, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 5, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 6, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 7, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 8, 10000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 1, 15000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 2, 15000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 3, 15000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 4, 15000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 5, 15000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 6, 15000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 7, 15000, 2, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 8, 15000, 2, true);

INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 1, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 2, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 3, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 4, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 5, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 6, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 7, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (1, 8, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 1, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 2, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 3, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 4, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 5, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 6, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 7, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (2, 8, 10000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 1, 15000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 2, 15000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 3, 15000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (3, 4, 15000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (4, 1, 15000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (4, 2, 15000, 3, true);
INSERT INTO seat(row, number, price, room_id, active) VALUES (4, 3, 15000, 3, true);

INSERT INTO projection(start_date, movie_id, room_id, active)
VALUES ('2021-5-24 15:00:00', 1, 1, true);
INSERT INTO projection(start_date, movie_id, room_id, active)
VALUES ('2021-5-24 15:00:00', 2, 2, true);
INSERT INTO projection(start_date, movie_id, room_id, active)
VALUES ('2024-5-24 15:00:00', 1, 1, true);
INSERT INTO projection(start_date, movie_id, room_id, active)
VALUES ('2024-5-24 18:00:00', 2, 1, true);
INSERT INTO projection(start_date, movie_id, room_id, active)
VALUES ('2024-5-25 10:00:00', 2, 1, true);
INSERT INTO projection(start_date, movie_id, room_id, active)
VALUES ('2024-5-25 14:00:00', 1, 1, true);
INSERT INTO projection(start_date, movie_id, room_id, active)
VALUES ('2024-5-24 18:00:00', 2, 2, true);
INSERT INTO projection(start_date, movie_id, room_id, active)
VALUES ('2024-5-24 14:00:00', 1, 3, true);
INSERT INTO projection(start_date, movie_id, room_id, active)
VALUES ('2024-5-24 16:00:00', 1, 3, true);