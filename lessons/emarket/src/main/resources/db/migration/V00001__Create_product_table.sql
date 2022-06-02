CREATE TABLE product
(
    id           serial PRIMARY KEY,
    name         varchar(50) not null,
    model        varchar(50) not null,
    manufacturer varchar(50)  default 'NONAME',
    description  varchar(200) default 'NO DESCRIPTION YET',
    score        int          default 0,
    votes        int          default 0,
    UNIQUE(name, model, manufacturer)
);