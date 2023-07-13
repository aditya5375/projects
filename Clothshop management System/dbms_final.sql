






CREATE TABLE CUST(CUSTOMER_NAME text primary key,ADDRESS text,CONTACT_NUMBER text,PAY_AMT int,BILL_NO int);

create table employee(e_id serial primary key, e_name varchar(20), c_no int,land int);

create table Billing(Id serial primary key, Product_Name varchar(20), Department varchar(20),Company varchar(20),Quantity int,Price_Of_One int, Price int);

create table bill (B_DATE varchar(20),C_NAME varchar(20),AMT int,B_NO serial primary key , AMTG int,AMTR int);