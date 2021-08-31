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
    author_id BIGSERIAL NOT NULL REFERENCES authors(id),
    genre_id BIGSERIAL NOT NULL REFERENCES genres(id),
    cycle_id BIGSERIAL REFERENCES cycles(id),
    description TEXT,
    text TEXT NOT NULL
);
