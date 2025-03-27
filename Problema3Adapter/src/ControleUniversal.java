import java.util.ArrayList;
import java.util.List;

import br.furb.analise.algoritmos.*;

public class ControleUniversal {
	private List<Object> listaDispositivos;
	
	public ControleUniversal() {
		listaDispositivos = new ArrayList<>();
	}
	
	public void addDispositivo(Object dispositivo) {
		listaDispositivos.add(dispositivo);
	}
	
	public void removeDispositivo(Object dispositivo) {
		listaDispositivos.remove(dispositivo);
	}
	
	public void ligarArCondicionado() {
		for (Object d : listaDispositivos) {
			if (d instanceof ArCondicionadoGellaKaza) {
				ArCondicionado a = new ArCondicionadoGellaKazaAdapter((ArCondicionadoGellaKaza)d);
				a.ligar();
			}
			if (d instanceof ArCondicionadoVentoBaumn) {
				ArCondicionado a = new ArCondicionadoVentoBaumnAdapter((ArCondicionadoVentoBaumn)d);
				a.ligar();
			}
		}
	}
	
	public void desligarArCondicionado() {
		for (Object d : listaDispositivos) {
			if (d instanceof ArCondicionadoGellaKaza) {
				ArCondicionado a = new ArCondicionadoGellaKazaAdapter((ArCondicionadoGellaKaza)d);
				a.desligar();
			}
			if (d instanceof ArCondicionadoVentoBaumn) {
				ArCondicionado a = new ArCondicionadoVentoBaumnAdapter((ArCondicionadoVentoBaumn)d);
				a.desligar();
			}
		}
	}
	
	public void aumentarTemperaturaArCondicionado() {
		for (Object d : listaDispositivos) {
			if (d instanceof ArCondicionadoGellaKaza) {
				ArCondicionado a = new ArCondicionadoGellaKazaAdapter((ArCondicionadoGellaKaza)d);
				a.aumentarTemperatura();
			}
			if (d instanceof ArCondicionadoVentoBaumn) {
				ArCondicionado a = new ArCondicionadoVentoBaumnAdapter((ArCondicionadoVentoBaumn)d);
				a.aumentarTemperatura();
			}
		}
	}
	
	public void diminuirTemperaturaArCondicionado() {
		for (Object d : listaDispositivos) {
			if (d instanceof ArCondicionadoGellaKaza) {
				ArCondicionado a = new ArCondicionadoGellaKazaAdapter((ArCondicionadoGellaKaza)d);
				a.diminuirTemperatura();
			}
			if (d instanceof ArCondicionadoVentoBaumn) {
				ArCondicionado a = new ArCondicionadoVentoBaumnAdapter((ArCondicionadoVentoBaumn)d);
				a.diminuirTemperatura();
			}
		}
	}
	
	public void definirTemperaturaArCondicionado(int temperatura) {
		for (Object d : listaDispositivos) {
			if (d instanceof ArCondicionadoGellaKaza) {
				ArCondicionado a = new ArCondicionadoGellaKazaAdapter((ArCondicionadoGellaKaza)d);
				a.definirTemperatura(temperatura);
			}
			if (d instanceof ArCondicionadoVentoBaumn) {
				ArCondicionado a = new ArCondicionadoVentoBaumnAdapter((ArCondicionadoVentoBaumn)d);
				a.definirTemperatura(temperatura);
			}
		}
	}
	
	public void ligarLampada() {
		for (Object d : listaDispositivos) {
			if (d instanceof LampadaPhellipes) {
				Lampada l = new LampadaPhellipesAdapter((LampadaPhellipes)d);
				l.ligar();
			}
			if (d instanceof LampadaShoyuMi) {
				Lampada l = new LampadaShoyuMiAdapter((LampadaShoyuMi)d);
				l.ligar();
			}
		}
	}
	
	public void desligarLampada() {
		for (Object d : listaDispositivos) {
			if (d instanceof LampadaPhellipes) {
				Lampada l = new LampadaPhellipesAdapter((LampadaPhellipes)d);
				l.desligar();
			}
			if (d instanceof LampadaShoyuMi) {
				Lampada l = new LampadaShoyuMiAdapter((LampadaShoyuMi)d);
				l.desligar();
			}
		}
	}
	
	public void abrirPersiana() {
		for (Object d : listaDispositivos) {
			if (d instanceof PersianaNatLight) {
				Persiana p = new PersianaNatLightAdapter((PersianaNatLight)d);
				p.abrir();
			}
			if (d instanceof PersianaSolarius) {
				Persiana p = new PersianaSolariusAdapter((PersianaSolarius)d);
				p.abrir();
			}
		}
	}
	
	public void fecharPersiana() {
		for (Object d : listaDispositivos) {
			if (d instanceof PersianaNatLight) {
				Persiana p = new PersianaNatLightAdapter((PersianaNatLight)d);
				p.fechar();
			}
			if (d instanceof PersianaSolarius) {
				Persiana p = new PersianaSolariusAdapter((PersianaSolarius)d);
				p.fechar();
			}
		}
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
