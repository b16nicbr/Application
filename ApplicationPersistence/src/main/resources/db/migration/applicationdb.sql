drop database if exists applicationdb;

create database if not exists applicationdb;

use applicationdb;

create table user(
name varchar(32),
age integer(4),
accesslevel varchar(32)
);