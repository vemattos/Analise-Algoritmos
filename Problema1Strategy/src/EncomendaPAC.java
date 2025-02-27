
public class EncomendaPAC implements TipoEntrega {

	public double calcularValorEntrega(Pedido p) {
		double pesoTotal = p.calcularPesoTotal();
		
		if (pesoTotal < 1000)
			return 10;
		
		if (pesoTotal >= 1000 && pesoTotal < 2000)
			return 15;
		
		if (pesoTotal >= 2000 && pesoTotal < 3000)
			return 20;
		
		if (pesoTotal >= 3000 && pesoTotal <= 5000)
			return 30;
		
		return -1;
	}
}
