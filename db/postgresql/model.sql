DROP DATABASE IF EXISTS cinema_reservation;
CREATE DATABASE cinema_reservation;

\c cinema_reservation

DROP TABLE IF EXISTS authority CASCADE;
DROP TABLE IF EXISTS "user" CASCADE;
DROP TABLE IF EXISTS movie CASCADE;
DROP TABLE IF EXISTS room CASCADE;
DROP TABLE IF EXISTS seat CASCADE;
DROP TABLE IF EXISTS seat_reserved CASCADE;
DROP TABLE IF EXISTS projection CASCADE;
DROP TABLE IF EXISTS reservation CASCADE;

DROP SEQUENCE IF EXISTS authority_id_seq;
DROP SEQUENCE IF EXISTS user_id_seq;
DROP SEQUENCE IF EXISTS movie_id_seq;
DROP SEQUENCE IF EXISTS room_id_seq;
DROP SEQUENCE IF EXISTS seat_id_seq;
DROP SEQUENCE IF EXISTS seat_reserved_id_seq;
DROP SEQUENCE IF EXISTS projection_id_seq;
DROP SEQUENCE IF EXISTS reservation_id_seq;

CREATE SEQUENCE authority_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE user_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE movie_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE room_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seat_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seat_reserved_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE projection_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE reservation_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE authority (
    id          INTEGER NOT NULL DEFAULT nextval('authority_id_seq'::regclass) PRIMARY KEY,
    name        VARCHAR(155),
    description VARCHAR(155)
);

CREATE TABLE "user" (
    id           INTEGER NOT NULL DEFAULT nextval('user_id_seq'::regclass) PRIMARY KEY,
    first_name   VARCHAR(155),
    last_name    VARCHAR(155),
    address      VARCHAR(155),
    authority_id INTEGER NOT NULL,
    email        VARCHAR(155),
    password     VARCHAR(155),
    active       BOOLEAN,
    FOREIGN KEY ( authority_id ) REFERENCES authority ( id ) ON DELETE CASCADE
);


CREATE TABLE movie (
    id     INTEGER NOT NULL DEFAULT nextval('movie_id_seq'::regclass) PRIMARY KEY,
    name         VARCHAR(155),
    director     VARCHAR(155),
    duration_min INTEGER,
    premiere     DATE,
    active       BOOLEAN
);

CREATE TABLE room (
    id       INTEGER NOT NULL DEFAULT nextval('room_id_seq'::regclass) PRIMARY KEY,
    capacity INTEGER,
    active   BOOLEAN
);

CREATE TABLE seat (
    id      INTEGER NOT NULL DEFAULT nextval('seat_id_seq'::regclass) PRIMARY KEY,
    row     INTEGER,
    number  INTEGER,
    price   INTEGER,
    room_id INTEGER NOT NULL,
    active  BOOLEAN,
    FOREIGN KEY ( room_id ) REFERENCES room ( id ) ON DELETE CASCADE
);

CREATE TABLE projection (
    id         INTEGER NOT NULL DEFAULT nextval('projection_id_seq'::regclass) PRIMARY KEY,
    start_date TIMESTAMP,
    movie_id   INTEGER NOT NULL,
    room_id    INTEGER NOT NULL,
    active     BOOLEAN,
    FOREIGN KEY ( movie_id ) REFERENCES movie ( id ) ON DELETE CASCADE,
    FOREIGN KEY ( room_id ) REFERENCES room ( id ) ON DELETE CASCADE
);

CREATE TABLE reservation (
    id            INTEGER NOT NULL DEFAULT nextval('reservation_id_seq'::regclass) PRIMARY KEY,
    seats         INTEGER,
    projection_id INTEGER NOT NULL,
    user_id       INTEGER NOT NULL,
    active        BOOLEAN,
    FOREIGN KEY ( projection_id ) REFERENCES projection ( id ) ON DELETE CASCADE,
    FOREIGN KEY ( user_id ) REFERENCES "user" ( id ) ON DELETE CASCADE
);

CREATE TABLE seat_reserved (
    id             INTEGER NOT NULL DEFAULT nextval('seat_reserved_id_seq'::regclass) PRIMARY KEY,
    seat_id        INTEGER NOT NULL,
    reservation_id INTEGER NOT NULL,
    projection_id  INTEGER NOT NULL,
    active         BOOLEAN,
    FOREIGN KEY ( seat_id ) REFERENCES seat ( id ) ON DELETE CASCADE,
    FOREIGN KEY ( reservation_id ) REFERENCES reservation ( id ) ON DELETE CASCADE,
    FOREIGN KEY ( projection_id ) REFERENCES projection ( id ) ON DELETE CASCADE
);