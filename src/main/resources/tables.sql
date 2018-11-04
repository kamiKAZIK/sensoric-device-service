CREATE ROLE sensoric WITH LOGIN PASSWORD '*********';
CREATE DATABASE sensoric;

#\c sensoric

CREATE TABLE sensor_types (
    id UUID PRIMARY KEY,
    name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE devices (
    id UUID PRIMARY KEY,
    name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE sensors (
    id UUID PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    sensor_type_id UUID NOT NULL,
    device_id UUID NOT NULL,
    FOREIGN KEY (sensor_type_id) REFERENCES sensor_types (id),
    FOREIGN KEY (device_id) REFERENCES devices (id),
    UNIQUE (name, sensor_type_id, device_id)
);

GRANT SELECT, UPDATE, DELETE, INSERT ON ALL TABLES IN SCHEMA public TO sensoric;
