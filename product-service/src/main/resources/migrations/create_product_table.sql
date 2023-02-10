--liquibase formatted sql

create table product (
    id int not null auto_increment primary key,
    name varchar(30),
    description varchar(80) not null
);


