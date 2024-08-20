-- create database ss1;

-- or use ss1 to choose database that you want;
use ss1;

CREATE TABLE user (
    id INT primary key,
    name VARCHAR(50),
    birthDay DATE,
    gender BIT,
    point DOUBLE
);

insert into user(id, name, birthDay, gender, point)
value(1, "Hoanglinh", "1999-01-06", 1, 10.0),
(2, "Hoanglinh", "1999-01-06", 1, 10.0),
(3, "Hoanglinh", "1999-01-06", 1, 10.0),
(4, "Hoanglinh", "1999-01-06", 1, 10.0);

SELECT 
    *
FROM
    user;

alter table user 
add column blame char(5);

set sql_safe_updates = 0;

update user
set name = "Tram Anh"
where id = 4;