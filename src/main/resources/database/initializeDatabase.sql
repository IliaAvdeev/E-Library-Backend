CREATE TABLE IF NOT EXISTS genres
(
    id    BIGSERIAL PRIMARY KEY,
    name  VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS cycles
(
    id    BIGSERIAL PRIMARY KEY,
    name  VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS authors
(
    id    BIGSERIAL PRIMARY KEY,
    name  VARCHAR(200) NOT NULL,
    date_of_birth DATE NOT NULL,
    date_of_death DATE,
    country_of_birth VARCHAR(200) NOT NULL,
    country_of_death VARCHAR(200),
    biography TEXT
);

CREATE TABLE IF NOT EXISTS books
(
    id    BIGSERIAL PRIMARY KEY,
    title  VARCHAR(500) NOT NULL,
    author_id BIGINT NOT NULL REFERENCES authors(id),
    genre_id BIGINT NOT NULL REFERENCES genres(id),
    cycle_id BIGINT REFERENCES cycles(id),
    description TEXT,
    text TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS roles
(
    id BIGSERIAL PRIMARY KEY,
    role_name VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    username VARCHAR(65) NOT NULL UNIQUE,
    password VARCHAR(65) NOT NULL,
    role BIGINT DEFAULT 2 REFERENCES roles(id)
);
