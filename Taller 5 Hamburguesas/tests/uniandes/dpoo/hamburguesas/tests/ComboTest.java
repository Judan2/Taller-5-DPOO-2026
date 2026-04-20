package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.AbstractList;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.*;

class ComboTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	//las variables no se comparten entre los metodos por esto tiene que estar dentro del metodo 
	// el arraylist 
	
/**
	@Test
	void testCombo() {
		fail("Not yet implemented");
	}**/
	
	@Test
	void testGetNombre() {
		// cree un instancia de producto menu y producto para poder instanciar combo
		
		ArrayList<ProductoMenu> producto = new ArrayList<>();
		ProductoMenu p1 = new ProductoMenu("corral", 14000); 
		ProductoMenu p2 = new ProductoMenu("corral queso", 16000);
		producto.add(p1);
		producto.add(p2);
		
		
		Combo combo = new Combo("combo corral",0.1,producto);
		assertEquals("combo corral", combo.getNombre());
	}

	@Test
	void testGetPrecio() {
		ArrayList<ProductoMenu> producto = new ArrayList<>();
		ProductoMenu p1 = new ProductoMenu("corral", 14000); 
		ProductoMenu p2 = new ProductoMenu("corral queso", 16000);
		producto.add(p1);
		producto.add(p2);
		
		
		Combo combo = new Combo("combo corral",0.1,producto);
		assertEquals(27000, combo.getPrecio());
		
		
	}

	@Test
	void testGenerarTextoFactura() {
		//fail("Not yet implemented");
		
		//combo corral;10%;corral;papas medianas;gaseosa
		//corral;
		//gaseosa;5000
		//papas medianas;5500
		//corral;14000
		
		ArrayList<ProductoMenu> producto = new ArrayList<>();
		ProductoMenu p1 = new ProductoMenu("corral",14000); 
		ProductoMenu p2 = new ProductoMenu("gaseosa",5000 );
		ProductoMenu p3 = new ProductoMenu("papas medianas",5500);
		
 		producto.add(p1);
		producto.add(p2);
		producto.add(p3);
		
		
		Combo combo = new Combo("corral",0.1,producto);
		String texto = combo.generarTextoFactura();
		System.out.println(">>>" + texto + "<<<");
		assertTrue(texto.contains("Combo corral"));
		assertTrue(texto.contains("Descuento: 0.1"));
		assertTrue(texto.contains("Precio Final: 22050"));
		
		
		
	}

}
