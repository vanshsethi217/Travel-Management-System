create database TravelManagement;
show databases;
use TravelManagement;
create table account(username varchar(20),name varchar(20),password varchar(20),security varchar(100),answer varchar(50));
show tables;
select * from account;
create table customer(username varchar(20),id varchar(30),number varchar (30),name varchar (30), 
gender  varchar (20),country varchar(30),address varchar(50),phone varchar(15),email varchar(40));
select * from customer;
create table bookpackage(username varchar(20),package varchar(30),persons varchar (30),id varchar (30),
 number  varchar (20),phone varchar(30),price varchar(50));
select * from bookpackage;
create table hotel(name varchar(30),costperperson varchar(30),acroom varchar(30),foodincluded varchar(30));
insert into hotel values('Raddison Blue Hotel','3400','1000','1700');
insert into hotel values('Hotel Bliss','2500','300','600');
insert into hotel values('The Taj Hotel','8000','3000','3500');
select * from hotel;                    
CREATE TABLE bookhotel (username VARCHAR(30), name VARCHAR(30), persons VARCHAR(30),
 days VARCHAR(30), ac VARCHAR(30), food VARCHAR(30), id VARCHAR(30), number VARCHAR(30), phone VARCHAR(30), price VARCHAR(30));
select * from bookhotel;
CREATE TABLE booked_destinations (id INT AUTO_INCREMENT PRIMARY KEY,username VARCHAR(50) NOT NULL,destination VARCHAR(100) NOT NULL,
    booking_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
select * from booked_destinations;


