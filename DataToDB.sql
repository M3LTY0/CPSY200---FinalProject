CREATE DATABASE village_rentals;
USE village_rentals;

CREATE TABLE category (
    categoryID INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE equipment (
    equipmentID INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    categoryID INT NOT NULL,
    description VARCHAR(255),
    dailyCost DECIMAL(10,2) NOT NULL,
    status VARCHAR(100) NOT NULL,
    FOREIGN KEY (categoryID) REFERENCES category(categoryID)
);

CREATE TABLE customer (
    customerID INT PRIMARY KEY,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    contactPhone VARCHAR(25) NOT NULL,
    email VARCHAR(100) NOT NULL,
    isBanned BOOLEAN NOT NULL
);

CREATE TABLE rental (
    rentalID INT PRIMARY KEY,
    customerID INT NOT NULL,
    equipmentID INT NOT NULL,
    currentDate DATE NOT NULL,
    rentalDate DATE NOT NULL,
    returnDate DATE NOT NULL,
    cost DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (customerID) REFERENCES customer(customerID),
    FOREIGN KEY (equipmentID) REFERENCES equipment(equipmentID)
);

INSERT INTO category (categoryID, name) VALUES
(10, 'Power tools'),
(20, 'Yard equipment'),
(30, 'Compressors'),
(40, 'Generators'),
(50, 'Air Tools');

INSERT INTO equipment (equipmentID, name, categoryID, description, dailyCost, status) VALUES
(101, 'Hammer drill', 10, 'Powerful drill for concrete and masonry', 25.99, 'Available'),
(201, 'Chainsaw', 20, 'Gas-powered chainsaw for cutting wood', 49.99, 'Available'),
(202, 'Lawn mower', 20, 'Self-propelled lawn mower with mulching function', 19.99, 'Available'),
(301, 'Small Compressor', 30, '5 Gallon Compressor-Portable', 14.99, 'Available'),
(501, 'Brad Nailer', 50, 'Brad Nailer. Requires 3/4 to 1 1/2 Brad Nails', 10.99, 'Available');

INSERT INTO customer (customerID, firstName, lastName, contactPhone, email, isBanned) VALUES
(1001, 'John', 'Doe', '(555) 555-1212', 'jd@sample.net','false'),
(1002, 'Jane', 'Smith', '(555) 555-3434', 'js@live.com','false'),
(1003, 'Michael', 'Lee',  '(555) 555-5656', 'ml@sample.net','false');

INSERT INTO rental (rentalID, customerID, equipmentID, currentDate, rentalDate, returnDate, cost) VALUES
(1000, 1001, 201, '2024-02-15', '2024-02-20', '2024-02-23', 149.97),
(1001, 1002, 501, '2024-02-16', '2024-02-21', '2024-02-25', 43.96);
