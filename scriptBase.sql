--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.14
-- Dumped by pg_dump version 9.5.14

-- Started on 2018-08-18 01:14:06

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
-- TOC entry 2194 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 184 (class 1259 OID 16404)
-- Name: t_articulo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_articulo (
    id_art integer NOT NULL,
    nombre character varying(50) NOT NULL,
    descripcion character varying(100) NOT NULL,
    categoria date NOT NULL,
    stock integer NOT NULL,
    estado boolean NOT NULL,
    precio double precision NOT NULL,
    marca character varying(50) NOT NULL
);


ALTER TABLE public.t_articulo OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 16402)
-- Name: t_articulo_id_art_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.t_articulo_id_art_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t_articulo_id_art_seq OWNER TO postgres;

--
-- TOC entry 2195 (class 0 OID 0)
-- Dependencies: 183
-- Name: t_articulo_id_art_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.t_articulo_id_art_seq OWNED BY public.t_articulo.id_art;


--
-- TOC entry 190 (class 1259 OID 16444)
-- Name: t_cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_cliente (
    id_cliente integer NOT NULL,
    nombre character varying(50) NOT NULL,
    apellido character varying(50) NOT NULL,
    fecha_nacimiento date NOT NULL,
    telefono character varying(20) NOT NULL,
    direccion character varying(50) NOT NULL,
    correo character varying(50) NOT NULL
);


ALTER TABLE public.t_cliente OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 16442)
-- Name: t_cliente_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.t_cliente_id_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t_cliente_id_cliente_seq OWNER TO postgres;

--
-- TOC entry 2196 (class 0 OID 0)
-- Dependencies: 189
-- Name: t_cliente_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.t_cliente_id_cliente_seq OWNED BY public.t_cliente.id_cliente;


--
-- TOC entry 192 (class 1259 OID 16452)
-- Name: t_cotizacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_cotizacion (
    id_cot integer NOT NULL,
    cantidad integer NOT NULL,
    valor double precision NOT NULL,
    id_cliente integer NOT NULL,
    id_usuario integer NOT NULL,
    id_articulo integer NOT NULL
);


ALTER TABLE public.t_cotizacion OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 16450)
-- Name: t_cotizacion_id_cot_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.t_cotizacion_id_cot_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t_cotizacion_id_cot_seq OWNER TO postgres;

--
-- TOC entry 2197 (class 0 OID 0)
-- Dependencies: 191
-- Name: t_cotizacion_id_cot_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.t_cotizacion_id_cot_seq OWNED BY public.t_cotizacion.id_cot;


--
-- TOC entry 188 (class 1259 OID 16436)
-- Name: t_local; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_local (
    id_local integer NOT NULL,
    direccion character varying(50) NOT NULL,
    telefono character varying(20) NOT NULL,
    internet boolean
);


ALTER TABLE public.t_local OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 16434)
-- Name: t_local_id_local_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.t_local_id_local_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t_local_id_local_seq OWNER TO postgres;

--
-- TOC entry 2198 (class 0 OID 0)
-- Dependencies: 187
-- Name: t_local_id_local_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.t_local_id_local_seq OWNED BY public.t_local.id_local;


--
-- TOC entry 194 (class 1259 OID 16461)
-- Name: t_pagocredito; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_pagocredito (
    id_pagoc integer NOT NULL,
    subtotal double precision NOT NULL,
    impuesto double precision NOT NULL,
    nomtarjeta character varying(50),
    numtarjeta character varying(50) NOT NULL,
    fechaexp date NOT NULL
);


ALTER TABLE public.t_pagocredito OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 16459)
-- Name: t_pagocredito_id_pagoc_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.t_pagocredito_id_pagoc_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t_pagocredito_id_pagoc_seq OWNER TO postgres;

--
-- TOC entry 2199 (class 0 OID 0)
-- Dependencies: 193
-- Name: t_pagocredito_id_pagoc_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.t_pagocredito_id_pagoc_seq OWNED BY public.t_pagocredito.id_pagoc;


--
-- TOC entry 196 (class 1259 OID 16469)
-- Name: t_pagoefectivo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_pagoefectivo (
    id_pagoc integer NOT NULL,
    subtotal double precision NOT NULL,
    impuesto double precision NOT NULL,
    cantidad double precision NOT NULL
);


ALTER TABLE public.t_pagoefectivo OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 16467)
-- Name: t_pagoefectivo_id_pagoc_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.t_pagoefectivo_id_pagoc_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t_pagoefectivo_id_pagoc_seq OWNER TO postgres;

--
-- TOC entry 2200 (class 0 OID 0)
-- Dependencies: 195
-- Name: t_pagoefectivo_id_pagoc_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.t_pagoefectivo_id_pagoc_seq OWNED BY public.t_pagoefectivo.id_pagoc;


--
-- TOC entry 182 (class 1259 OID 16396)
-- Name: t_usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_usuario (
    id_user integer NOT NULL,
    nombre character varying(50) NOT NULL,
    apellido character varying(50) NOT NULL,
    fecha_nacimiento date NOT NULL,
    telefono character varying(20) NOT NULL,
    direccion character varying(50) NOT NULL,
    correo character varying(50) NOT NULL,
    usuario character varying(50) NOT NULL,
    pass character varying(50) NOT NULL,
    tipo character varying(10) NOT NULL,
    super boolean,
    id_local integer
);


ALTER TABLE public.t_usuario OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16394)
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
-- TOC entry 2201 (class 0 OID 0)
-- Dependencies: 181
-- Name: t_usuario_id_user_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.t_usuario_id_user_seq OWNED BY public.t_usuario.id_user;


--
-- TOC entry 186 (class 1259 OID 16428)
-- Name: t_venta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_venta (
    id_venta integer NOT NULL,
    valor double precision NOT NULL,
    fecha date NOT NULL,
    id_cliente integer NOT NULL,
    id_usuario integer NOT NULL,
    id_articulo integer NOT NULL,
    "id_pagoE" integer,
    "id_pagoC" integer
);


ALTER TABLE public.t_venta OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16426)
-- Name: t_venta_id_venta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.t_venta_id_venta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t_venta_id_venta_seq OWNER TO postgres;

--
-- TOC entry 2202 (class 0 OID 0)
-- Dependencies: 185
-- Name: t_venta_id_venta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.t_venta_id_venta_seq OWNED BY public.t_venta.id_venta;


--
-- TOC entry 2024 (class 2604 OID 16407)
-- Name: id_art; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_articulo ALTER COLUMN id_art SET DEFAULT nextval('public.t_articulo_id_art_seq'::regclass);


--
-- TOC entry 2027 (class 2604 OID 16447)
-- Name: id_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_cliente ALTER COLUMN id_cliente SET DEFAULT nextval('public.t_cliente_id_cliente_seq'::regclass);


--
-- TOC entry 2028 (class 2604 OID 16455)
-- Name: id_cot; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_cotizacion ALTER COLUMN id_cot SET DEFAULT nextval('public.t_cotizacion_id_cot_seq'::regclass);


--
-- TOC entry 2026 (class 2604 OID 16439)
-- Name: id_local; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_local ALTER COLUMN id_local SET DEFAULT nextval('public.t_local_id_local_seq'::regclass);


--
-- TOC entry 2029 (class 2604 OID 16464)
-- Name: id_pagoc; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_pagocredito ALTER COLUMN id_pagoc SET DEFAULT nextval('public.t_pagocredito_id_pagoc_seq'::regclass);


--
-- TOC entry 2030 (class 2604 OID 16472)
-- Name: id_pagoc; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_pagoefectivo ALTER COLUMN id_pagoc SET DEFAULT nextval('public.t_pagoefectivo_id_pagoc_seq'::regclass);


--
-- TOC entry 2023 (class 2604 OID 16399)
-- Name: id_user; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_usuario ALTER COLUMN id_user SET DEFAULT nextval('public.t_usuario_id_user_seq'::regclass);


--
-- TOC entry 2025 (class 2604 OID 16431)
-- Name: id_venta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_venta ALTER COLUMN id_venta SET DEFAULT nextval('public.t_venta_id_venta_seq'::regclass);


--
-- TOC entry 2173 (class 0 OID 16404)
-- Dependencies: 184
-- Data for Name: t_articulo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_articulo (id_art, nombre, descripcion, categoria, stock, estado, precio, marca) FROM stdin;
\.


--
-- TOC entry 2203 (class 0 OID 0)
-- Dependencies: 183
-- Name: t_articulo_id_art_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.t_articulo_id_art_seq', 1, false);


--
-- TOC entry 2179 (class 0 OID 16444)
-- Dependencies: 190
-- Data for Name: t_cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_cliente (id_cliente, nombre, apellido, fecha_nacimiento, telefono, direccion, correo) FROM stdin;
\.


--
-- TOC entry 2204 (class 0 OID 0)
-- Dependencies: 189
-- Name: t_cliente_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.t_cliente_id_cliente_seq', 1, false);


--
-- TOC entry 2181 (class 0 OID 16452)
-- Dependencies: 192
-- Data for Name: t_cotizacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_cotizacion (id_cot, cantidad, valor, id_cliente, id_usuario, id_articulo) FROM stdin;
\.


--
-- TOC entry 2205 (class 0 OID 0)
-- Dependencies: 191
-- Name: t_cotizacion_id_cot_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.t_cotizacion_id_cot_seq', 1, false);


--
-- TOC entry 2177 (class 0 OID 16436)
-- Dependencies: 188
-- Data for Name: t_local; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_local (id_local, direccion, telefono, internet) FROM stdin;
1	Centro	0987654312	f
\.


--
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 187
-- Name: t_local_id_local_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.t_local_id_local_seq', 1, true);


--
-- TOC entry 2183 (class 0 OID 16461)
-- Dependencies: 194
-- Data for Name: t_pagocredito; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_pagocredito (id_pagoc, subtotal, impuesto, nomtarjeta, numtarjeta, fechaexp) FROM stdin;
\.


--
-- TOC entry 2207 (class 0 OID 0)
-- Dependencies: 193
-- Name: t_pagocredito_id_pagoc_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.t_pagocredito_id_pagoc_seq', 1, false);


--
-- TOC entry 2185 (class 0 OID 16469)
-- Dependencies: 196
-- Data for Name: t_pagoefectivo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_pagoefectivo (id_pagoc, subtotal, impuesto, cantidad) FROM stdin;
\.


--
-- TOC entry 2208 (class 0 OID 0)
-- Dependencies: 195
-- Name: t_pagoefectivo_id_pagoc_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.t_pagoefectivo_id_pagoc_seq', 1, false);


--
-- TOC entry 2171 (class 0 OID 16396)
-- Dependencies: 182
-- Data for Name: t_usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_usuario (id_user, nombre, apellido, fecha_nacimiento, telefono, direccion, correo, usuario, pass, tipo, super, id_local) FROM stdin;
1	Emilio	Moran	1997-06-04	0992008705	Norte	emilio@gmail.com	emilio97	emilio	v	f	1
\.


--
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 181
-- Name: t_usuario_id_user_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.t_usuario_id_user_seq', 1, true);


--
-- TOC entry 2175 (class 0 OID 16428)
-- Dependencies: 186
-- Data for Name: t_venta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_venta (id_venta, valor, fecha, id_cliente, id_usuario, id_articulo, "id_pagoE", "id_pagoC") FROM stdin;
\.


--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 185
-- Name: t_venta_id_venta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.t_venta_id_venta_seq', 1, false);


--
-- TOC entry 2034 (class 2606 OID 16409)
-- Name: t_articulo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_articulo
    ADD CONSTRAINT t_articulo_pkey PRIMARY KEY (id_art);


--
-- TOC entry 2040 (class 2606 OID 16449)
-- Name: t_cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_cliente
    ADD CONSTRAINT t_cliente_pkey PRIMARY KEY (id_cliente);


--
-- TOC entry 2042 (class 2606 OID 16457)
-- Name: t_cotizacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_cotizacion
    ADD CONSTRAINT t_cotizacion_pkey PRIMARY KEY (id_cot);


--
-- TOC entry 2038 (class 2606 OID 16441)
-- Name: t_local_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_local
    ADD CONSTRAINT t_local_pkey PRIMARY KEY (id_local);


--
-- TOC entry 2044 (class 2606 OID 16466)
-- Name: t_pagocredito_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_pagocredito
    ADD CONSTRAINT t_pagocredito_pkey PRIMARY KEY (id_pagoc);


--
-- TOC entry 2046 (class 2606 OID 16474)
-- Name: t_pagoefectivo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_pagoefectivo
    ADD CONSTRAINT t_pagoefectivo_pkey PRIMARY KEY (id_pagoc);


--
-- TOC entry 2032 (class 2606 OID 16401)
-- Name: t_usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_usuario
    ADD CONSTRAINT t_usuario_pkey PRIMARY KEY (id_user);


--
-- TOC entry 2036 (class 2606 OID 16433)
-- Name: t_venta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_venta
    ADD CONSTRAINT t_venta_pkey PRIMARY KEY (id_venta);


--
-- TOC entry 2055 (class 2606 OID 16490)
-- Name: id_articulo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_cotizacion
    ADD CONSTRAINT id_articulo FOREIGN KEY (id_articulo) REFERENCES public.t_articulo(id_art);


--
-- TOC entry 2050 (class 2606 OID 16505)
-- Name: id_articulo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_venta
    ADD CONSTRAINT id_articulo FOREIGN KEY (id_articulo) REFERENCES public.t_articulo(id_art);


--
-- TOC entry 2053 (class 2606 OID 16480)
-- Name: id_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_cotizacion
    ADD CONSTRAINT id_cliente FOREIGN KEY (id_cliente) REFERENCES public.t_cliente(id_cliente);


--
-- TOC entry 2049 (class 2606 OID 16500)
-- Name: id_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_venta
    ADD CONSTRAINT id_cliente FOREIGN KEY (id_cliente) REFERENCES public.t_cliente(id_cliente);


--
-- TOC entry 2047 (class 2606 OID 16475)
-- Name: id_local; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_usuario
    ADD CONSTRAINT id_local FOREIGN KEY (id_local) REFERENCES public.t_local(id_local);


--
-- TOC entry 2052 (class 2606 OID 16525)
-- Name: id_pagoC; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_venta
    ADD CONSTRAINT "id_pagoC" FOREIGN KEY ("id_pagoC") REFERENCES public.t_pagocredito(id_pagoc);


--
-- TOC entry 2051 (class 2606 OID 16520)
-- Name: id_pagoE; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_venta
    ADD CONSTRAINT "id_pagoE" FOREIGN KEY ("id_pagoE") REFERENCES public.t_pagoefectivo(id_pagoc);


--
-- TOC entry 2054 (class 2606 OID 16485)
-- Name: id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_cotizacion
    ADD CONSTRAINT id_usuario FOREIGN KEY (id_usuario) REFERENCES public.t_usuario(id_user);


--
-- TOC entry 2048 (class 2606 OID 16495)
-- Name: id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_venta
    ADD CONSTRAINT id_usuario FOREIGN KEY (id_usuario) REFERENCES public.t_usuario(id_user);


--
-- TOC entry 2193 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-08-18 01:14:08

--
-- PostgreSQL database dump complete
--

