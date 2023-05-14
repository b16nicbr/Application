CREATE TABLE BOOK (
id int not null AUTO_INCREMENT,
name varchar(50),
authorName varchar(50),
price NUMERIC not null,
note varchar(256),
PRIMARY KEY (id)
);