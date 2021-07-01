--
-- TOC entry 3117 (class 0 OID 16419)
-- Dependencies: 204
-- Data for Name: catalog_tipos_usuario; Type: TABLE DATA; Schema: clientes; Owner: postgres
--

INSERT INTO clientes.catalog_tipos_usuario (id, estatus, fec_crea, descripcion, valor) VALUES (1, true, '2021-06-24 18:38:01.550122', 'Usuario afiliado', 'afiliado');
INSERT INTO clientes.catalog_tipos_usuario (id, estatus, fec_crea, descripcion, valor) VALUES (2, true, '2021-06-24 18:38:38.387034', 'Usuario empleado', 'empleado');


--
-- TOC entry 3119 (class 0 OID 16426)
-- Dependencies: 206
-- Data for Name: usuarios; Type: TABLE DATA; Schema: clientes; Owner: postgres
--

INSERT INTO clientes.usuarios (id, estatus, fec_crea, apellido_materno, apellido_paterno, email, nombre, cat_tipo_usuario_id) VALUES (1, true, '2020-06-24 19:06:02.911', 'Solis', 'García', 'lalogarciasolis@gmail.com', 'Eduardo', 1);
INSERT INTO clientes.usuarios (id, estatus, fec_crea, apellido_materno, apellido_paterno, email, nombre, cat_tipo_usuario_id) VALUES (11, true, '2021-06-26 15:30:09.061', 'García', 'Perez', 'juan@gmail.com', 'Juan', 2);
INSERT INTO clientes.usuarios (id, estatus, fec_crea, apellido_materno, apellido_paterno, email, nombre, cat_tipo_usuario_id) VALUES (13, true, '2021-06-27 10:50:34.306', 'García', 'Perez', 'jua1n@gmail.com', 'Juan', 2);
INSERT INTO clientes.usuarios (id, estatus, fec_crea, apellido_materno, apellido_paterno, email, nombre, cat_tipo_usuario_id) VALUES (18, true, '2021-06-27 11:02:02.293', 'García', 'Perez', 'juan1@gmail.com', 'Juan', 2);
INSERT INTO clientes.usuarios (id, estatus, fec_crea, apellido_materno, apellido_paterno, email, nombre, cat_tipo_usuario_id) VALUES (35, true, '2021-06-29 11:12:56.981', 'Obrador', 'Lopez', 'amlo@gmail.com', 'Andres Manuel', 2);
INSERT INTO clientes.usuarios (id, estatus, fec_crea, apellido_materno, apellido_paterno, email, nombre, cat_tipo_usuario_id) VALUES (37, true, '2021-06-30 15:03:50.131', 'García', 'Perez', 'juan5@gmail.com', 'Juan', 2);
INSERT INTO clientes.usuarios (id, estatus, fec_crea, apellido_materno, apellido_paterno, email, nombre, cat_tipo_usuario_id) VALUES (39, true, '2021-06-30 16:06:46.028', 'García', 'Perez', 'juan6@gmail.com', 'Juan', 2);
INSERT INTO clientes.usuarios (id, estatus, fec_crea, apellido_materno, apellido_paterno, email, nombre, cat_tipo_usuario_id) VALUES (40, true, '2021-06-30 16:57:55.296', 'García', 'Perez', 'juan621.0@gmail.com', 'Juan', 2);


--
-- TOC entry 3121 (class 0 OID 16443)
-- Dependencies: 208
-- Data for Name: catalog_tipo_acumulacion_descuento; Type: TABLE DATA; Schema: descuentos; Owner: postgres
--

INSERT INTO descuentos.catalog_tipo_acumulacion_descuento (id, estatus, fec_crea, descripcion, valor) VALUES (1, true, '2021-06-25 13:01:03.037888', 'Indica si un descuento es acumulable con los de su mismo Tipo Condicion Descuento', 'acumulable');
INSERT INTO descuentos.catalog_tipo_acumulacion_descuento (id, estatus, fec_crea, descripcion, valor) VALUES (2, true, '2021-06-25 13:03:21.048864', 'Indica si un descuento excluye a los demás se su Tipo Condicion Descuento', 'unico');


--
-- TOC entry 3135 (class 0 OID 16535)
-- Dependencies: 222
-- Data for Name: catalog_tipo_condicion_descuento_cantidad; Type: TABLE DATA; Schema: descuentos; Owner: postgres
--

INSERT INTO descuentos.catalog_tipo_condicion_descuento_cantidad (id, estatus, fec_crea, descripcion, valor) VALUES (1, true, '2021-06-25 14:29:10.905647', 'Indica que el criterio por el cual se debe aplicar el descuento es con base en el Total de la Compra', 'totalCompra');
INSERT INTO descuentos.catalog_tipo_condicion_descuento_cantidad (id, estatus, fec_crea, descripcion, valor) VALUES (2, true, '2021-06-25 14:30:02.156755', 'Indica que el criterio por el cual se debe aplicar el descuento es con base en una cantidad especifica alcanzada', 'cantidadAlcanzada');


--
-- TOC entry 3123 (class 0 OID 16450)
-- Dependencies: 210
-- Data for Name: catalog_tipo_condicion_descuento_usuario; Type: TABLE DATA; Schema: descuentos; Owner: postgres
--

INSERT INTO descuentos.catalog_tipo_condicion_descuento_usuario (id, estatus, fec_crea, descripcion, valor) VALUES (1, true, '2021-06-25 13:06:45.982855', 'Indica que el criterio de descuento va de acuerdo a la antigëdad del usuario', 'antiguedad');
INSERT INTO descuentos.catalog_tipo_condicion_descuento_usuario (id, estatus, fec_crea, descripcion, valor) VALUES (2, true, '2021-06-25 13:08:24.52049', 'Indica que el criterio de descuento va de acuerdo al Tipo de Usuario', 'tipoUsuario');
INSERT INTO descuentos.catalog_tipo_condicion_descuento_usuario (id, estatus, fec_crea, descripcion, valor) VALUES (3, true, '2021-06-25 13:08:24.52049', 'Indica que el criterio de descuento aplica cualquier usuario registrado', 'todos');


--
-- TOC entry 3125 (class 0 OID 16457)
-- Dependencies: 212
-- Data for Name: catalog_tipo_descuento; Type: TABLE DATA; Schema: descuentos; Owner: postgres
--

INSERT INTO descuentos.catalog_tipo_descuento (id, estatus, fec_crea, descripcion, valor) VALUES (1, true, '2021-06-25 13:13:27.544618', 'Indica si el descuento es por una cantidad neta', 'neto');
INSERT INTO descuentos.catalog_tipo_descuento (id, estatus, fec_crea, descripcion, valor) VALUES (2, true, '2021-06-25 13:13:56.129799', 'Indica si el descuento es por una cantidad porcentual', 'porcentual');


--
-- TOC entry 3127 (class 0 OID 16464)
-- Dependencies: 214
-- Data for Name: catalog_tipo_producto; Type: TABLE DATA; Schema: descuentos; Owner: postgres
--

INSERT INTO descuentos.catalog_tipo_producto (id, estatus, fec_crea, descripcion, valor) VALUES (1, true, '2021-06-25 13:17:51.380556', 'Categoría para los productos electronicos', 'electronico');
INSERT INTO descuentos.catalog_tipo_producto (id, estatus, fec_crea, descripcion, valor) VALUES (2, true, '2021-06-25 13:18:08.582841', 'Categoría para los productos comestibles', 'comestible');
INSERT INTO descuentos.catalog_tipo_producto (id, estatus, fec_crea, descripcion, valor) VALUES (3, true, '2021-06-25 13:20:28.267422', 'Categoría para los productos limpieza', 'limpieza');


--
-- TOC entry 3131 (class 0 OID 16478)
-- Dependencies: 218
-- Data for Name: descuentos; Type: TABLE DATA; Schema: descuentos; Owner: postgres
--

INSERT INTO descuentos.descuentos (id, estatus, fec_crea, valor_condicion, valor_descuento, cat_tipo_acumulacion_descuento_id, cat_tipo_descuento_id, cat_tipo_condicion_descuento_usuario_id, cat_tipo_condicion_descuento_cantidad_id) VALUES (1, true, '2021-06-25 13:39:28.488867', 'afiliado', '10', 2, 2, 2, 1);
INSERT INTO descuentos.descuentos (id, estatus, fec_crea, valor_condicion, valor_descuento, cat_tipo_acumulacion_descuento_id, cat_tipo_descuento_id, cat_tipo_condicion_descuento_usuario_id, cat_tipo_condicion_descuento_cantidad_id) VALUES (2, true, '2021-06-25 13:41:17.775459', 'empleado', '30', 2, 2, 2, 1);
INSERT INTO descuentos.descuentos (id, estatus, fec_crea, valor_condicion, valor_descuento, cat_tipo_acumulacion_descuento_id, cat_tipo_descuento_id, cat_tipo_condicion_descuento_usuario_id, cat_tipo_condicion_descuento_cantidad_id) VALUES (4, true, '2021-06-25 13:46:09.623088', '100', '5', 1, 1, 3, 2);
INSERT INTO descuentos.descuentos (id, estatus, fec_crea, valor_condicion, valor_descuento, cat_tipo_acumulacion_descuento_id, cat_tipo_descuento_id, cat_tipo_condicion_descuento_usuario_id, cat_tipo_condicion_descuento_cantidad_id) VALUES (3, true, '2021-06-25 13:43:40.829099', '24', '5', 2, 2, 1, 1);


--
-- TOC entry 3129 (class 0 OID 16471)
-- Dependencies: 216
-- Data for Name: descuento_por_tipo_producto; Type: TABLE DATA; Schema: descuentos; Owner: postgres
--

INSERT INTO descuentos.descuento_por_tipo_producto (id, estatus, fec_crea, descuento_id, cat_tipo_producto_id) VALUES (1, true, '2021-06-25 13:52:29.327344', 1, 1);
INSERT INTO descuentos.descuento_por_tipo_producto (id, estatus, fec_crea, descuento_id, cat_tipo_producto_id) VALUES (2, true, '2021-06-25 13:52:38.141458', 1, 3);
INSERT INTO descuentos.descuento_por_tipo_producto (id, estatus, fec_crea, descuento_id, cat_tipo_producto_id) VALUES (3, true, '2021-06-25 13:52:45.529286', 2, 3);
INSERT INTO descuentos.descuento_por_tipo_producto (id, estatus, fec_crea, descuento_id, cat_tipo_producto_id) VALUES (4, true, '2021-06-25 13:52:53.769679', 2, 1);
INSERT INTO descuentos.descuento_por_tipo_producto (id, estatus, fec_crea, descuento_id, cat_tipo_producto_id) VALUES (5, true, '2021-06-25 13:53:00.943342', 3, 1);
INSERT INTO descuentos.descuento_por_tipo_producto (id, estatus, fec_crea, descuento_id, cat_tipo_producto_id) VALUES (6, true, '2021-06-25 13:53:04.606751', 3, 3);


--
-- TOC entry 3133 (class 0 OID 16488)
-- Dependencies: 220
-- Data for Name: productos; Type: TABLE DATA; Schema: descuentos; Owner: postgres
--

INSERT INTO descuentos.productos (id, estatus, fec_crea, descripcion, valor, precio, cat_tipo_producto_id) VALUES (1, true, '2021-06-25 13:23:33.119499', 'Pantalla inteligente de 40 pulgadas marca LG', 'Pantalla 40 LG', 15000, 1);
INSERT INTO descuentos.productos (id, estatus, fec_crea, descripcion, valor, precio, cat_tipo_producto_id) VALUES (2, true, '2021-06-25 13:24:11.506611', 'Bocina Bose', 'Bocina Revolver Bose', 4000, 1);
INSERT INTO descuentos.productos (id, estatus, fec_crea, descripcion, valor, precio, cat_tipo_producto_id) VALUES (3, true, '2021-06-25 13:25:09.326235', '1kg Manzana', 'Kilo de manzana verde', 80.5, 2);
INSERT INTO descuentos.productos (id, estatus, fec_crea, descripcion, valor, precio, cat_tipo_producto_id) VALUES (4, true, '2021-06-25 13:25:39.111177', 'Piña mediana', 'Pieza de piña mediana', 50.6, 2);
INSERT INTO descuentos.productos (id, estatus, fec_crea, descripcion, valor, precio, cat_tipo_producto_id) VALUES (5, true, '2021-06-25 13:26:09.199761', 'Detergente Ariel', 'Galon de detergente para ropa Aril', 200, 3);
INSERT INTO descuentos.productos (id, estatus, fec_crea, descripcion, valor, precio, cat_tipo_producto_id) VALUES (6, true, '2021-06-25 13:27:45.57804', 'Suavizante Ensueño', 'Medio litro de Suavizante Ensueño', 350, 3);


--
-- TOC entry 3147 (class 0 OID 0)
-- Dependencies: 203
-- Name: catalog_tipos_usuario_id_seq; Type: SEQUENCE SET; Schema: clientes; Owner: postgres
--

SELECT pg_catalog.setval('clientes.catalog_tipos_usuario_id_seq', 3, true);


--
-- TOC entry 3148 (class 0 OID 0)
-- Dependencies: 205
-- Name: usuarios_id_seq; Type: SEQUENCE SET; Schema: clientes; Owner: postgres
--

SELECT pg_catalog.setval('clientes.usuarios_id_seq', 40, true);


--
-- TOC entry 3149 (class 0 OID 0)
-- Dependencies: 207
-- Name: catalog_tipo_acumulacion_descuento_id_seq; Type: SEQUENCE SET; Schema: descuentos; Owner: postgres
--

SELECT pg_catalog.setval('descuentos.catalog_tipo_acumulacion_descuento_id_seq', 2, true);


--
-- TOC entry 3150 (class 0 OID 0)
-- Dependencies: 221
-- Name: catalog_tipo_condicion_descuento_cantidad_id_seq; Type: SEQUENCE SET; Schema: descuentos; Owner: postgres
--

SELECT pg_catalog.setval('descuentos.catalog_tipo_condicion_descuento_cantidad_id_seq', 3, true);


--
-- TOC entry 3151 (class 0 OID 0)
-- Dependencies: 209
-- Name: catalog_tipo_condicion_descuento_id_seq; Type: SEQUENCE SET; Schema: descuentos; Owner: postgres
--

SELECT pg_catalog.setval('descuentos.catalog_tipo_condicion_descuento_id_seq', 4, true);


--
-- TOC entry 3152 (class 0 OID 0)
-- Dependencies: 211
-- Name: catalog_tipo_descuento_id_seq; Type: SEQUENCE SET; Schema: descuentos; Owner: postgres
--

SELECT pg_catalog.setval('descuentos.catalog_tipo_descuento_id_seq', 2, true);


--
-- TOC entry 3153 (class 0 OID 0)
-- Dependencies: 213
-- Name: catalog_tipo_producto_id_seq; Type: SEQUENCE SET; Schema: descuentos; Owner: postgres
--

SELECT pg_catalog.setval('descuentos.catalog_tipo_producto_id_seq', 3, true);


--
-- TOC entry 3154 (class 0 OID 0)
-- Dependencies: 215
-- Name: descuento_por_tipo_producto_id_seq; Type: SEQUENCE SET; Schema: descuentos; Owner: postgres
--

SELECT pg_catalog.setval('descuentos.descuento_por_tipo_producto_id_seq', 11, true);


--
-- TOC entry 3155 (class 0 OID 0)
-- Dependencies: 217
-- Name: descuentos_id_seq; Type: SEQUENCE SET; Schema: descuentos; Owner: postgres
--

SELECT pg_catalog.setval('descuentos.descuentos_id_seq', 10, true);


--
-- TOC entry 3156 (class 0 OID 0)
-- Dependencies: 219
-- Name: productos_id_seq; Type: SEQUENCE SET; Schema: descuentos; Owner: postgres
--

SELECT pg_catalog.setval('descuentos.productos_id_seq', 6, true);


--
-- TOC entry 3157 (class 0 OID 0)
-- Dependencies: 223
-- Name: descuentos_por_factura_id_seq; Type: SEQUENCE SET; Schema: facturas; Owner: postgres
--

SELECT pg_catalog.setval('facturas.descuentos_por_factura_id_seq', 2, true);


--
-- TOC entry 3158 (class 0 OID 0)
-- Dependencies: 225
-- Name: facturas_id_seq; Type: SEQUENCE SET; Schema: facturas; Owner: postgres
--

SELECT pg_catalog.setval('facturas.facturas_id_seq', 1, true);


--
-- TOC entry 3159 (class 0 OID 0)
-- Dependencies: 227
-- Name: productos_carrito_id_seq; Type: SEQUENCE SET; Schema: facturas; Owner: postgres
--

SELECT pg_catalog.setval('facturas.productos_carrito_id_seq', 2, true);


-- Completed on 2021-06-30 21:44:04

--
-- PostgreSQL database dump complete
--

