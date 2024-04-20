ALTER TABlE IF EXISTS public."tabs"
add column song_id bigint references public."songs"(id) on delete cascade