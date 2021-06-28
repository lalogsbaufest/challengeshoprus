package com.shoprus.microservicios.facturas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import com.shoprus.microservicios.commons.controllers.dtos.ArticuloCarritoDTO;
import com.shoprus.microservicios.commons.controllers.dtos.SolicitudCompraDTO;
import com.shoprus.microservicios.facturas.controllers.FacturaController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FacturasApplicationTests {

	@Autowired
	private FacturaController controller;

	@Test
	void testDescuentoCarrito() {

		SolicitudCompraDTO solicitud = new SolicitudCompraDTO();

		solicitud.setIdCliente(10l);

		List<ArticuloCarritoDTO> carrito = new ArrayList<>();

		carrito.add(new ArticuloCarritoDTO(1l, 2, null));
		carrito.add(new ArticuloCarritoDTO(10l, 2, null));

		solicitud.setCarrito(carrito);

		assertThat(
			controller.crear(solicitud)
		).isNotNull();
	}

}
