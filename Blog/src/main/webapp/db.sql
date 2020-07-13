drop databases if exists blog;
create databases blog;


use blog;


drop table if exists user;
create table user(
       userId int primary key auto_increment,
       name varchar(50) unique,
       password varchar(50)
);

drop table if exists article;
create table article(
       article int primary key auto_increment;
       tittle varchar(255),
       context text,
       userId int
       foreign key(userId) references user(userId)
);