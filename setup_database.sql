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
    name VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    security VARCHAR(255),
    answer VARCHAR(255)
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
    -- Note: application expects cost_per_day, food_charges and ac_charges columns
    name VARCHAR(100) PRIMARY KEY,
    location VARCHAR(100),
    cost_per_day INT DEFAULT 0,
    food_charges INT DEFAULT 0,
    ac_charges INT DEFAULT 0,
    image VARCHAR(255)
);

-- Hotel booking table
CREATE TABLE bookhotel (
    username VARCHAR(100),
    hotel_name VARCHAR(100),
    persons INT,
    days INT,
    ac VARCHAR(10),
    food VARCHAR(10),
    id VARCHAR(100),
    number VARCHAR(100),
    phone VARCHAR(100),
    total_price VARCHAR(100),
    FOREIGN KEY (username) REFERENCES account(username)
);

-- Package booking table
CREATE TABLE bookpackage (
    username VARCHAR(100),
    package VARCHAR(100),
    persons INT,
    id VARCHAR(100),
    number VARCHAR(100),
    phone VARCHAR(100),
    price VARCHAR(100),
    FOREIGN KEY (username) REFERENCES account(username)
);

-- Insert sample admin account (username, name, password, security, answer)
INSERT INTO account VALUES ('admin', 'Administrator', 'admin', 'Your fav Cartoon charactor ?', 'admin');

-- Insert sample hotels
-- Insert sample hotels (with cost_per_day, food_charges, ac_charges)
INSERT INTO hotel (name, location, cost_per_day, food_charges, ac_charges, image) VALUES 
('Hotel Paradise', 'Dubai', 5000, 500, 800, 'hotel1.jpg'),
('Taj Manor', 'Agra', 3000, 300, 500, 'hotel2.jpg'),
('Grand Hotel', 'London', 7000, 700, 1000, 'hotel3.jpg'),
('Ocean View', 'Maldives', 8000, 800, 1200, 'hotel4.jpg'),
('Mountain Resort', 'Switzerland', 6000, 600, 900, 'hotel5.jpg'),
('City Palace', 'Paris', 6500, 650, 950, 'hotel6.jpg'),
('Beach Resort', 'Bali', 4500, 450, 700, 'hotel7.jpg'),
('Royal Stay', 'Rome', 5500, 550, 850, 'hotel8.jpg'),
('Luxury Inn', 'Tokyo', 7500, 750, 1100, 'hotel9.jpg'),
('Premium Suite', 'New York', 8500, 850, 1300, 'hotel10.jpg');

-- Insert sample customer and corresponding account
INSERT INTO customer VALUES ('user1', 'John Doe', 'john@example.com', '1234567890', '123 Main St', 'Male');
INSERT INTO account VALUES ('user1', 'John Doe', 'password123', 'Your fav Books ?', 'answer123');

COMMIT;
