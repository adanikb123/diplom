CREATE TABLE IF NOT EXISTS public."user_songs"
(
   id bigserial primary key,
   user_id bigint NOT NULL REFERENCES public."users"(id) on delete cascade,
   song_id bigint NOT NULL REFERENCES public."songs"(id) on delete cascade
);
