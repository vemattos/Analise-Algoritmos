
public class Sedex implements TipoEntrega {

	public double calcularValorEntrega(Pedido p) {
		double pesoTotal = p.calcularPesoTotal();
		
		if (pesoTotal < 500)
			return 12.5;
		
		if (pesoTotal >= 500 && pesoTotal < 750)
			return 20;
		
		if (pesoTotal >= 750 && pesoTotal < 1200)
			return 30;
		
		if (pesoTotal >= 1200 && pesoTotal <= 2000)
			return 45;
		
		pesoTotal -= 2000;
		pesoTotal /= 100.0;
		
		return (1.5 * pesoTotal) + 46.5;
	}
	
}
