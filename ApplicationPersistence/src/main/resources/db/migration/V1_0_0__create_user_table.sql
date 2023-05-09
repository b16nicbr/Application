CREATE TABLE USER(
id int NOT NULL AUTO_INCREMENT,
username varchar(32),
password varchar(100) UNIQUE,
age int,
PRIMARY KEY (id)
);