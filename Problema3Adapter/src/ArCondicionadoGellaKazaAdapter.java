import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;

public class ArCondicionadoGellaKazaAdapter implements ArCondicionado {
	private ArCondicionadoGellaKaza arCondicionadoGellaKaza;
	
	public ArCondicionadoGellaKazaAdapter(ArCondicionadoGellaKaza arCondicionadoGellaKaza) {
		this.arCondicionadoGellaKaza = arCondicionadoGellaKaza;
	}

	@Override
	public void ligar() {
		arCondicionadoGellaKaza.ativar();
	}

	@Override
	public void desligar() {
		arCondicionadoGellaKaza.desativar();
	}

	@Override
	public void aumentarTemperatura() {
		arCondicionadoGellaKaza.aumentarTemperatura();
	}

	@Override
	public void diminuirTemperatura() {
		arCondicionadoGellaKaza.diminuirTemperatura();
	}

	@Override
	public void definirTemperatura(int temperatura) {
		while (arCondicionadoGellaKaza.getTemperatura() > temperatura)
			arCondicionadoGellaKaza.diminuirTemperatura();
		while (arCondicionadoGellaKaza.getTemperatura() < temperatura)
			arCondicionadoGellaKaza.aumentarTemperatura();
	}
}
