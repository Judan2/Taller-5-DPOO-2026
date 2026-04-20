package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.*;

class PedidoTest {
	private Pedido p1;
	private Pedido p2;
	@BeforeEach
	void setUp() throws Exception {
		//ArrayList<Producto> productos = new ArrayList<>();
		
		p1 = new Pedido("Juan", "diagonal 19 calle 18 #20-39");
		p2 = new Pedido("Sofia", "calle 17 #31-42");
		
		p1.agregarProducto(new ProductoMenu("corral", 14000));
	    p1.agregarProducto(new ProductoMenu("corral queso", 16000));
		
		
		
		//necesito acceder a la lista de pedidos o no ? 
	}

	/**
	@Test
	
	void testPedido() {
		
		fail("Not yet implemented");
	}**/
	//crear un arraylist
	// productos como lista de todos los pedidos
	
	
	
	
	
	@Test
	void testGetIdPedido() {
		// primero crear un pedido y luego pedirlo ;
		System.out.println(">>>" + p1.getIdPedido() + "<<<");
		System.out.println(">>>" + p2.getIdPedido() + "<<<");
		//assertTrue(p2.getIdPedido() > p1.getIdPedido());
		assertEquals(p1.getIdPedido() + 1, p2.getIdPedido());
	}

	@Test
	void testGetNombreCliente() {
		assertEquals("Juan",p1.getNombreCliente());
	}
	// tengo un arrayList donde estan todos los productos que quiero ahora ten
	//tengo que agregar a esta lista un producto pero si esta no esta en el constructor 
	//como la agrego 

	@Test
	void testAgregarProducto() {
		//que se me ocurre nada 
		assertTrue( p1.getPrecioTotalPedido() < p1.agregarProducto() );
		
		
		
	}

	@Test
	void testGetPrecioTotalPedido() {
		fail("Not yet implemented");
	}

	@Test
	void testGenerarTextoFactura() {
		fail("Not yet implemented");
	}

	@Test
	void testGuardarFactura() {
		fail("Not yet implemented");
	}

}
