import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Problema1Test {
	
	@Test
	void testEncomendaPAC() {
		Pedido p = new Pedido(new EncomendaPAC());
		
		p.addProduto(new Produto("Produto 1", 10, 600));
		assertEquals(10, p.calcularValorEntrega());
		
		p.addProduto(new Produto("Produto 2", 20, 900));
		assertEquals(15, p.calcularValorEntrega());
		
		p.addProduto(new Produto("Produto 3", 30, 700));
		assertEquals(20, p.calcularValorEntrega());
		
		p.addProduto(new Produto("Produto 4", 40, 2500));
		assertEquals(30, p.calcularValorEntrega());
		
		p.addProduto(new Produto("Produto 5", 50, 1300));
		assertEquals(-1, p.calcularValorEntrega());
	}
	
	@Test
	void testSedex() {
		Pedido p = new Pedido(new Sedex());
		
		p.addProduto(new Produto("Produto 1", 10, 300));
		assertEquals(12.5, p.calcularValorEntrega());
		
		p.addProduto(new Produto("Produto 2", 20, 350));
		assertEquals(20, p.calcularValorEntrega());
		
		p.addProduto(new Produto("Produto 3", 30, 400));
		assertEquals(30, p.calcularValorEntrega());
		
		p.addProduto(new Produto("Produto 4", 40, 850));
		assertEquals(45, p.calcularValorEntrega());
		
		p.addProduto(new Produto("Produto 5", 50, 2200));
		assertEquals(78, p.calcularValorEntrega());
	}
	
	@Test
	void testRetirada() {
		Pedido p = new Pedido(new Retirada());
		
		p.addProduto(new Produto("Produto 1", 10, 600));
		p.addProduto(new Produto("Produto 2", 20, 900));
		p.addProduto(new Produto("Produto 3", 30, 700));
		p.addProduto(new Produto("Produto 4", 40, 850));
		p.addProduto(new Produto("Produto 5", 50, 2200));
		
		assertEquals(0, p.calcularValorEntrega());
	}

}
