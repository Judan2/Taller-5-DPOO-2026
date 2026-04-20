package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.*;


class ProductoAjustadoTest {
	//primero necesitaria hacer dos arrayList
	private ProductoAjustado producto1; 
	private ProductoAjustado producto2;
	
	
	private ArrayList<Ingrediente> listaingredientes;

	@BeforeEach
	void setUp() throws Exception {
		//que clase creo primero 
		ProductoMenu proMenu1 = new ProductoMenu("corral",14000);
		ProductoMenu proMenu2 = new ProductoMenu("corral pollo", 15000);
		producto1 = new ProductoAjustado(proMenu1);
		producto2 = new ProductoAjustado(proMenu2);
		//----------------------------------------------------------------------
		this.listaingredientes= new ArrayList<>();
		Ingrediente ingre1 = new Ingrediente("lechuga",5000);
		Ingrediente ingre2 = new Ingrediente("salsa tomate",2000);
		Ingrediente ingre3 = new Ingrediente("cebolla",3000);
		this.listaingredientes.add(ingre1);
		this.listaingredientes.add(ingre2);
		this.listaingredientes.add(ingre3);
		//System.out.println(">>>" + this.listaingredientes);
		//System.out.println(">>>"+ producto2.getNombre()+"<<<");
		
		//agregados.add("todoterreno");
		
	}
	/**
	@Test
	void testProductoAjustado() {
		fail("Not yet implemented");
	}**/

	@Test
	void testGetNombre() {
		System.out.println(">>>"+producto1.getNombre());
		
		
		assertEquals("corral",producto1.getNombre() );
	}

	@Test
	void testGetPrecio() {
		// primero hacer una lista de elementos agregados y luego 
		//ArrayList<Ingrediente> this.listaingredientes;
		
		Ingrediente ingre1 = new Ingrediente("lechuga",5000);
		Ingrediente ingre2 = new Ingrediente("salsa tomate",2000);
		Ingrediente ingre3 = new Ingrediente("cebolla",3000);
		this.listaingredientes.add(ingre1);
		this.listaingredientes.add(ingre2);
		this.listaingredientes.add(ingre3);
		//System.out.println(">>>" + this.listaingredientes);
		
		//System.out.println(">>>"+producto2.getPrecio());
		assertEquals( 15000,producto2.getPrecio());
		
	}

	@Test
	void testGenerarTextoFactura() {
		
		ProductoMenu base = new ProductoMenu("Hamburguesa Clásica", 15000);
	    ProductoAjustado pa = new ProductoAjustado(base);
	    
	    pa.agregarIngrediente(new Ingrediente("Queso", 500));
	    pa.agregarIngrediente(new Ingrediente("Tomate", 300));
	    pa.eliminarIngrediente(new Ingrediente("Cebolla", 0));
	    
	    System.out.println(pa.generarTextoFactura());
		String texto = pa.generarTextoFactura();
		assertTrue(texto.contains("Hamburguesa Clásica: $15000"));
		assertTrue(texto.contains(" + Queso: $500"));
		assertTrue(texto.contains(" - Cebolla"));
		assertTrue(texto.contains("El precio Total a Pagar: $15800"));
	}

}
