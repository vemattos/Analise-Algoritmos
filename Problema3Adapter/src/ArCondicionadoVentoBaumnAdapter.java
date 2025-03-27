import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;

public class ArCondicionadoVentoBaumnAdapter implements ArCondicionado {
	private ArCondicionadoVentoBaumn arCondicionadoVentoBaumn;
	
	public ArCondicionadoVentoBaumnAdapter(ArCondicionadoVentoBaumn arCondicionadoVentoBaumn) {
		this.arCondicionadoVentoBaumn = arCondicionadoVentoBaumn;
	}

	@Override
	public void ligar() {
		arCondicionadoVentoBaumn.ligar();
	}

	@Override
	public void desligar() {
		arCondicionadoVentoBaumn.desligar();
	}

	@Override
	public void aumentarTemperatura() {
		arCondicionadoVentoBaumn.definirTemperatura(arCondicionadoVentoBaumn.getTemperatura() + 1);
	}

	@Override
	public void diminuirTemperatura() {
		arCondicionadoVentoBaumn.definirTemperatura(arCondicionadoVentoBaumn.getTemperatura() - 1);
	}

	@Override
	public void definirTemperatura(int temperatura) {
		arCondicionadoVentoBaumn.definirTemperatura(temperatura);
	}
}
