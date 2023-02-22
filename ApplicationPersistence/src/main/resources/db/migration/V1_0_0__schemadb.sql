drop database if exists applicationdb;

create database if not exists applicationdb;

use applicationdb;

create table user(
ID int NOT NULL,
Name varchar(32),
Age int,
Accesslevel varchar(32),
PRIMARY KEY (ID)
);