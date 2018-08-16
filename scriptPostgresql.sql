--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.14
-- Dumped by pg_dump version 9.5.14

-- Started on 2018-08-16 00:57:29

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "DB_lineaBlanca";
--
-- TOC entry 2105 (class 1262 OID 16505)
-- Name: DB_lineaBlanca; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "DB_lineaBlanca" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';


ALTER DATABASE "DB_lineaBlanca" OWNER TO postgres;

\connect "DB_lineaBlanca"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2108 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 16518)
-- Name: t_usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_usuario (
    id_user integer NOT NULL,
    nombre character varying(50) NOT NULL,
    apellido character varying(50) NOT NULL,
    fecha_nacimiento date NOT NULL,
    telefono character varying(15) NOT NULL,
    direccion character varying(50) NOT NULL,
    correo character varying(50) NOT NULL,
    usuario character varying(50) NOT NULL,
    pass character varying(50) NOT NULL,
    tipo character varying(50) NOT NULL,
    super boolean
);


ALTER TABLE public.t_usuario OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16516)
-- Name: t_usuario_id_user_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.t_usuario_id_user_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t_usuario_id_user_seq OWNER TO postgres;

--
-- TOC entry 2109 (class 0 OID 0)
-- Dependencies: 181
-- Name: t_usuario_id_user_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.t_usuario_id_user_seq OWNED BY public.t_usuario.id_user;


--
-- TOC entry 1981 (class 2604 OID 16521)
-- Name: id_user; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_usuario ALTER COLUMN id_user SET DEFAULT nextval('public.t_usuario_id_user_seq'::regclass);


--
-- TOC entry 2099 (class 0 OID 16518)
-- Dependencies: 182
-- Data for Name: t_usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_usuario (id_user, nombre, apellido, fecha_nacimiento, telefono, direccion, correo, usuario, pass, tipo, super) FROM stdin;
1	Emilio	Moran	1997-06-04	0923455221	Norte	emilio@gmail.com	emilio	emilio	v	f
2	Eduardo	Ortiz	1997-02-03	0934819233	Centro	eduardo@gmail.com	eduardo	eduardo	g	f
3	Steffany	Vallejo	1997-02-05	0948374917	Norte	steffany@gmail.com	steffany	steffany	a	f
4	Ginger	Jacome	1997-04-04	0947382928	Sur	ginger@gmail.com	ginger	ginger	a	t
\.


--
-- TOC entry 2110 (class 0 OID 0)
-- Dependencies: 181
-- Name: t_usuario_id_user_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.t_usuario_id_user_seq', 1, false);


--
-- TOC entry 1983 (class 2606 OID 16523)
-- Name: t_usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_usuario
    ADD CONSTRAINT t_usuario_pkey PRIMARY KEY (id_user);


--
-- TOC entry 2107 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-08-16 00:57:29

--
-- PostgreSQL database dump complete
--

