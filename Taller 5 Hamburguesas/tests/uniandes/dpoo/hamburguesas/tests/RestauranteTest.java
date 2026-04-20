package uniandes.dpoo.hamburguesas.tests;


import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import uniandes.dpoo.hamburguesas.excepciones.IngredienteRepetidoException;
import uniandes.dpoo.hamburguesas.excepciones.ProductoRepetidoException;
import uniandes.dpoo.hamburguesas.excepciones.ProductoFaltanteException;

import uniandes.dpoo.hamburguesas.excepciones.IngredienteRepetidoException;
import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.*;
class RestauranteTest {
	private Restaurante restaurante;

	@BeforeEach
	void setUp() throws Exception {
		restaurante = new Restaurante();
	    restaurante.cargarInformacionRestaurante(
	        new File("data/ingredientes.txt"),
	        new File("data/menu.txt"),
	        new File("data/combos.txt"));
	}
/**
	@throws YaHayUnPedidoEnCursoException 
 * @Test
	void testRestaurante() {
		fail("Not yet implemented");
	}**/

	@Test
	void testIniciarPedido() throws YaHayUnPedidoEnCursoException {//recordar que no retorna nada 
		this.restaurante.iniciarPedido("Andrea Guitierrez", "Calle 18 #34-40");
		
		assertNotNull(restaurante.getPedidoEnCurso());
		//System.out.println(restaurante.getPedidoEnCurso().getNombreCliente());
		assertEquals("Andrea Guitierrez",restaurante.getPedidoEnCurso().getNombreCliente());
		assertEquals("Calle 18 #34-40",restaurante.getPedidoEnCurso().getDireccionCliente());
	}

	@Test
	void testCerrarYGuardarPedido() throws Exception {
		//que tengo que hacer aca 
		//que laberinto 
		//primero crearlo 
		//System.out.println(restaurante.getPedidoEnCurso());
		this.restaurante.iniciarPedido("Judan Doss", "Desconocido");
		//System.out.println(restaurante.getPedidoEnCurso());
		this.restaurante.cerrarYGuardarPedido();
		//System.out.println(restaurante.getPedidoEnCurso());
		assertNull(this.restaurante.getPedidoEnCurso());
		
	}

	@Test
	void testGetPedidoEnCurso() throws Exception{
		this.restaurante.iniciarPedido("Andrea Guitierrez", "Calle 18 #34-40");
		assertEquals( 0 , restaurante.getPedidos().size());
	}

	@Test
	void testGetPedidos() throws Exception{
		this.restaurante.iniciarPedido("Juan", "Calle 19 #26-15");
		//this.restaurante.iniciarPedido("Andrea Guitierrez", "Calle 18 #34-40");
		restaurante.cerrarYGuardarPedido();
		assertEquals(1, restaurante.getPedidos().size());
		this.restaurante.iniciarPedido("Andrea Guitierrez", "Calle 18 #34-40");
		restaurante.cerrarYGuardarPedido();
		assertEquals(2, restaurante.getPedidos().size());
	}

	@Test
	void testGetMenuBase() throws Exception{
		//System.out.println(restaurante.getMenuBase().size());
		assertEquals(this.restaurante.getMenuBase().size(),22);
		assertNotNull(this.restaurante.getMenuBase());
	}

	@Test
	void testGetMenuCombos() {
		//System.out.println(this.restaurante.getMenuCombos());
		this.restaurante.getMenuCombos();
		assertNotNull(restaurante.getMenuCombos());
		assertEquals(4,this.restaurante.getMenuCombos().size());
	}

	@Test
	void testGetIngredientes() {
		//System.out.println(this.restaurante.getIngredientes().size());
		assertNotNull(this.restaurante.getIngredientes());
		assertEquals(15,this.restaurante.getIngredientes().size());
		
	}

	@Test
	void testCargarInformacionRestaurante() {
		assertFalse(restaurante.getIngredientes().isEmpty());
		assertFalse(restaurante.getMenuBase().isEmpty());
		assertFalse(restaurante.getMenuCombos().isEmpty());
		//verificar que las listas no estes vacias
		
	}
	//excepciones
	@Test
	void testIniciarPedidoExcepcion() throws Exception {
	    restaurante.iniciarPedido("Andrea", "Calle 1");
	    assertThrows(YaHayUnPedidoEnCursoException.class, () -> {
	        restaurante.iniciarPedido("Juan", "Calle 2");
	    });
	}
	@Test
	void testCerrarSinPedidoExcepcion() {
	    assertThrows(NoHayPedidoEnCursoException.class, () -> {
	        restaurante.cerrarYGuardarPedido();
	    });
	}
	@Test
	void testIngredienteRepetidoException() {
		Restaurante nuevoRestaurante = new Restaurante();
	    assertThrows(IngredienteRepetidoException.class, () -> {
	    	nuevoRestaurante.cargarInformacionRestaurante(
	            new File("data/ingredientesRepetidos.txt"),
	            new File("data/menu.txt"),
	            new File("data/combos.txt") );
	    });
	}

	@Test
	void testProductoRepetidoException() {
	    assertThrows(ProductoRepetidoException.class, () -> {
	        restaurante.cargarInformacionRestaurante(
	            new File("data/ingredientes.txt"),
	            new File("data/menuRepetido.txt"),
	            new File("data/combos.txt")
	        );
	    });
	}

	@Test
	void testProductoFaltanteException() {
	    assertThrows(ProductoFaltanteException.class, () -> {
	        restaurante.cargarInformacionRestaurante(
	            new File("data/ingredientes.txt"),
	            new File("data/menuFaltante.txt"),
	            new File("data/combosConProductoFaltante.txt")
	        );
	    });
	}

}
