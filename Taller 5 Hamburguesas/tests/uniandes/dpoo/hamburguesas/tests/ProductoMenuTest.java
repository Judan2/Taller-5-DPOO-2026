package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

class ProductoMenuTest {
	
	private ProductoMenu producto1;
	@BeforeEach
	void setUp() throws Exception {
		producto1 = new ProductoMenu("wrap de pollo", 15000);
		//ProductoAjustado pa = new ProductoAjustado(base);
		
	}
	/**
	@Test
	void testProductoMenu() {
	
	}
**/
	@Test
	void testGetNombre() {
		//System.out.println(producto1.getNombre());
		assertEquals(this.producto1.getNombre(),"wrap de pollo");
	}

	@Test
	void testGetPrecio() {
		//System.out.println(this.producto1.getPrecio());
		assertEquals(this.producto1.getPrecio(),15000);
	}
/**
	@Test
	void testToString() {
		fail("Not yet implemented");
	}
	**/

	@Test
	void testGenerarTextoFactura() {
		System.out.println(producto1.generarTextoFactura());
		String texto = this.producto1.generarTextoFactura();
		assertTrue(texto.contains("Nombre de Producto: "+this.producto1.getNombre()));
		assertTrue(texto.contains("Total a Pagar: "+this.producto1.getPrecio()));
		
	}

}
