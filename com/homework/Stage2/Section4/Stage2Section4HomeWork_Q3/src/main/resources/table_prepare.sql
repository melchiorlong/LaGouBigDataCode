create database springmvc_db;


create table dept
(
    deptId       integer auto_increment primary key,
    deptName     nvarchar(30),
    supervisorId integer,
    phone        nvarchar(20),
    mail         nvarchar(40)
);


create table person
(
    personId   integer auto_increment primary key,
    personName nvarchar(30),
    positionId integer,
    phone      nvarchar(20)
);


create table position
(
    positionId   integer auto_increment primary key,
    positionName nvarchar(30),
    deptId       integer,
    isSupervisor boolean
);

create table customer
(
    customerId        integer auto_increment primary key,
    customerName      nvarchar(30),
    accountBankNumber integer (20),
    phone             nvarchar(20),
    address           nvarchar(100),
    managerId         integer
);


create table records
(
    customerId        integer auto_increment primary key,
    customerName      nvarchar(30),
    accountBankNumber integer(20),
    phone             nvarchar(20),
    address           nvarchar(100),
    managerId         integer
);
