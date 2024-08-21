CREATE DATABASE ProductDB;
USE ProductDB;

CREATE TABLE Products (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    productCode VARCHAR(50) NOT NULL,
    productName VARCHAR(255) NOT NULL,
    productPrice DECIMAL(10, 2) NOT NULL,
    productAmount INT NOT NULL,
    productDescription TEXT,
    productStatus VARCHAR(50),
    UNIQUE(productCode) -- Unique constraint
);

-- Chèn dữ liệu mẫu
INSERT INTO Products (productCode, productName, productPrice, productAmount, productDescription, productStatus) VALUES
('P001', 'Product A', 100.00, 50, 'Description A', 'Available'),
('P002', 'Product B', 150.00, 30, 'Description B', 'Out of Stock'),
('P003', 'Product C', 200.00, 20, 'Description C', 'Available');

CREATE UNIQUE INDEX idx_productCode ON Products(productCode);
CREATE INDEX idx_productName_price ON Products(productName, productPrice);
EXPLAIN SELECT * FROM Products WHERE productName = 'Product A' AND productPrice = 100.00;

CREATE VIEW ProductView AS
SELECT productCode, productName, productPrice, productStatus
FROM Products;

ALTER VIEW ProductView AS
SELECT productCode, productName, productPrice, productStatus, productAmount
FROM Products;

DROP VIEW IF EXISTS ProductView;

DELIMITER //

CREATE PROCEDURE GetAllProducts()
BEGIN
    SELECT * FROM Products;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE AddProduct(
    IN p_productCode VARCHAR(50),
    IN p_productName VARCHAR(255),
    IN p_productPrice DECIMAL(10, 2),
    IN p_productAmount INT,
    IN p_productDescription TEXT,
    IN p_productStatus VARCHAR(50)
)
BEGIN
    INSERT INTO Products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
    VALUES (p_productCode, p_productName, p_productPrice, p_productAmount, p_productDescription, p_productStatus);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE UpdateProductById(
    IN p_id INT,
    IN p_productName VARCHAR(255),
    IN p_productPrice DECIMAL(10, 2),
    IN p_productAmount INT,
    IN p_productDescription TEXT,
    IN p_productStatus VARCHAR(50)
)
BEGIN
    UPDATE Products
    SET productName = p_productName,
        productPrice = p_productPrice,
        productAmount = p_productAmount,
        productDescription = p_productDescription,
        productStatus = p_productStatus
    WHERE Id = p_id;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE DeleteProductById(IN p_id INT)
BEGIN
    DELETE FROM Products WHERE Id = p_id;
END //

DELIMITER ;

CALL GetAllProducts();
CALL AddProduct('P004', 'Product D', 250.00, 10, 'Description D', 'Available');
CALL UpdateProductById(1, 'Product A Updated', 110.00, 60, 'Description A Updated', 'Available');
CALL DeleteProductById(2);
