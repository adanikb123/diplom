CREATE TABLE IF NOT EXISTS public."tabs"
(
    id bigserial primary key,
    instrument_name varchar(50) NOT NULL,
    url varchar(70) NOT NULL
);