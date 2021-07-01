package com.shoprus.microservicios.descuentos;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.shoprus.microservicios.clientes.controllers.DescuentoController;
import com.shoprus.microservicios.commons.controllers.dtos.ArticuloCarritoDTO;
import com.shoprus.microservicios.commons.controllers.dtos.DescuentoDTO;
import com.shoprus.microservicios.commons.controllers.dtos.SolicitudCompraDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DescuentosApplicationTests {

	@Autowired
	private DescuentoController controller;

	@Test
	void testListarTodosLosDescuentos() {
		assertThat(
			controller.listar()
		).isNotNull();
	}

	@Test
	void testDescuentosPorProductoService() {

		Long idProductoExistente = 1l;
		
		Long idClienteExistente = 1l;

		Long idProductoNoExistente = 99l;

		Long idClienteNoExistente = 99l;

		assertThat(
			controller.descuentosPorProducto(idProductoExistente, idClienteExistente)
		).isNotNull();
	}

	@Test
	void testDescuentoCarrito() {

		SolicitudCompraDTO solicitud = new SolicitudCompraDTO();

		solicitud.setIdCliente(10l);

		List<ArticuloCarritoDTO> carrito = new ArrayList<>();

		carrito.add(new ArticuloCarritoDTO(1l, 2, null));
		carrito.add(new ArticuloCarritoDTO(10l, 2, null));

		solicitud.setCarrito(carrito);

		assertThat(
			controller.descuentosCarrito(solicitud)
		).isNotNull();
	}

	@Test
	void testCrearDescuento() {

		//Descuento que reducirá 10 dolares por cada 500 alcanzados
		DescuentoDTO descuentoDTO = new DescuentoDTO();
		descuentoDTO.setValorCondicion("500");
		descuentoDTO.setValorDescuento("10");
		
		/*
			Para los productos electronicos
			1.- Electronicos
			2.- Comestibles
			3.- Limpieza
		*/
		Long idTipoProductoElectronicos = 1l;
		descuentoDTO.setIdsProductosQueAplica(
			new ArrayList<>( Arrays.asList(
				new Long[] {idTipoProductoElectronicos}
				)
			)
		);

		/*
			Sera un descuento Acumulable con otros
			1.- Acumulable
			2.- Único
		*/
		descuentoDTO.setTipoAcumulacionDescuentoId(1l);

		/*
			Sera un descuento por cada vez que se alcance 500 dolares
			1.- Total de la compra
			2.- Cantidad alcanzada (Ejemplo cada 100 dolares)
		*/
		descuentoDTO.setTipoCondicionDescuentoCantidadId(2l);

		/*
			Tipo de usuario
			1.- Afiliado
			2.- Empleado
			3.- Todos
		*/
		descuentoDTO.setTipoCondicionDescuentoUsuarioId(2l);

		/*
			Tipo de usuario
			1.- Valor Condición será Neta
			2.- Valor Condición será Porcentual
		*/
		descuentoDTO.setTipoDescuentoId(2l);

		assertThat(
			controller.crear(descuentoDTO)
		).isNotNull();
	}

}
