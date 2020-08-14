create database order_system;
use order_system;

drop table if exists dishes;
create table dishes(
    dishId int primary key auto_increment,
    name varchar (50)unique ,
    price int --以分为单位，使用int表示，尽量不用double

);

drop table if exists user;
create table user(
    userId int primary key auto_increment,
    name varchar (50)unique ,
    password varchar (50),
    isAdmin int --是否是管理员，0 不是 1是
);

drop table if exists order_user;
create table order_user(
    orderId int primary key auto_increment,
    userId int, --用户id和user中的userId有关联
    time datetime, -- 下单时间
    isDone int, --是否订单完结  0未 1完结
    foreign key(userId) references user(userId)
);

drop table if exists order_dish;
create table order_dish(
    orderId int,--和order_user表中的orderId有外键关系
    dishId int, --dishId和dish表中dishId有外键关系
    foreign key(orderId) references order_user(orderId),
    foreign key(dishId) references dishes(dishId)
);


