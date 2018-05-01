CREATE ROLE sensoric WITH LOGIN PASSWORD '*********';
CREATE DATABASE sensoric;

#\c sensoric

CREATE TABLE sensor_types (
    id UUID PRIMARY KEY,
    name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE locations (
    id UUID PRIMARY KEY,
    name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE sensors (
    id UUID PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    sensor_type_id UUID NOT NULL,
    location_id UUID NOT NULL,
    FOREIGN KEY (sensor_type_id) REFERENCES sensor_types (id),
    FOREIGN KEY (location_id) REFERENCES locations (id),
    UNIQUE (name, sensor_type_id, location_id)
);

GRANT SELECT, UPDATE, DELETE, INSERT ON ALL TABLES IN SCHEMA public TO sensoric;
