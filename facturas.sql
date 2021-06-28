\connect db_microservicios_facturas

--
-- TOC entry 3008 (class 0 OID 16563)
-- Dependencies: 204
-- Data for Name: facturas; Type: TABLE DATA; Schema: facturas; Owner: postgres
--

INSERT INTO facturas.facturas (id, estatus, fec_crea, id_usuario, total_descuento, total_sin_descuento) VALUES (1, true, '2021-06-28 02:21:43.697', 1, 4055, 27101.2);
INSERT INTO facturas.facturas (id, estatus, fec_crea, id_usuario, total_descuento, total_sin_descuento) VALUES (2, true, '2021-06-28 02:24:39.901', 1, 4055, 27101.2);
INSERT INTO facturas.facturas (id, estatus, fec_crea, id_usuario, total_descuento, total_sin_descuento) VALUES (3, true, '2021-06-28 03:24:08.429', 1, 4055, 27101.2);
INSERT INTO facturas.facturas (id, estatus, fec_crea, id_usuario, total_descuento, total_sin_descuento) VALUES (4, true, '2021-06-28 03:44:04.946', 1, 4055, 27101.2);


--
-- TOC entry 3006 (class 0 OID 16556)
-- Dependencies: 202
-- Data for Name: descuentos_por_factura; Type: TABLE DATA; Schema: facturas; Owner: postgres
--

INSERT INTO facturas.descuentos_por_factura (id, estatus, fec_crea, descuento_id, factura_id) VALUES (1, true, '2021-06-28 02:24:39.912', 4, 2);
INSERT INTO facturas.descuentos_por_factura (id, estatus, fec_crea, descuento_id, factura_id) VALUES (2, true, '2021-06-28 02:24:39.915', 1, 2);
INSERT INTO facturas.descuentos_por_factura (id, estatus, fec_crea, descuento_id, factura_id) VALUES (3, true, '2021-06-28 03:24:08.514', 4, 3);
INSERT INTO facturas.descuentos_por_factura (id, estatus, fec_crea, descuento_id, factura_id) VALUES (4, true, '2021-06-28 03:24:08.518', 1, 3);
INSERT INTO facturas.descuentos_por_factura (id, estatus, fec_crea, descuento_id, factura_id) VALUES (5, true, '2021-06-28 03:44:05.022', 4, 4);
INSERT INTO facturas.descuentos_por_factura (id, estatus, fec_crea, descuento_id, factura_id) VALUES (6, true, '2021-06-28 03:44:05.025', 1, 4);


--
-- TOC entry 3010 (class 0 OID 16570)
-- Dependencies: 206
-- Data for Name: productos_carrito; Type: TABLE DATA; Schema: facturas; Owner: postgres
--

INSERT INTO facturas.productos_carrito (id, estatus, fec_crea, cantidad, producto_id, factura_id) VALUES (1, true, '2021-06-28 02:24:39.934', 1, 1, 2);
INSERT INTO facturas.productos_carrito (id, estatus, fec_crea, cantidad, producto_id, factura_id) VALUES (2, true, '2021-06-28 02:24:39.937', 3, 2, 2);
INSERT INTO facturas.productos_carrito (id, estatus, fec_crea, cantidad, producto_id, factura_id) VALUES (3, true, '2021-06-28 02:24:39.939', 2, 4, 2);
INSERT INTO facturas.productos_carrito (id, estatus, fec_crea, cantidad, producto_id, factura_id) VALUES (4, true, '2021-06-28 03:24:08.568', 1, 1, 3);
INSERT INTO facturas.productos_carrito (id, estatus, fec_crea, cantidad, producto_id, factura_id) VALUES (5, true, '2021-06-28 03:24:08.571', 3, 2, 3);
INSERT INTO facturas.productos_carrito (id, estatus, fec_crea, cantidad, producto_id, factura_id) VALUES (6, true, '2021-06-28 03:24:08.574', 2, 4, 3);
INSERT INTO facturas.productos_carrito (id, estatus, fec_crea, cantidad, producto_id, factura_id) VALUES (7, true, '2021-06-28 03:44:05.054', 1, 1, 4);
INSERT INTO facturas.productos_carrito (id, estatus, fec_crea, cantidad, producto_id, factura_id) VALUES (8, true, '2021-06-28 03:44:05.058', 3, 2, 4);
INSERT INTO facturas.productos_carrito (id, estatus, fec_crea, cantidad, producto_id, factura_id) VALUES (9, true, '2021-06-28 03:44:05.059', 2, 4, 4);


--
-- TOC entry 3017 (class 0 OID 0)
-- Dependencies: 201
-- Name: descuentos_por_factura_id_seq; Type: SEQUENCE SET; Schema: facturas; Owner: postgres
--

SELECT pg_catalog.setval('facturas.descuentos_por_factura_id_seq', 6, true);


--
-- TOC entry 3018 (class 0 OID 0)
-- Dependencies: 203
-- Name: facturas_id_seq; Type: SEQUENCE SET; Schema: facturas; Owner: postgres
--

SELECT pg_catalog.setval('facturas.facturas_id_seq', 4, true);


--
-- TOC entry 3019 (class 0 OID 0)
-- Dependencies: 205
-- Name: productos_carrito_id_seq; Type: SEQUENCE SET; Schema: facturas; Owner: postgres
--

SELECT pg_catalog.setval('facturas.productos_carrito_id_seq', 9, true);


-- Completed on 2021-06-28 05:33:06

--
-- PostgreSQL database dump complete
--

