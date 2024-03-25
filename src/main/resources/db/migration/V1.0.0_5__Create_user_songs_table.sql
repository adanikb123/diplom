CREATE TABLE IF NOT EXISTS public."user_songs"
{
   id bigserial primary key,
   user_id REFERENCES public."users"(id) on delete cascade
   song_id REFERENCES public."songs"(id) on delete cascade
};
