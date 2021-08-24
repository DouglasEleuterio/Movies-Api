CREATE DATABASE IF NOT EXISTS quickdev;
USE quickdev;

CREATE TABLE IF NOT EXISTS roles(
                                    id int primary key auto_increment,
                                    name varchar(20)
);

CREATE TABLE IF NOT EXISTS users(
                                    id bigint primary key auto_increment,
                                    email varchar(50) not null unique ,
                                    password varchar(120) not null,
                                    username varchar(20) not null unique
);

CREATE TABLE IF NOT EXISTS user_roles(
                                    user_id bigint not null ,
                                    role_id int not null
);

CREATE TABLE IF NOT EXISTS movies(
                                    id int primary key auto_increment,
                                    title varchar(255) not null,
                                    genre varchar(50),
                                    cover_image varchar(255),
                                    overview varchar(255),
                                    rating float,
                                    release_date date
);

USE quickdev;

INSERT INTO roles (name) values ('ROLE_ADMIN'), ('ROLE_USER');