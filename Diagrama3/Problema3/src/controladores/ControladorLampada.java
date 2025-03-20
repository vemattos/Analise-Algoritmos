package controladores;

import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import java.util.ArrayList;
import java.util.List;

class ControladorLampada {
	private List<Object> listaLampada;
	
	public ControladorLampada() {
		listaLampada = new ArrayList<>();
	}
	
	public void addLampada(Object lampada) {
		listaLampada.add(lampada);
	}
	
	public void removeLampada(Object lampada) {
		listaLampada.remove(lampada);
	}
	
	public void ligarLampada() {
		for (Object o : listaLampada) {
			if (o instanceof LampadaPhellipes) {
				LampadaPhellipes lampada = (LampadaPhellipes) o;
				lampada.setIntensidade(100);
			} else {
				LampadaShoyuMi lampada = (LampadaShoyuMi) o;
				lampada.ligar();
			}
		}
	}
	
	public void desligarLampada() {
		for (Object o : listaLampada) {
			if (o instanceof LampadaPhellipes) {
				LampadaPhellipes lampada = (LampadaPhellipes) o;
				lampada.setIntensidade(0);
			} else {
				LampadaShoyuMi lampada = (LampadaShoyuMi) o;
				lampada.desligar();
			}
		}
	}
}
