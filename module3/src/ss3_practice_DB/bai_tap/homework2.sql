use homework_ss2_2;

insert into customer(customer_id,name,age)
value(1,"Minh Quan",10);
insert into customer(customer_id,name,age)
value(2,"Ngoc Oanh",20);
insert into customer(customer_id,name,age)
value(3,"Hong Ha",50);

insert into product(product_id, name, price)
value(1,"may giat",3);
insert into product(product_id, name, price)
value(2,"tu lanh",5);
insert into product(product_id, name, price)
value(3,"dieu hoa",7);
insert into product(product_id, name, price)
value(4,"quat",1);
insert into product(product_id, name, price)
value(5,"bep dien",2);
insert into product(product_id, name, price)
value(6,"tivi",6);

insert into orderproduct(order_id,customer_id,order_date,totalPrice)
value(1, 1, "2006/03/21", null);
insert into orderproduct(order_id,customer_id,order_date,totalPrice)
value(2, 2, "2006/03/23", null);
insert into orderproduct(order_id,customer_id,order_date,totalPrice)
value(3, 1, "2006/03/16", null);

insert into orderdetails(order_id, product_id, quantity)
value(1,1,3);
insert into orderdetails(order_id, product_id, quantity)
value(1,3,7);
insert into orderdetails(order_id, product_id, quantity)
value(1,4,2);
insert into orderdetails(order_id, product_id, quantity)
value(2,1,1);
insert into orderdetails(order_id, product_id, quantity)
value(3,1,8);
insert into orderdetails(order_id, product_id, quantity)
value(2,5,4);
insert into orderdetails(order_id, product_id, quantity)
value(2,3,3);
insert into orderdetails(order_id, product_id, quantity)
value(3,4,4);

select * from orderproduct;
select customer.name, product.name 
from orderproduct 
join customer on orderproduct.customer_id = customer.customer_id 
right join orderdetails on orderdetails.order_id = orderproduct.order_id 
join product on orderdetails.product_id = product.product_id
order by customer.name;

SELECT customer.name
FROM customer
LEFT JOIN orderproduct ON customer.customer_id = orderproduct.customer_id
WHERE orderproduct.order_id IS NULL;

select op.order_id, op.order_date, sum(p.price * od.quantity) as total_price
from orderproduct op
join orderdetails od on op.order_id = od.order_id
join product p on od.product_id = p.product_id
group by op.order_id, op.order_date;

