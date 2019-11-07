CREATE ROLE sensoric WITH LOGIN PASSWORD '*********';
CREATE DATABASE sensoric;

#\c sensoric

CREATE TABLE devices (
    id UUID PRIMARY KEY,
    serial_number VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE sensors (
    id UUID PRIMARY KEY,
    serial_number VARCHAR(128) NOT NULL UNIQUE,
    device_id UUID NOT NULL,
    CONSTRAINT sensor_device_fk FOREIGN KEY(device_id) REFERENCES devices(id)
);

GRANT SELECT, UPDATE, DELETE, INSERT ON ALL TABLES IN SCHEMA public TO sensoric;
