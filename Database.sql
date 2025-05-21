create database mynewdb;

use mynewdb;

CREATE TABLE products (
    productID VARCHAR(10) PRIMARY KEY,
    productName VARCHAR(100) NOT NULL,
    createBy VARCHAR(100) NOT NULL,
    createOn DATETIME NOT NULL,
    updateBy VARCHAR(100),
    updateOn DATETIME,
    deleteBy VARCHAR(100),
    deleteOn DATETIME
);

CREATE TABLE customers (
    customerID INT AUTO_INCREMENT PRIMARY KEY,
    customerName VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(20),
    address TEXT,
    createBy VARCHAR(100) NOT NULL,
    createOn DATETIME NOT NULL,
    updateBy VARCHAR(100),
    updateOn DATETIME,
    deleteBy VARCHAR(100),
    deleteOn DATETIME
);

CREATE TABLE transaction_status (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    createBy VARCHAR(100) NOT NULL,
    createOn DATETIME NOT NULL,
    updateBy VARCHAR(100),
    updateOn DATETIME,
	deleteBy VARCHAR(100),
    deleteOn DATETIME
)

CREATE TABLE transactions (
    id INT PRIMARY KEY,
    productID VARCHAR(10) NOT NULL,
    customerID INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    status INT NOT NULL,
    transactionDate DATETIME NOT NULL,
    createBy VARCHAR(100) NOT NULL,
    createOn DATETIME NOT NULL,
    updateBy VARCHAR(100),
    updateOn DATETIME,
    deleteBy VARCHAR(100),
    deleteOn DATETIME,
    FOREIGN KEY (productID) REFERENCES products(productID),
    FOREIGN KEY (customerID) REFERENCES customers(customerID),
    FOREIGN KEY (status) REFERENCES transaction_status(id)
);

INSERT INTO products (productID, productName, createBy, createOn) VALUES 
('10001', 'Test 1', 'system', '2022-07-01 00:00:00'),
('10002', 'Test 2', 'system', '2022-07-01 00:00:00');

INSERT INTO customers (customerName, email, phone, address, createBy, createOn) VALUES
('abc', 'abc@gmail.com', '08123456789', 'jakarta', 'admin', '2022-07-01 00:00:00');

INSERT INTO transaction_status (id, name, description, createBy, createOn) VALUES
(0, 'SUCCESS', 'Transaction success', 'system', NOW()),
(1, 'FAILED', 'Transaction failed', 'system', NOW());

INSERT INTO transactions (id, productID, customerID, amount, status, transactionDate, createBy, createOn) VALUES
(1372, '10001', 1, 1000.00, 0, '2022-07-10 11:14:52', 'abc', '2022-07-10 11:14:52'),
(1373, '10002', 1, 2000.00, 0, '2022-07-11 13:14:52', 'abc', '2022-07-10 13:14:52'),
(1374, '10001', 1, 1000.00, 0, '2022-08-10 12:14:52', 'abc', '2022-07-10 12:14:52'),
(1375, '10002', 1, 1000.00, 1, '2022-08-10 13:10:52', 'abc', '2022-07-10 13:10:52'),
(1376, '10001', 1, 1000.00, 0, '2022-08-10 13:11:52', 'abc', '2022-07-10 13:11:52'),
(1377, '10002', 1, 2000.00, 0, '2022-08-12 13:14:52', 'abc', '2022-07-10 13:14:52'),
(1378, '10001', 1, 1000.00, 0, '2022-08-12 14:11:52', 'abc', '2022-07-10 14:11:52'),
(1379, '10002', 1, 1000.00, 1, '2022-09-13 11:14:52', 'abc', '2022-07-10 11:14:52'),
(1380, '10001', 1, 1000.00, 0, '2022-09-13 13:14:52', 'abc', '2022-07-10 13:14:52'),
(1381, '10002', 1, 2000.00, 0, '2022-09-14 09:11:52', 'abc', '2022-07-10 09:11:52'),
(1382, '10001', 1, 1000.00, 0, '2022-09-14 10:14:52', 'abc', '2022-07-10 10:14:52'),
(1383, '10002', 1, 1000.00, 1, '2022-08-15 13:14:52', 'abc', '2022-07-10 13:14:52');