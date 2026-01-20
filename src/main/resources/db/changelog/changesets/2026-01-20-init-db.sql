-- liquibase formatted sql

-- changeset denis:1
CREATE TABLE sensors
(
    id   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(30) NOT NULL UNIQUE CHECK (char_length(name) BETWEEN 3 AND 30)
);

-- rollback DROP TABLE sensors;

-- changeset denis:2
CREATE TABLE measurements
(
    id                    BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    value                 DOUBLE PRECISION NOT NULL CHECK (value BETWEEN -100 AND 100),
    raining               BOOLEAN          NOT NULL,
    sensor_id             BIGINT           NOT NULL REFERENCES sensors (id),
    measurement_date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- rollback DROP TABLE measurements;
