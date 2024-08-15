create database homework_ss2_2;
use homework_ss2_2;

create table Customer(
	customer_id int primary key,
    name varchar(50),
    age int
);

create table OrderProduct(
	order_id int primary key,
    customer_id int,
    order_date date,
    totalPrice int,
	foreign key(customer_id) references Customer(customer_id)
);

create table Product(
	product_id int primary key,
    name varchar(50),
    price int
);

create table OrderDetails(
	order_id int,
    product_id int,
    primary key(order_id, product_id),
    foreign key(order_id) references OrderProduct(order_id),
    foreign key(product_id) references Product(product_id)
);