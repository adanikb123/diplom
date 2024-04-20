CREATE TYPE public.role_enum AS ENUM
   ('USER','ADMIN');

CREATE TABLE IF NOT EXISTS public."users"
(
    id bigserial primary key,
    name varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    password varchar(60) NOT NULL,
    role_type public.role_enum NOT NULL
);