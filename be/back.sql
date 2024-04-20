--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: role_enum; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.role_enum AS ENUM (
    'USER',
    'ADMIN'
);


ALTER TYPE public.role_enum OWNER TO postgres;

--
-- Name: files_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.files_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.files_id_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: files; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.files (
    id bigint DEFAULT nextval('public.files_id_seq'::regclass) NOT NULL,
    name character varying(50) NOT NULL,
    url character varying(100) NOT NULL,
    date timestamp without time zone NOT NULL
);


ALTER TABLE public.files OWNER TO postgres;

--
-- Name: flyway_schema_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);


ALTER TABLE public.flyway_schema_history OWNER TO postgres;

--
-- Name: songs_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.songs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.songs_id_seq OWNER TO postgres;

--
-- Name: songs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.songs (
    id bigint DEFAULT nextval('public.songs_id_seq'::regclass) NOT NULL,
    author character varying(50) NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.songs OWNER TO postgres;

--
-- Name: tabs_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tabs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tabs_id_seq OWNER TO postgres;

--
-- Name: tabs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tabs (
    id bigint DEFAULT nextval('public.tabs_id_seq'::regclass) NOT NULL,
    instrument_name character varying(50) NOT NULL,
    url character varying(150) NOT NULL,
    song_id bigint
);


ALTER TABLE public.tabs OWNER TO postgres;

--
-- Name: user_songs_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_songs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_songs_id_seq OWNER TO postgres;

--
-- Name: user_songs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_songs (
    id bigint DEFAULT nextval('public.user_songs_id_seq'::regclass) NOT NULL,
    user_id bigint NOT NULL,
    song_id bigint NOT NULL
);


ALTER TABLE public.user_songs OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint DEFAULT nextval('public.users_id_seq'::regclass) NOT NULL,
    name character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    password character varying(60) NOT NULL,
    role_type public.role_enum NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Data for Name: files; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.files (id, name, url, date) FROM stdin;
3	(.m4a	/storage/(.m4a	2024-04-14 16:00:54.535584
5	(.m4a	/storage/(.m4a	2024-04-14 16:04:28.652295
6	aria.m4a	/storage/aria.m4a	2024-04-15 11:49:00.238973
8	dead.m4a	/storage/dead.m4a	2024-04-15 12:01:34.655534
9	aria.m4a	/storage/aria.m4a	2024-04-16 14:31:57.991058
\.


--
-- Data for Name: flyway_schema_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
1	1.0.0.1	Create users table	SQL	V1.0.0_1__Create_users_table.sql	525908290	postgres	2024-03-27 11:56:25.899263	20	t
2	1.0.0.2	Create tabs table	SQL	V1.0.0_2__Create_tabs_table.sql	815144638	postgres	2024-03-27 11:56:25.962033	8	t
3	1.0.0.3	Create songs table	SQL	V1.0.0_3__Create_songs_table.sql	1245783469	postgres	2024-03-27 11:56:25.982081	7	t
4	1.0.0.4	Alter tabs table	SQL	V1.0.0_4__Alter_tabs_table.sql	1625613396	postgres	2024-03-27 11:56:25.999224	9	t
5	1.0.0.5	Create user songs table	SQL	V1.0.0_5__Create_user_songs_table.sql	-965390904	postgres	2024-03-27 11:56:26.01717	7	t
6	1.0.0.6	Insert test data in tables	SQL	V1.0.0_6__Insert_test_data_in_tables.sql	1620520154	postgres	2024-03-27 11:56:26.032284	10	t
7	1.0.0.7	Alter tabs table	SQL	V1.0.0_7__Alter_tabs_table.sql	-49679264	postgres	2024-04-11 16:35:47.266158	14	t
8	1.0.0.8	Create files table	SQL	V1.0.0_8__Create_files_table.sql	-1105784365	postgres	2024-04-13 14:12:07.704058	57	t
\.


--
-- Data for Name: songs; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.songs (id, author, name) FROM stdin;
1	Green Day	Holiday
2	Blink-182	Adams Song
3	Linking Park	Crawling
16	Danila Strushko	My song
19	Test test	test_name
21	qwer	qwer
\.


--
-- Data for Name: tabs; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tabs (id, instrument_name, url, song_id) FROM stdin;
2	Electric Bass	url2	1
3	Distortion Guitar rhythm	url3	1
4	Electric Bass	url4	2
5	Electric Guitar clean	url5	2
6	Distortion Guitar rhythm	url6	2
9	Guitar	url11	3
10	Bass	url22	3
1	Distortion Guitar lead	/storage/tab_test.png	1
34	acoustic guitar	https://i.pinimg.com/564x/12/fc/ab/12fcab16b6ff0ba2047449797341ee43.jpg	16
35	bass guitar	https://content.tomplay.com/preview/2022/09/Ima_Demons_INT_OV_ElectricBass_NotesTab_Danny_fl_emil_v2_25-08-2022_001.png	16
40	acoustic guitar	https://i.pinimg.com/564x/12/fc/ab/12fcab16b6ff0ba2047449797341ee43.jpg	19
41	bass guitar	https://content.tomplay.com/preview/2022/09/Ima_Demons_INT_OV_ElectricBass_NotesTab_Danny_fl_emil_v2_25-08-2022_001.png	19
44	acoustic guitar	https://i.pinimg.com/564x/12/fc/ab/12fcab16b6ff0ba2047449797341ee43.jpg	21
45	bass guitar	https://content.tomplay.com/preview/2022/09/Ima_Demons_INT_OV_ElectricBass_NotesTab_Danny_fl_emil_v2_25-08-2022_001.png	21
\.


--
-- Data for Name: user_songs; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_songs (id, user_id, song_id) FROM stdin;
1	1	2
2	2	1
3	1	3
6	4	16
9	4	19
11	4	21
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, name, email, password, role_type) FROM stdin;
2	Danila	danya.strushko@mail.ru	$2a$12$Jcz6pSrNPPLoW2UYZRpHfexviS7llX5FM7JQC7DQ5A7LiOv2FVdeS	ADMIN
4	testtttt	testt@mail.ru	$2a$10$UCLcsU7tzXXmk/7rKVIDcuFtyHn0lp/2YyM8fSTDp09XKxTxITz6a	USER
3	chelovek	aboba@mail.ru	$2a$10$2u8TVPumlra/y7bxl5ej7u3/o22MatHYGR7t/72rYecMyP2AdmGPW	ADMIN
1	igor	igor.work@mail.ru	$2a$12$lsHPcQz2ZeCBYnVGwiPOiegOjWFHUznrK9l7sikaAsAvXzx1YTsO6	ADMIN
\.


--
-- Name: files_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.files_id_seq', 9, true);


--
-- Name: songs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.songs_id_seq', 21, true);


--
-- Name: tabs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tabs_id_seq', 45, true);


--
-- Name: user_songs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_songs_id_seq', 11, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 4, true);


--
-- Name: files files_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.files
    ADD CONSTRAINT files_pkey PRIMARY KEY (id);


--
-- Name: flyway_schema_history flyway_schema_history_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);


--
-- Name: songs songs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.songs
    ADD CONSTRAINT songs_pkey PRIMARY KEY (id);


--
-- Name: tabs tabs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tabs
    ADD CONSTRAINT tabs_pkey PRIMARY KEY (id);


--
-- Name: user_songs user_songs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_songs
    ADD CONSTRAINT user_songs_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: flyway_schema_history_s_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);


--
-- Name: tabs tabs_song_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tabs
    ADD CONSTRAINT tabs_song_id_fkey FOREIGN KEY (song_id) REFERENCES public.songs(id) ON DELETE CASCADE;


--
-- Name: user_songs user_songs_song_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_songs
    ADD CONSTRAINT user_songs_song_id_fkey FOREIGN KEY (song_id) REFERENCES public.songs(id) ON DELETE CASCADE;


--
-- Name: user_songs user_songs_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_songs
    ADD CONSTRAINT user_songs_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

