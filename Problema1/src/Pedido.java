import java.util.ArrayList;

public class Pedido {
	private ArrayList<Produto> listaProdutos;
	private TipoEntrega tipoEntrega;
	
	public Pedido(TipoEntrega tipoEntrega) {
		setTipoEntrega(tipoEntrega);
		listaProdutos = new ArrayList<>();
	}

	public TipoEntrega getTipoEntrega() {
		return tipoEntrega;
	}

	public void setTipoEntrega(TipoEntrega tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}
	
	public void addProduto(Produto p) {
		listaProdutos.add(p);
	}
	
	private double calcularPesoTotal() {
		double pesoTotal = 0;
		
		for (Produto p : listaProdutos) {
			pesoTotal += p.getPeso();
		}
		
		return pesoTotal;
	}
	
	public double calcularValorEntrega() {
		return tipoEntrega.calcularValorEntrega(calcularPesoTotal());
	}
}
