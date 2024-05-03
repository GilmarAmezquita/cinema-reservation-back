INSERT INTO authority(name, description) VALUES ('ROLE_USER', 'Clientes');
INSERT INTO authority(name, description) VALUES ('ROLE_ADMIN', 'Empleado');
INSERT INTO authority(name, description) VALUES ('ROLE_ADMIN', 'Gerente');

INSERT INTO "user"(first_name, last_name, address, authority_id, email, password, active) 
VALUES ('John', 'Doe', '123 Main St', 1, 'john.doe@gmail.com', 'password', true);

INSERT INTO "user"(first_name, last_name, address, authority_id, email, password, active)
VALUES ('Jane', 'Doe', '123 Main St', 2, 'jane.doe@gmail.com', 'password', true);

INSERT INTO movie(name, director, duration_min, premiere, active)
VALUES ('The Shawshank Redemption', 'Frank Darabont', 142, '1994-10-14', true);
INSERT INTO movie(name, director, duration_min, premiere, active)
VALUES ('The Godfather', 'Francis Ford Coppola', 175, '1972-03-24', true);

INSERT INTO room(capacity, active) VALUES (66, true);
INSERT INTO room(capacity, active) VALUES (60, true);
INSERT INTO room(capacity, active) VALUES (50, true);
INSERT INTO room(capacity, active) VALUES (40, true);