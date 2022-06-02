CREATE TABLE product (id serial PRIMARY KEY , model varchar(50) not null ,
 manufacturer varchar(50) default 'NONAME', description varchar (200) default 'NO DESCRIPTION YET', rating int, votes int );