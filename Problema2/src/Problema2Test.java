import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Problema2Test {

	@Test
	void testCompraEVenda() {
		Acao a1 = new Acao("Banco do Brasil", 0);
		
		Investidor i1 = new Investidor("Mariana");
		i1.registrarOrdem(a1, "Venda", 24);
		
		Investidor i2 = new Investidor("Joaquim");
		i2.registrarOrdem(a1, "Compra", 24);
		
		assertEquals(24, a1.getValor());
		
		assertEquals("", a1.exibirOrdens());
		
		i1.registrarOrdem(a1, "Compra", 24);
		
		i2.registrarOrdem(a1, "Venda", 24);
		
		assertEquals(24, a1.getValor());
		
		assertEquals("", a1.exibirOrdens());
	}
	
	@Test
	void testNotificacao() {
		Acao a1 = new Acao("Banco do Brasil", 0);
		
		Investidor i1 = new Investidor("Mariana");
		Investidor i2 = new Investidor("Joaquim");
		Investidor i3 = new Investidor("Thiago");
		
		i3.registrarEmAcao(a1);
		i1.registrarOrdem(a1, "Venda", 24);
		i2.registrarOrdem(a1, "Compra", 24);
		
		String n1 = "Notificação para: " + i3.getNome() + "\nO valor da ação " + a1.getNome() + " alterou!\nNovo valor da ação: R$ " + 
					String.format("%.2f", a1.getValor());
		
		assertEquals(n1, i3.verUltimaNotificacao());
		
		i3.registrarEmAcao(a1);
		i1.registrarOrdem(a1, "Compra", 24);
		i2.registrarOrdem(a1, "Venda", 24);
		
		assertEquals(n1, i3.verUltimaNotificacao());
		
		Acao a2 = new Acao("Bradesco", 0);
		
		i1.registrarOrdem(a2, "Compra", 30);
		i3.registrarEmAcao(a2);
		i2.registrarOrdem(a2, "Venda", 30);
		
		String n2 = "Notificação para: " + i3.getNome() + "\nO valor da ação " + a2.getNome() + " alterou!\nNovo valor da ação: R$ " + 
				String.format("%.2f", a2.getValor());
		
		assertEquals(n2, i3.verUltimaNotificacao());
		
		i1.registrarOrdem(a2, "Venda", 30);
		i3.registrarEmAcao(a2);
		i2.registrarOrdem(a2, "Compra", 30);
		
		assertEquals(n2, i3.verUltimaNotificacao());
	}
	
	@Test
	void testNotificacoes() {
		Acao a1 = new Acao("Banco do Brasil", 0);
		
		Investidor i1 = new Investidor("Mariana");
		Investidor i2 = new Investidor("Joaquim");
		Investidor i3 = new Investidor("Thiago");
		
		i3.registrarEmAcao(a1);
		i1.registrarOrdem(a1, "Venda", 24);
		i2.registrarOrdem(a1, "Compra", 24);
		
		String n1 = "Notificação para: " + i3.getNome() + "\nO valor da ação " + a1.getNome() + " alterou!\nNovo valor da ação: R$ " + 
				String.format("%.2f", a1.getValor());
		
		Acao a2 = new Acao("Bradesco", 0);
		
		i1.registrarOrdem(a2, "Compra", 30);
		i3.registrarEmAcao(a2);
		i2.registrarOrdem(a2, "Venda", 30);
		
		String n2 = "Notificação para: " + i3.getNome() + "\nO valor da ação " + a2.getNome() + " alterou!\nNovo valor da ação: R$ " + 
				String.format("%.2f", a2.getValor());
		
		assertEquals((n1 + "\n" + n2), i3.verNotificacoes());
	}

	@Test
	void testPreOrdens() {
		Acao a1 = new Acao("Banco do Brasil", 0);
		
		Investidor i1 = new Investidor("Mariana");
		Investidor i2 = new Investidor("Joaquim");
		Investidor i3 = new Investidor("Thiago");
		Investidor i4 = new Investidor("André");
		
		i3.registrarPreOrdem(a1, "Venda", 25.5, 24);
		
		assertEquals("", a1.exibirOrdens());
		
		i1.registrarOrdem(a1, "Venda", 24);
		assertEquals("Investidor associado: " + i1.getNome() + " - Tipo ordem: Venda - Valor: R$ 24,00", a1.exibirOrdens());
		
		i2.registrarOrdem(a1, "Compra", 24);
		
		assertEquals("Investidor associado: " + i3.getNome() + " - Tipo ordem: Venda - Valor: R$ 25,50", a1.exibirOrdens());
		
		i4.registrarOrdem(a1, "Compra", 25.5);
		
		assertEquals(25.5, a1.getValor());
		
		i1.registrarOrdem(a1, "Venda", 31);
		assertEquals("Investidor associado: " + i1.getNome() + " - Tipo ordem: Venda - Valor: R$ 31,00", a1.exibirOrdens());
		
		i3.registrarPreOrdem(a1, "Venda", 33, 31);
		assertEquals("Investidor associado: " + i1.getNome() + " - Tipo ordem: Venda - Valor: R$ 31,00", a1.exibirOrdens());
		
		i2.registrarOrdem(a1, "Compra", 31);
		
		assertEquals("Investidor associado: " + i3.getNome() + " - Tipo ordem: Venda - Valor: R$ 33,00", a1.exibirOrdens());
		
		i4.registrarOrdem(a1, "Compra", 33);
		
		assertEquals(33, a1.getValor());
		
		i1.registrarOrdem(a1, "Venda", 43.5);
		assertEquals("Investidor associado: " + i1.getNome() + " - Tipo ordem: Venda - Valor: R$ 43,50", a1.exibirOrdens());
		
		i2.registrarOrdem(a1, "Compra", 43.5);
		
		assertEquals(43.5, a1.getValor());
		
		i3.registrarPreOrdem(a1, "Venda", 46, 43.5);
		assertEquals("Investidor associado: " + i3.getNome() + " - Tipo ordem: Venda - Valor: R$ 46,00", a1.exibirOrdens());
		
		i4.registrarOrdem(a1, "Compra", 46);
		
		assertEquals(46, a1.getValor());
	}
	
	@Test
	void testAdicional() {
		Acao a1 = new Acao("Banco do Brasil", 0);
		
		Investidor i1 = new Investidor("Mariana");
		Investidor i2 = new Investidor("Joaquim");
		Investidor i3 = new Investidor("Thiago");
		Investidor i4 = new Investidor("André");
		Investidor i5 = new Investidor("Paulo");
		
		i1.registrarEmAcao(a1);
		
		i2.registrarPreOrdem(a1, "Venda", 50, 45);
		i2.registrarPreOrdem(a1, "Compra", 45, 40);
		i1.registrarPreOrdem(a1, "Venda", 47, 40);
		
		i3.registrarOrdem(a1, "Compra", 50);
		
		i4.registrarOrdem(a1, "Venda", 45);
		
		i5.registrarOrdem(a1, "Compra", 45);
		
		assertEquals(50, a1.getValor());
		
		assertEquals("Notificação para: Mariana\nO valor da ação Banco do Brasil alterou!\nNovo valor da ação: R$ 45,00\nNotificação para: Mariana\n"
					+ "O valor da ação Banco do Brasil alterou!\nNovo valor da ação: R$ 50,00", i1.verNotificacoes());
		
		i3.registrarOrdem(a1, "Venda", 40);
		
		i4.registrarOrdem(a1, "Compra", 40);
		
		assertEquals(40, a1.getValor());
		
		assertEquals("Investidor associado: Joaquim - Tipo ordem: Compra - Valor: R$ 45,00\nInvestidor associado: Mariana - Tipo ordem: Venda - Valor: "
					+ "R$ 47,00", a1.exibirOrdens());
	}
}
