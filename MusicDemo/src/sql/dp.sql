
create database 'musicserver' character set utf8;
use 'musicserver';

create table user
(
    id int auto_increment primary key,
    username varchar(20) not null,
    password varchar(32) not null
);


create table music
(
    id     int auto_increment
        primary key,
    title  varchar(50)  not null,
    singer varchar(30)  not null,
    time   varchar(13)  not null,
    url    varchar(100) not null,
    userid int          not null
);
create table mv
(
    id     int auto_increment
        primary key,
    title  varchar(50)  not null,
    singer varchar(30)  not null,
    time   varchar(13)  not null,
    url    varchar(100) not null,
    userid int          not null
);
create table lovemv
(
    id      int auto_increment
        primary key,
    user_id int not null,
    mv_id   int not null
);
create table lovemusic
(
    id       int auto_increment
        primary key,
    user_id  int not null,
    music_id int not null
);



