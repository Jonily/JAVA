create database river_control;
use river_control;
create table river
(
    river_num int AUTO_INCREMENT,
    river_name varchar(30) not null ,
    river_length varchar(20) not null,
    river_location varchar(50) not null ,
    river_class varchar(30) not null ,
    river_status varchar(30) not null ,
    primary key (river_num)
);


