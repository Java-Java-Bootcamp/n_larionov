CREATE TABLE store
(
    id    serial PRIMARY KEY,
    name  varchar(50) not null UNIQUE,
    score int default 0,
    votes int default 0
);