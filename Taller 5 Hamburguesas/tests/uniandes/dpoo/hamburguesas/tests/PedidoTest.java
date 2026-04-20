package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
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
	    
	    p2.agregarProducto(new ProductoMenu("especial",24000));
		
		
		
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
		//System.out.println(">>>" + p1.getIdPedido() + "<<<");
		//System.out.println(">>>" + p2.getIdPedido() + "<<<");
		//assertTrue(p2.getIdPedido() > p1.getIdPedido());
		assertEquals(p1.getIdPedido() + 1, p2.getIdPedido());
	}

	@Test
	void testGetNombreCliente() {
		
		//System.out.println(">>>>"+ p1.getPrecioTotalPedido()+ "<<<<<");
		//System.out.println(">>>>"+p2.getPrecioTotalPedido()+"<<<<");
		assertEquals("Juan",p1.getNombreCliente());
	}
	// tengo un arrayList donde estan todos los productos que quiero ahora ten
	//tengo que agregar a esta lista un producto pero si esta no esta en el constructor 
	//como la agrego 

	@Test
	void testAgregarProducto() {
		//testear si la funicion agregar producto funciona como viendo la lacntidad de 
		
		
		
		Pedido p3 = new Pedido("Juan", "diagonal 19 calle 18 #20-39");
		Pedido p4 = new Pedido("Sofia", "calle 17 #31-42");
		
		p3.agregarProducto(new ProductoMenu("especial",24000));
	    p3.agregarProducto(new ProductoMenu("costeña",20000));
	    
	    p4.agregarProducto(new ProductoMenu("especial",24000));
		p4.agregarProducto(new ProductoMenu("costeña",20000));
		p4.agregarProducto(new ProductoMenu("gaseosa",5000));
		//si agrega producto adicional si este se agrega corretamente es porque 
		//es mayor  al anterior 
		//System.out.println(">>>>"+ p3.getPrecioTotalPedido()+"<<<<");
		//System.out.println(">>>>"+p4.getPrecioTotalPedido()+"<<<<");
		
		assertTrue( p3.getPrecioTotalPedido() < p4.getPrecioTotalPedido() );
		//verificar valore exactos 
		assertEquals((int) ((24000+20000)*1.19),p3.getPrecioTotalPedido());
		assertEquals((int) (24000+20000+5000)*1.19,p4.getPrecioTotalPedido());
		
		
		
	}

	@Test
	void testGetPrecioTotalPedido() {
		
		assertEquals((int) (24000*1.19),p2.getPrecioTotalPedido());
	}

	@Test
	void testGenerarTextoFactura() {
		
		String texto = p1.generarTextoFactura();
		System.out.println(">>>>"+ texto +"<<<<");
		assertTrue(texto.contains("Cliente: Juan"));
		assertTrue(texto.contains("Dirección: diagonal 19 calle 18 #20-39"));
		assertTrue(texto.contains("----------------"));
		assertTrue(texto.contains("corral"));
		assertTrue(texto.contains("Total a Pagar: 14000"));
		assertTrue(texto.contains("corral queso"));
		assertTrue(texto.contains("Total a Pagar: 16000"));
		assertTrue(texto.contains("----------------"));
		assertTrue(texto.contains("Precio Neto:  30000"));
		assertTrue(texto.contains("IVA:          5700"));
		assertTrue(texto.contains("Precio Total: 35700"));
		
	}

	@Test
	void testGuardarFactura() throws FileNotFoundException  {
		File archivo = new File("data/faturaTest.txt");// creo archivo temporal
		p1.guardarFactura(archivo);
		//System.out.println(">>>>" + p1.guardarFactura(archivo)  +"<<<<");
		assertTrue(archivo.exists());
	    assertTrue(archivo.length() > 0);
	    
	    archivo.delete();
	}

}
