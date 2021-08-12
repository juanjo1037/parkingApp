DROP DATABASE IF EXISTS parkingapp;
CREATE DATABASE parkingapp;
USE parkingapp;

CREATE TABLE parkingapp.vehicle (
    plate varchar(7) NOT NULL,
    `type` varchar(15) NULL,
    service_id INTEGER NULL,
    created_at DATETIME DEFAULT now() NOT NULL,
    updated_at DATETIME DEFAULT now() NOT NULL,
    CONSTRAINT vehicle_PK PRIMARY KEY (plate)
);
CREATE UNIQUE INDEX vehicle_plate_IDX USING BTREE ON parkingapp.vehicle (plate,service_id);
