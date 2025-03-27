import br.furb.analise.algoritmos.LampadaShoyuMi;

public class LampadaShoyuMiAdapter implements Lampada {
	private LampadaShoyuMi lampadaShoyuMi;
	
	public LampadaShoyuMiAdapter(LampadaShoyuMi lampadaShoyuMi) {
		this.lampadaShoyuMi = lampadaShoyuMi;
	}

	@Override
	public void ligar() {
		lampadaShoyuMi.ligar();
	}

	@Override
	public void desligar() {
		lampadaShoyuMi.desligar();
	}
}
