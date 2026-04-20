package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.*;


class ProductoAjustadoTest {
	//primero necesitaria hacer dos arrayList
	private ProductoAjustado producto1; 
	private ProductoAjustado producto2;

	@BeforeEach
	void setUp() throws Exception {
		//que clase creo primero 
		ProductoMenu proMenu1 = new ProductoMenu("corral",14000);
		ProductoMenu proMenu2 = new ProductoMenu("corral pollo", 15000);
		producto1 = new ProductoAjustado(proMenu1);
		producto2 = new ProductoAjustado(proMenu2);
		System.out.println(">>>"+ producto2.getNombre()+"<<<");
	}
	/**
	@Test
	void testProductoAjustado() {
		fail("Not yet implemented");
	}**/

	@Test
	void testGetNombre() {
		
		assertEquals("corral pollo",producto2.getNombre() );
	}

	@Test
	void testGetPrecio() {
		System.out.println(producto2.getPrecio());
		
		assertEquals(15000,producto2.getPrecio());
		
	}

	@Test
	void testGenerarTextoFactura() {
		fail("Not yet implemented");
	}

}
