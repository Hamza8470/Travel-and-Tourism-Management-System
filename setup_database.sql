-- Create database if not exists
CREATE DATABASE IF NOT EXISTS tms;
USE tms;

-- Drop tables if they exist (for fresh setup)
DROP TABLE IF EXISTS bookpackage;
DROP TABLE IF EXISTS bookhotel;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS hotel;
DROP TABLE IF EXISTS account;

-- Account table for login credentials
CREATE TABLE account (
    username VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    answer VARCHAR(255) NOT NULL
);

-- Customer table
CREATE TABLE customer (
    username VARCHAR(100) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL,
    gender VARCHAR(20)
);

-- Hotel table
CREATE TABLE hotel (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100),
    price INT,
    image VARCHAR(255)
);

-- Hotel booking table
CREATE TABLE bookhotel (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    hotel_name VARCHAR(100),
    persons INT,
    checkIn DATE,
    checkOut DATE,
    total_price INT,
    FOREIGN KEY (username) REFERENCES account(username)
);

-- Package booking table
CREATE TABLE bookpackage (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    package_name VARCHAR(100),
    persons INT,
    startDate DATE,
    endDate DATE,
    total_price INT,
    FOREIGN KEY (username) REFERENCES account(username)
);

-- Insert sample admin account
INSERT INTO account VALUES ('admin', 'admin', 'admin');

-- Insert sample hotels
INSERT INTO hotel (name, location, price, image) VALUES 
('Hotel Paradise', 'Dubai', 5000, 'hotel1.jpg'),
('Taj Manor', 'Agra', 3000, 'hotel2.jpg'),
('Grand Hotel', 'London', 7000, 'hotel3.jpg'),
('Ocean View', 'Maldives', 8000, 'hotel4.jpg'),
('Mountain Resort', 'Switzerland', 6000, 'hotel5.jpg'),
('City Palace', 'Paris', 6500, 'hotel6.jpg'),
('Beach Resort', 'Bali', 4500, 'hotel7.jpg'),
('Royal Stay', 'Rome', 5500, 'hotel8.jpg'),
('Luxury Inn', 'Tokyo', 7500, 'hotel9.jpg'),
('Premium Suite', 'New York', 8500, 'hotel10.jpg');

-- Insert sample customer
INSERT INTO customer VALUES ('user1', 'John Doe', 'john@example.com', '1234567890', '123 Main St', 'Male');
INSERT INTO account VALUES ('user1', 'password123', 'answer123');

COMMIT;
