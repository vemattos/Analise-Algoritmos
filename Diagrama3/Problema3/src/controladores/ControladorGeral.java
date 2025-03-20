package controladores;

import br.furb.analise.algoritmos.*;

public class ControladorGeral {
	private static ControladorGeral uniqueInstance;
	private ControladorArCondicionado cArCondicionado;
	private ControladorLampada cLampada;
	private ControladorPersiana cPersiana;
	
	private ControladorGeral() {
		cArCondicionado = new ControladorArCondicionado();
		cLampada = new ControladorLampada();
		cPersiana = new ControladorPersiana();
	}
	
	public static ControladorGeral getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ControladorGeral();
		}
		return uniqueInstance;
	}
	
	public void addArCondicionado(Object arCondicionado) {
		if (!(arCondicionado instanceof ArCondicionadoGellaKaza || 
				arCondicionado instanceof ArCondicionadoVentoBaumn))
			throw new IllegalArgumentException("Dispositivo de tipo incompativel");
		
		cArCondicionado.addArCondicionado(arCondicionado);
	}
	
	public void removeArCondicionado(Object arCondicionado) {
		if (!(arCondicionado instanceof ArCondicionadoGellaKaza || 
				arCondicionado instanceof ArCondicionadoVentoBaumn))
			throw new IllegalArgumentException("Dispositivo de tipo incompativel");
		cArCondicionado.removeArCondicionado(arCondicionado);
	}
	
	public void addLampada(Object lampada) {
		if (!(lampada instanceof LampadaPhellipes || 
				lampada instanceof LampadaShoyuMi))
			throw new IllegalArgumentException("Dispositivo de tipo incompativel");
		cLampada.addLampada(lampada);
	}
	
	public void removeLampada(Object lampada) {
		if (!(lampada instanceof LampadaPhellipes || 
				lampada instanceof LampadaShoyuMi))
			throw new IllegalArgumentException("Dispositivo de tipo incompativel");
		cLampada.removeLampada(lampada);
	}
	
	public void addPersiana(Object persiana) {
		if (!(persiana instanceof PersianaNatLight || 
				persiana instanceof PersianaSolarius))
			throw new IllegalArgumentException("Dispositivo de tipo incompativel");
		cPersiana.addPersiana(persiana);
	}
	
	public void removePersiana(Object persiana) {
		if (!(persiana instanceof PersianaNatLight || 
				persiana instanceof PersianaSolarius))
			throw new IllegalArgumentException("Dispositivo de tipo incompativel");
		cPersiana.removePersiana(persiana);
	}
	
	public void ligarArCondicionado() {
		cArCondicionado.ligarArCondicionado();
	}
	
	public void desligarArCondicionado() {
		cArCondicionado.desligarArCondicionado();
	}
	
	public void aumentarTemperaturaArCondicionado() {
		cArCondicionado.aumentarTemperaturaArCondicionado();
	}
	
	public void diminuirTemperaturaArCondicionado() {
		cArCondicionado.diminuirTemperaturaArCondicionado();
	}
	
	public void definirTemperaturaArCondicionado(int temperatura) {
		cArCondicionado.definirTemperaturaArCondicionado(temperatura);
	}
	
	public void ligarLampada() {
		cLampada.ligarLampada();
	}
	
	public void desligarLampada() {
		cLampada.desligarLampada();
	}
	
	public void abrirPersiana() {
		cPersiana.abrirPersiana();
	}
	
	public void fecharPersiana() {
		cPersiana.fecharPersiana();
	}
	
	public void ativarModoSono() {
		desligarArCondicionado();
		desligarLampada();
		fecharPersiana();
	}
	
	public void ativarModoTrabalho() {
		ligarArCondicionado();
		definirTemperaturaArCondicionado(25);
		ligarLampada();
		abrirPersiana();
	}
}
