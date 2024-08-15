CREATE DATABASE homework_ss1;
use homework_ss1;

CREATE TABLE Class (
    id INT,
    name VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE Teacher (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    country VARCHAR(50)
)

select * from homework_ss1;