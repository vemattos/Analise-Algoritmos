import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.furb.analise.algoritmos.*;
import controladores.ControladorGeral;

class Problema3Test {

	private static ControladorGeral cGeral;
	private static ArCondicionadoGellaKaza a1;
	private static ArCondicionadoGellaKaza a2;
	private static ArCondicionadoVentoBaumn a3;
	private static ArCondicionadoVentoBaumn a4;
	private static LampadaPhellipes l1;
	private static LampadaPhellipes l2;
	private static LampadaShoyuMi l3;
	private static LampadaShoyuMi l4;
	private static PersianaNatLight p1;
	private static PersianaNatLight p2;
	private static PersianaSolarius p3;
	private static PersianaSolarius p4;
	
	@BeforeAll
	static void setUp() {
		cGeral = ControladorGeral.getInstance();
		a1 = new ArCondicionadoGellaKaza();
		a2 = new ArCondicionadoGellaKaza();
		a3 = new ArCondicionadoVentoBaumn();
		a4 = new ArCondicionadoVentoBaumn();
		l1 = new LampadaPhellipes();
		l2 = new LampadaPhellipes();
		l3 = new LampadaShoyuMi();
		l4 = new LampadaShoyuMi();
		p1 = new PersianaNatLight();
		p2 = new PersianaNatLight();
		p3 = new PersianaSolarius();
		p4 = new PersianaSolarius();
		cGeral.addArCondicionado(a1);
		cGeral.addArCondicionado(a2);
		cGeral.addArCondicionado(a3);
		cGeral.addArCondicionado(a4);
		cGeral.addLampada(l1);
		cGeral.addLampada(l2);
		cGeral.addLampada(l3);
		cGeral.addLampada(l4);
		cGeral.addPersiana(p1);
		cGeral.addPersiana(p2);
		cGeral.addPersiana(p3);
		cGeral.addPersiana(p4);
	}
	
	@Test
	void testLigarArCondicionado() {
		cGeral.desligarArCondicionado();
		
		assertEquals(false, a1.estaLigado());
		assertEquals(false, a2.estaLigado());
		assertEquals(false, a3.estaLigado());
		assertEquals(false, a4.estaLigado());
		
		cGeral.ligarArCondicionado();
		
		assertEquals(true, a1.estaLigado());
		assertEquals(true, a2.estaLigado());
		assertEquals(true, a3.estaLigado());
		assertEquals(true, a4.estaLigado());
	}
	
	@Test
	void testDesligarArCondicionado() {
		cGeral.ligarArCondicionado();
		
		assertEquals(true, a1.estaLigado());
		assertEquals(true, a2.estaLigado());
		assertEquals(true, a3.estaLigado());
		assertEquals(true, a4.estaLigado());
		
		cGeral.desligarArCondicionado();
		
		assertEquals(false, a1.estaLigado());
		assertEquals(false, a2.estaLigado());
		assertEquals(false, a3.estaLigado());
		assertEquals(false, a4.estaLigado());
	}
	
	@Test
	void testAumentarTemperaturaArCondicionado() {
		int t1 = a1.getTemperatura();
		int t2 = a2.getTemperatura();
		int t3 = a3.getTemperatura();
		int t4 = a4.getTemperatura();
		
		assertEquals(true, ((t1 + 1) <= 35));
		assertEquals(true, ((t2 + 1) <= 35));
		assertEquals(true, ((t3 + 1) <= 35));
		assertEquals(true, ((t4 + 1) <= 35));
		
		cGeral.aumentarTemperaturaArCondicionado();
		
		assertEquals((t1 + 1), a1.getTemperatura());
		assertEquals((t2 + 1), a2.getTemperatura());
		assertEquals((t3 + 1), a3.getTemperatura());
		assertEquals((t4 + 1), a4.getTemperatura());
	}
	
	@Test
	void testDiminuirTemperaturaArCondicionado() {
		int t1 = a1.getTemperatura();
		int t2 = a2.getTemperatura();
		int t3 = a3.getTemperatura();
		int t4 = a4.getTemperatura();
		
		assertEquals(true, ((t1 - 1) >= 15));
		assertEquals(true, ((t2 - 1) >= 15));
		assertEquals(true, ((t3 - 1) >= 15));
		assertEquals(true, ((t4 - 1) >= 15));
		
		cGeral.diminuirTemperaturaArCondicionado();
		
		assertEquals((t1 - 1), a1.getTemperatura());
		assertEquals((t2 - 1), a2.getTemperatura());
		assertEquals((t3 - 1), a3.getTemperatura());
		assertEquals((t4 - 1), a4.getTemperatura());
	}
	
	@Test
	void testDefinirTemperaturaArCondicionado() {
		assertNotEquals(22, a1.getTemperatura());
		assertNotEquals(22, a2.getTemperatura());
		assertNotEquals(22, a3.getTemperatura());
		assertNotEquals(22, a4.getTemperatura());
		
		cGeral.ligarArCondicionado();
		cGeral.definirTemperaturaArCondicionado(22);
		
		assertEquals(22, a1.getTemperatura());
		assertEquals(22, a2.getTemperatura());
		assertEquals(22, a3.getTemperatura());
		assertEquals(22, a4.getTemperatura());
	}
	
	@Test
	void testLigarLampada() {
		cGeral.desligarLampada();
		
		assertEquals(0, l1.getIntensidade());
		assertEquals(0, l2.getIntensidade());
		assertEquals(false, l3.estaLigada());
		assertEquals(false, l4.estaLigada());
		
		cGeral.ligarLampada();
		
		assertEquals(100, l1.getIntensidade());
		assertEquals(100, l2.getIntensidade());
		assertEquals(true, l3.estaLigada());
		assertEquals(true, l4.estaLigada());
	}
	
	@Test
	void testDesligarLampada() {
		cGeral.ligarLampada();
		
		assertEquals(100, l1.getIntensidade());
		assertEquals(100, l2.getIntensidade());
		assertEquals(true, l3.estaLigada());
		assertEquals(true, l4.estaLigada());
		
		cGeral.desligarLampada();
		
		assertEquals(0, l1.getIntensidade());
		assertEquals(0, l2.getIntensidade());
		assertEquals(false, l3.estaLigada());
		assertEquals(false, l4.estaLigada());
	}
	
	@Test
	void testAbrirPersiana() {
		cGeral.fecharPersiana();
		
		assertEquals(false, p1.estaPalhetaErguida());
		assertEquals(false, p2.estaPalhetaErguida());
		assertEquals(false, p3.estaAberta());
		assertEquals(false, p4.estaAberta());
		
		cGeral.abrirPersiana();
		
		assertEquals(true, p1.estaPalhetaErguida());
		assertEquals(true, p2.estaPalhetaErguida());
		assertEquals(true, p3.estaAberta());
		assertEquals(true, p4.estaAberta());
	}
	
	@Test
	void testFecharPersiana() {
		cGeral.abrirPersiana();
		
		assertEquals(true, p1.estaPalhetaErguida());
		assertEquals(true, p2.estaPalhetaErguida());
		assertEquals(true, p3.estaAberta());
		assertEquals(true, p4.estaAberta());
		
		cGeral.fecharPersiana();
		
		assertEquals(false, p1.estaPalhetaErguida());
		assertEquals(false, p2.estaPalhetaErguida());
		assertEquals(false, p3.estaAberta());
		assertEquals(false, p4.estaAberta());
	}
	
	@Test
	void testModoSono() {
		cGeral.ligarArCondicionado();
		cGeral.ligarLampada();
		cGeral.abrirPersiana();
		
		assertNotEquals(false, a1.estaLigado());
		assertNotEquals(false, a2.estaLigado());
		assertNotEquals(false, a3.estaLigado());
		assertNotEquals(false, a4.estaLigado());
		assertNotEquals(0, l1.getIntensidade());
		assertNotEquals(0, l2.getIntensidade());
		assertNotEquals(false, l3.estaLigada());
		assertNotEquals(false, l4.estaLigada());
		assertNotEquals(false, p1.estaPalhetaErguida());
		assertNotEquals(false, p2.estaPalhetaErguida());
		assertNotEquals(false, p3.estaAberta());
		assertNotEquals(false, p4.estaAberta());
		
		cGeral.ativarModoSono();
		
		assertEquals(false, a1.estaLigado());
		assertEquals(false, a2.estaLigado());
		assertEquals(false, a3.estaLigado());
		assertEquals(false, a4.estaLigado());
		assertEquals(0, l1.getIntensidade());
		assertEquals(0, l2.getIntensidade());
		assertEquals(false, l3.estaLigada());
		assertEquals(false, l4.estaLigada());
		assertEquals(false, p1.estaPalhetaErguida());
		assertEquals(false, p2.estaPalhetaErguida());
		assertEquals(false, p3.estaAberta());
		assertEquals(false, p4.estaAberta());
	}
	
	@Test
	void testModoTrabalho() {
		cGeral.ligarArCondicionado();
		cGeral.definirTemperaturaArCondicionado(18);
		cGeral.desligarArCondicionado();
		cGeral.desligarLampada();
		cGeral.fecharPersiana();
		
		assertNotEquals(true, a1.estaLigado());
		assertNotEquals(true, a2.estaLigado());
		assertNotEquals(true, a3.estaLigado());
		assertNotEquals(true, a4.estaLigado());
		assertNotEquals(25, a1.getTemperatura());
		assertNotEquals(25, a2.getTemperatura());
		assertNotEquals(25, a3.getTemperatura());
		assertNotEquals(25, a4.getTemperatura());
		assertNotEquals(100, l1.getIntensidade());
		assertNotEquals(100, l2.getIntensidade());
		assertNotEquals(true, l3.estaLigada());
		assertNotEquals(true, l4.estaLigada());
		assertNotEquals(true, p1.estaPalhetaErguida());
		assertNotEquals(true, p2.estaPalhetaErguida());
		assertNotEquals(true, p3.estaAberta());
		assertNotEquals(true, p4.estaAberta());
		
		cGeral.ativarModoTrabalho();
		
		assertEquals(true, a1.estaLigado());
		assertEquals(true, a2.estaLigado());
		assertEquals(true, a3.estaLigado());
		assertEquals(true, a4.estaLigado());
		assertEquals(25, a1.getTemperatura());
		assertEquals(25, a2.getTemperatura());
		assertEquals(25, a3.getTemperatura());
		assertEquals(25, a4.getTemperatura());
		assertEquals(100, l1.getIntensidade());
		assertEquals(100, l2.getIntensidade());
		assertEquals(true, l3.estaLigada());
		assertEquals(true, l4.estaLigada());
		assertEquals(true, p1.estaPalhetaErguida());
		assertEquals(true, p2.estaPalhetaErguida());
		assertEquals(true, p3.estaAberta());
		assertEquals(true, p4.estaAberta());
	}
	
}
