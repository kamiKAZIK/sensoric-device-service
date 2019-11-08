CREATE ROLE sensoric WITH LOGIN PASSWORD '*********';
CREATE DATABASE sensoric;

#\c sensoric

CREATE TABLE namespaces (
    id UUID PRIMARY KEY,
    name VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE devices (
    id UUID PRIMARY KEY,
    serial_number VARCHAR(128) NOT NULL UNIQUE
    namespace_id UUID NOT NULL,
    CONSTRAINT device_namespace_fk FOREIGN KEY(namespace_id) REFERENCES namespaces(id)
);

CREATE TABLE sensors (
    id UUID PRIMARY KEY,
    serial_number VARCHAR(128) NOT NULL UNIQUE,
    device_id UUID NOT NULL,
    CONSTRAINT sensor_device_fk FOREIGN KEY(device_id) REFERENCES devices(id)
);

GRANT SELECT, UPDATE, DELETE, INSERT ON ALL TABLES IN SCHEMA public TO sensoric;
