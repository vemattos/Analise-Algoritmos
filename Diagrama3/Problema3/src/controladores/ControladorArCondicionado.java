package controladores;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import java.util.ArrayList;
import java.util.List;

class ControladorArCondicionado {
	private List<Object> listaArCondicionado;
	
	public ControladorArCondicionado() {
		listaArCondicionado = new ArrayList<>();
	}
	
	public void addArCondicionado(Object arCondicionado) {
		listaArCondicionado.add(arCondicionado);
	}
	
	public void removeArCondicionado(Object arCondicionado) {
		listaArCondicionado.remove(arCondicionado);
	}
	
	public void ligarArCondicionado() {
		for (Object o : listaArCondicionado) {
			if (o instanceof ArCondicionadoGellaKaza) {
				ArCondicionadoGellaKaza ar = (ArCondicionadoGellaKaza) o;
				ar.ativar();
			} else {
				ArCondicionadoVentoBaumn ar = (ArCondicionadoVentoBaumn) o;
				ar.ligar();
			}
		}
	}
	
	public void desligarArCondicionado() {
		for (Object o : listaArCondicionado) {
			if (o instanceof ArCondicionadoGellaKaza) {
				ArCondicionadoGellaKaza ar = (ArCondicionadoGellaKaza) o;
				ar.desativar();
			} else {
				ArCondicionadoVentoBaumn ar = (ArCondicionadoVentoBaumn) o;
				ar.desligar();
			}
		}
	}
	
	public void aumentarTemperaturaArCondicionado() {
		for (Object o : listaArCondicionado) {
			if (o instanceof ArCondicionadoGellaKaza) {
				ArCondicionadoGellaKaza ar = (ArCondicionadoGellaKaza) o;
				ar.aumentarTemperatura();
			} else {
				ArCondicionadoVentoBaumn ar = (ArCondicionadoVentoBaumn) o;
				ar.definirTemperatura(ar.getTemperatura() + 1);
			}
		}
	}
	
	public void diminuirTemperaturaArCondicionado() {
		for (Object o : listaArCondicionado) {
			if (o instanceof ArCondicionadoGellaKaza) {
				ArCondicionadoGellaKaza ar = (ArCondicionadoGellaKaza) o;
				ar.diminuirTemperatura();
			} else {
				ArCondicionadoVentoBaumn ar = (ArCondicionadoVentoBaumn) o;
				ar.definirTemperatura(ar.getTemperatura() - 1);
			}
		}
	}
	
	public void definirTemperaturaArCondicionado(int temperatura) {
		for (Object o : listaArCondicionado) {
			if (o instanceof ArCondicionadoGellaKaza) {
				ArCondicionadoGellaKaza ar = (ArCondicionadoGellaKaza) o;
				while (ar.getTemperatura() != temperatura) {
					if (ar.getTemperatura() > temperatura) {
						ar.diminuirTemperatura();
					} else {
						ar.aumentarTemperatura();
					}
				}
			} else {
				ArCondicionadoVentoBaumn ar = (ArCondicionadoVentoBaumn) o;
				ar.definirTemperatura(temperatura);
			}
		}
	}
}
