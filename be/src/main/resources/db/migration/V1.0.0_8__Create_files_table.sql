CREATE TABLE IF NOT EXISTS public."files"
(
    id bigserial primary key,
    name varchar(50) NOT NULL,
    url varchar(100) NOT NULL,
    date timestamp NOT NULL
);